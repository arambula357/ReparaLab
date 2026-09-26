package com.utilidades;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
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

    // Método para verificar si existe una conexión a internet estable.
    public static boolean ConfirmarConexion() {
        try {
            URL urlConfirmar = new URL("https://raw.githubusercontent.com/arambula357/ReparaLab/main/version.txt");
            URLConnection con = urlConfirmar.openConnection();
            con.connect();
            return true;
        } catch (MalformedURLException ex) {
//            System.err.println("Error en url: " + ex.getMessage());
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
            URL urlVerificar = new URL("https://raw.githubusercontent.com/arambula357/ReparaLab/main/version.txt");
            URLConnection con = urlVerificar.openConnection();
            con.connect();
            return ObtenerContenidoUrlVersion(urlVerificar);
        } catch (MalformedURLException ex) {
//            System.err.println("Error en url: " + ex.getMessage());
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
            Scanner s = new Scanner(urlVerificar.openStream()).useDelimiter("\\Z");
            String contenido = s.next();
            return contenido;
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
