package com.utilidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {
    @Test
    void newPasswordsUseUniqueHashesAndRejectWrongPassword() {
        String first = PasswordUtil.hash("clave segura");
        String second = PasswordUtil.hash("clave segura");
        assertNotEquals(first, second);
        assertTrue(PasswordUtil.verify("clave segura", first));
        assertFalse(PasswordUtil.verify("otra clave", first));
        assertFalse(PasswordUtil.isLegacy(first));
    }

    @Test
    void legacyPasswordCanBeVerifiedForMigration() {
        assertTrue(PasswordUtil.isLegacy("clave antigua"));
        assertTrue(PasswordUtil.verify("clave antigua", "clave antigua"));
        assertFalse(PasswordUtil.verify("otra", "clave antigua"));
    }

    @Test
    void malformedHashIsRejected() {
        assertFalse(PasswordUtil.verify("x", "$pbkdf2-sha256$invalid"));
        assertFalse(PasswordUtil.verify(null, "x"));
    }
}
