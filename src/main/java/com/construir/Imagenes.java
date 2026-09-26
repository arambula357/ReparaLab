package com.construir;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Diego Arambula
 */
public class Imagenes {

    public static void setImagenFondo(JLabel Wallpaper) {
        ImageIcon fondo = new ImageIcon("images/wallpaperPrincipal.jpg");
        Icon ico = new ImageIcon(fondo.getImage().getScaledInstance(Wallpaper.getWidth(), Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        Wallpaper.setIcon(ico);
        Wallpaper.repaint();
    }

    public static void setImagenBoton(JButton boton, String ruta, boolean margen) {
        if (margen) {
            ImageIcon ImageBoton = new ImageIcon(ruta);
            Icon iconoBoton = new ImageIcon(ImageBoton.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT));
            boton.setIcon(iconoBoton);
        } else {
            ImageIcon ImageBoton = new ImageIcon(ruta);
            Icon iconoBoton = new ImageIcon(ImageBoton.getImage());
            boton.setIcon(iconoBoton);
        }
    }

}
