package com.utilidades;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Arambula
 */
public class Updater {

    private static final URI VERSION_URI = URI.create("https://raw.githubusercontent.com/arambula357/ReparaLab/main/version.txt");

    // Método para verificar si existe una conexión a internet estable.
    public static boolean ConfirmarConexion() {
        try {
            URL urlConfirmar = VERSION_URI.toURL();
            URLConnection con = urlConfirmar.openConnection();
            con.connect();
            return true;
        } catch (IOException ex) {
//            System.err.println("Error en la conexión: " + ex.getMessage());
        }
        return false;
    }

    /*
     * Método para confirmar la conexión con el archivo de la version mas reciente en línea
     * Este método se une con "ObtenerContenidoUrlVersion"
     */
    public static String ObtenerVersion() {
        try {
            URL urlVerificar = VERSION_URI.toURL();
            URLConnection con = urlVerificar.openConnection();
            con.connect();
            return ObtenerContenidoUrlVersion(urlVerificar);
        } catch (IOException ex) {
//            System.err.println("Error en la conexión: " + ex.getMessage());
        }
        return null;
    }

    /*
     * Metodo para recuperar el contenido del archivo de versión
     */
    public static String ObtenerContenidoUrlVersion(URL urlVerificar) {
        try {
            try (Scanner scanner = new Scanner(urlVerificar.openStream(), java.nio.charset.StandardCharsets.UTF_8).useDelimiter("\\Z")) {
                return scanner.hasNext() ? scanner.next() : null;
            }
        } catch (IOException ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public static void EnlazarDescarga() {
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/arambula357/ReparaLab/releases"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
