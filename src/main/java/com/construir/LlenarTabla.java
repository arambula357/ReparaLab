package com.construir;

import com.bd.Conexion;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Arambula
 */
public class LlenarTabla {

    public static void LlenarTablaUsuarios(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla  de usuarios: " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla  de usuarios,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void LlenarTablaClientes(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de clientes: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de clientes,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void LlenarTablaEquipos(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de equipos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de equipos,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void LlenarTablaEquiposT(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de equipos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de equipos,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void LlenarTablaProductos(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de productos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de productos,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void LlenarTablaServicios(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de servicios: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de servicios,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void LlenarTablaVentas(DefaultTableModel modelTabla, int cantColumnas, String query, Object... parametros) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(query);
                for (int i = 0; i < parametros.length; i++) {
                    pst.setObject(i + 1, parametros[i]);
                }
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Object[] fila = new Object[cantColumnas];
                    for (int i = 0; i < cantColumnas; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    modelTabla.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de ventas,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
