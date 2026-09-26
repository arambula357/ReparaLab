package com.bd;

import com.utilidades.Utilidades;
import com.utilidades.PasswordUtil;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego Arambula
 */
public class Registrar {

    public static void RegistroInicioTurno(double cantidad, String fecha, String usuario) {

        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into inicioturno (`id_inicioturno`, `cantidad`, `fecha`, `usuario`) values (?,?,?,?)");

                pst.setInt(1, 0);
                pst.setDouble(2, cantidad);
                pst.setString(3, fecha);
                pst.setString(4, usuario);

                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (SQLException e) {
            System.out.println("Error al registrar la cantidad de inicio de turno " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar la cantidad de inicio de turno,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void RegistrarUsuario(String[] infoUsuario) {
        try {

            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into usuarios values (?,?,?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setString(2, infoUsuario[0]);
                pst.setString(3, infoUsuario[1]);
                pst.setString(4, infoUsuario[2]);
                pst.setString(5, infoUsuario[3]);
                pst.setString(6, PasswordUtil.hash(infoUsuario[4]));
                pst.setString(7, infoUsuario[5]);
                pst.setString(8, "Activo");
                pst.setString(9, Utilidades.getUsuarioActivo());

                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error en registrar usuario en la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en registrar usuario en la base de datos,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void RegistrarCliente(String nombreCliente, String telefono) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into clientes values (?,?,?,?)");

                pst.setInt(1, 0);
                pst.setString(2, nombreCliente);
                pst.setString(3, telefono);
                pst.setString(4, Utilidades.getUsuarioActivo());

                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error en registrar cliente en la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en registrar cliente en la base de datos,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void RegistrarEquipo(int idCliente, String[] infoEquipo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setInt(2, idCliente);
                pst.setString(3, infoEquipo[0]);
                pst.setString(4, infoEquipo[1]);
                pst.setString(5, infoEquipo[2]);
                pst.setString(6, infoEquipo[3]);
                pst.setString(7, infoEquipo[4]);
                pst.setString(8, infoEquipo[5]);
                pst.setString(9, infoEquipo[6]);
                pst.setString(10, infoEquipo[7]);
                pst.setString(11, infoEquipo[8]);
                pst.setString(12, infoEquipo[9]);
                pst.setString(13, Utilidades.getUsuarioActivo());
                pst.setString(14, "");
                pst.setString(15, "");

                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error en registrar equipo en la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en registrar equipo en la base de datos,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void RegistrarProducto(String[] info) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into articulos values (?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setString(2, info[0]);
                pst.setString(3, info[1]);
                pst.setString(4, info[2]);
                pst.setString(5, info[3]);
                pst.setString(6, info[4]);
                pst.setString(7, Utilidades.getUsuarioActivo());

                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar producto,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void RegistrarServicio(String[] info) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into articulos values (?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setString(2, info[0]);
                pst.setString(3, info[1]);
                pst.setString(4, "");
                pst.setString(5, info[2]);
                pst.setString(6, info[3]);
                pst.setString(7, Utilidades.getUsuarioActivo());

                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar servicio: " + e);
            JOptionPane.showMessageDialog(null, "Error al registrar servicio,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void RegistrarSumatoria(int idVenta, String[] cantidad, String[] codigo, String[] nombre, String[] precio, String tipoVenta, int filas) {
        Date dateSQL = Utilidades.fechaSQL();

        for (int i = 0; i < filas; i++) {
            try {
                try ( Connection cn = Conexion.getConexion()) {
                    PreparedStatement pst = cn.prepareStatement("insert into sumatoria values (?,?,?,?,?,?,?,?,?)");

                    pst.setInt(1, 0);
                    pst.setInt(2, idVenta);
                    pst.setInt(3, Integer.parseInt(cantidad[i]));
                    pst.setString(4, codigo[i]);
                    pst.setString(5, nombre[i]);
                    pst.setDouble(6, Double.parseDouble(precio[i]));
                    pst.setDate(7, dateSQL);
                    pst.setString(8, tipoVenta);
                    pst.setString(9, "Correcta");

                    pst.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println("Error al registrar la sumatoria de articulos: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al registrar la sumatoria de articulos,\n"
                        + "Revisa tu conexión a internet o llama al administrador,\n"
                        + "Error: " + e.getMessage(),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void RegistrarVenta(int idCliente, int idEquipo, String[] infoVenta) {
        Date dateSQL = Utilidades.fechaSQL();
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into ventas values (?,?,?,?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setInt(2, idCliente);
                pst.setInt(3, idEquipo);
                pst.setString(4, infoVenta[0]);
                pst.setString(5, infoVenta[1]);
                pst.setString(6, infoVenta[2]);
                pst.setDate(7, dateSQL);
                pst.setString(8, Consultar.ConsultarNombreUsuario(Utilidades.getUsuarioActivo()));
                pst.setString(9, "Correcta");
                pst.setString(10, "");

                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en registrar venta en la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en registrar venta en la base de datos,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void RegistrarSalida(String cantidad, String concepto, String nombreUsuario) {
        Date dateSQL = Utilidades.fechaSQL();
        String horaActual = Utilidades.HoraActual();

        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("insert into salidas values (?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setDouble(2, Double.parseDouble(cantidad));
                pst.setString(3, concepto);
                pst.setDate(4, dateSQL);
                pst.setString(5, horaActual);
                pst.setString(6, nombreUsuario);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salida exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar salida de efectivo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar salida de efectivo,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error:" + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*Declaración de objetos y variables de clase*/
}
