package com.eventos;

import gui.dialogs.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Arambula
 */
public class Mouse {

    public static void DobleClickUsuarios(DefaultTableModel modelTabla, JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 2;

                if (e.getClickCount() == 2) {
                    String usuario = (String) modelTabla.getValueAt(fila_point, columna_point);
                    new InfoUsuario(usuario).setVisible(true);
                }
            }
        });
    }

    public static void DobleClickClientes(DefaultTableModel modelTabla, JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    int idCliente = (int) modelTabla.getValueAt(fila_point, columna_point);
                    new InfoCliente(idCliente).setVisible(true);
                }
            }
        });
    }

    public static void DobleClickEquipos(DefaultTableModel modelTabla, JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    int idEquipo = (int) modelTabla.getValueAt(fila_point, columna_point);
                    new InfoEquipo(idEquipo).setVisible(true);
                }
            }
        });
    }

    public static void DobleClickEquiposT(DefaultTableModel modelTabla, JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    int idEquipo = (int) modelTabla.getValueAt(fila_point, columna_point);
                    new InfoEquipoTec(idEquipo).setVisible(true);
                }
            }
        });
    }

    public static void DobleClickArticulos(DefaultTableModel modelTabla, JTable tabla, JTextField txt) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 2;

                if (e.getClickCount() == 2) {
                    String codigo = (String) tabla.getValueAt(fila_point, columna_point);
                    if (codigo.equals("P. Comun")) {
                        JOptionPane.showMessageDialog(null, "No puedes realizar un descuento a articulos sin registro", "Articulo sin registro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Descuento descuento = new Descuento(modelTabla, tabla, txt, codigo, fila_point);
                        descuento.setVisible(true);
                    }
                }
            }
        });
    }

    public static void DobleClickProductos(DefaultTableModel modelTabla, JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    String codigo = (String) modelTabla.getValueAt(fila_point, columna_point);
                    InfoProducto infoProducto = new InfoProducto(codigo);
                    infoProducto.setVisible(true);
                }
            }
        });
    }

    public static void DobleClickServicios(DefaultTableModel modelTabla, JTable tabla) {
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    String codigo = (String) modelTabla.getValueAt(fila_point, columna_point);
                    InfoServicio infoServicio = new InfoServicio(codigo);
                    infoServicio.setVisible(true);
                }
            }
        });
    }

    public static void DobleClickVentas(DefaultTableModel tablaVentas, JTable jTable_Ventas) {
        jTable_Ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (e.getClickCount() == 2) {
                    int idVenta = (int) tablaVentas.getValueAt(fila_point, columna_point);
                    InfoVenta infoVenta = new InfoVenta(idVenta);
                    infoVenta.setVisible(true);
                }
            }
        });
    }
}
