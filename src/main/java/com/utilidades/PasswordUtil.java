package com.utilidades;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/** Hash y verificacion de contrasenas; admite registros heredados durante la migracion. */
public final class PasswordUtil {
    private static final String PREFIX = "$pbkdf2-sha256$";
    private static final int ITERATIONS = 310000;
    private static final int SALT_BYTES = 16;
    private static final int KEY_BITS = 256;

    private PasswordUtil() {}

    public static String hash(String password) {
        byte[] salt = new byte[SALT_BYTES];
        new SecureRandom().nextBytes(salt);
        byte[] derived = derive(password, salt, ITERATIONS);
        return PREFIX + ITERATIONS + "$"
                + Base64.getEncoder().encodeToString(salt) + "$"
                + Base64.getEncoder().encodeToString(derived);
    }

    public static boolean isLegacy(String stored) {
        return stored != null && !stored.startsWith(PREFIX);
    }

    public static boolean verify(String candidate, String stored) {
        if (candidate == null || stored == null) {
            return false;
        }
        if (!stored.startsWith(PREFIX)) {
            return MessageDigest.isEqual(candidate.getBytes(StandardCharsets.UTF_8),
                    stored.getBytes(StandardCharsets.UTF_8));
        }
        try {
            String[] fields = stored.substring(PREFIX.length()).split("\\$", -1);
            if (fields.length != 3) {
                return false;
            }
            int iterations = Integer.parseInt(fields[0]);
            if (iterations < 10000 || iterations > 1000000) {
                return false;
            }
            byte[] salt = Base64.getDecoder().decode(fields[1]);
            byte[] expected = Base64.getDecoder().decode(fields[2]);
            if (salt.length != SALT_BYTES || expected.length != KEY_BITS / 8) {
                return false;
            }
            return MessageDigest.isEqual(expected, derive(candidate, salt, iterations));
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private static byte[] derive(String password, byte[] salt, int iterations) {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, KEY_BITS);
        try {
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        } catch (GeneralSecurityException ex) {
            throw new IllegalStateException("No se pudo derivar el hash", ex);
        } finally {
            spec.clearPassword();
        }
    }
}
