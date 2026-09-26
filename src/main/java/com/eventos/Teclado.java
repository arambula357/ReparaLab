package com.eventos;

import com.bd.Consultar;
import com.construir.Tablas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Arambula
 */
public class Teclado {

    public void RefreshUsuarios(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaUsuarios = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setRowCount(0);
                    modelTabla.setColumnCount(0);
                    tablaUsuarios = new JTable(modelTabla);
                    scroll.setViewportView(tablaUsuarios);

                    new Tablas().buildTablaUsuarios(modelTabla, tablaUsuarios, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void RefreshClientes(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaClientes = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaClientes = new JTable(modelTabla);
                    scroll.setViewportView(tablaClientes);

                    new Tablas().buildTablaClientes(modelTabla, tablaClientes, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void RefreshEquipos(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaEquipos = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaEquipos = new JTable(modelTabla);
                    scroll.setViewportView(tablaEquipos);

                    new Tablas().buildTablaEquipos(modelTabla, tablaEquipos, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void RefreshEquiposT(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaEquiposT = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaEquiposT = new JTable(modelTabla);
                    scroll.setViewportView(tablaEquiposT);

                    new Tablas().buildTablaEquiposT(modelTabla, tablaEquiposT, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void RefreshVentas(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaVentas = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaVentas = new JTable(modelTabla);
                    scroll.setViewportView(tablaVentas);

                    new Tablas().buildTablaVentas(modelTabla, tablaVentas, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void RefreshProductos(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaProductos = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaProductos = new JTable(modelTabla);
                    scroll.setViewportView(tablaProductos);

                    new Tablas().buildTablaProductos(modelTabla, tablaProductos, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void RefreshServicios(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        tablaServicios = tabla;
        tabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_F5) {

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaServicios = new JTable(modelTabla);
                    scroll.setViewportView(tablaServicios);

                    new Tablas().buildTablaServicios(modelTabla, tablaServicios, scroll, query, cantColumnas, titulosColumnas, parametros);
                }
            }
        });
    }

    public void setCambio(JTextField txtPaga, JTextField txtCambio, JTextField txtTotal) {
        txtPaga.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    double total = Double.parseDouble(txtTotal.getText());
                    double pagaCon;
                    double cambio;

                    if ((Double.parseDouble(txtPaga.getText().trim()) >= total) && !(txtPaga.getText()).equals("")) {
                        pagaCon = Double.parseDouble(txtPaga.getText().trim());

                        cambio = pagaCon - total;

                        txtPaga.setText(String.valueOf(pagaCon));
                        txtCambio.setText(String.valueOf(cambio));
                    } else {

                        JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad que el cliente ha entregado");
                    }
                }
            }
        });
    }

    public void BuscarHistorial(JTextField txt, DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll) {
        tablaClientes = tabla;
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombreCliente;

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaClientes = new JTable(modelTabla);
                    scroll.setViewportView(tablaClientes);

                    nombreCliente = txt.getText().trim();
                    String[] T_Clientes = {"ID", "Nombre", "Telefono"};

                    if (!nombreCliente.equals("")) {

                        String Q_Clientes = "select id_cliente, nombre_cliente, tel_cliente, ultima_modificacion from clientes where nombre_cliente = ?";

                        new Tablas().buildTablaClientes(modelTabla, tablaClientes, scroll, Q_Clientes, 3, T_Clientes, nombreCliente);
                    } else {

                        String Q_Clientes = "select id_cliente, nombre_cliente, tel_cliente from clientes";

                        new Tablas().buildTablaClientes(modelTabla, tablaClientes, scroll, Q_Clientes, 3, T_Clientes);
                    }
                }
            }
        });
    }

    public void BuscarProducto(JTextField txt, DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll) {
        tablaProductos = tabla;
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombre;

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaProductos = new JTable(modelTabla);
                    scroll.setViewportView(tablaProductos);

                    nombre = txt.getText().trim();

                    String[] T_Prodcutos = {"Código", "Nombre", "Cantidad", "Precio"};

                    if (!(txt.getText().trim()).equals("")) {

                        String Q_Productos = "select codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto' and nombre = ?";

                        new Tablas().buildTablaProductos(modelTabla, tablaProductos, scroll, Q_Productos, 4, T_Prodcutos, nombre);
                    } else {

                        String Q_Productos = "select codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto'";

                        new Tablas().buildTablaProductos(modelTabla, tablaProductos, scroll, Q_Productos, 4, T_Prodcutos);
                    }
                }
            }
        });
    }

    public void BuscarServicio(JTextField txt, DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll) {
        tablaServicios = tabla;
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombre;

                    modelTabla.setColumnCount(0);
                    modelTabla.setRowCount(0);
                    tablaServicios = new JTable(modelTabla);
                    scroll.setViewportView(tablaServicios);

                    nombre = txt.getText().trim();

                    String[] T_Servicios = {"Código", "Nombre", "Precio"};

                    if (!(txt.getText().trim()).equals("")) {

                        String Q_Servicios = "select codigo, nombre, precio from articulos where tipo_articulo = 'servicio' and nombre = ?";

                        new Tablas().buildTablaServicios(modelTabla, tablaServicios, scroll, Q_Servicios, 3, T_Servicios, nombre);
                    } else {

                        String Q_Servicios = "select codigo, nombre, precio from articulos where tipo_articulo = 'servicio'";

                        new Tablas().buildTablaServicios(modelTabla, tablaServicios, scroll, Q_Servicios, 3, T_Servicios);
                    }
                }
            }
        });
    }

    public void addProducto(JTextField txtAdd, JTextField txtTotal, DefaultTableModel modelTabla) {
        txtAdd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nombre, precio, precioT;
                    String totalA = txtTotal.getText().trim();
                    String cadena = txtAdd.getText().trim();
                    String parte1 = "", parte2 = "";

                    char[] cadenaDiv = cadena.toCharArray();
                    for (int i = 0; i < cadenaDiv.length; i++) {
                        char simbolo = cadena.charAt(i);
                        if (simbolo == '*') {
                            String[] division = cadena.split("\\*");
                            parte1 = division[0];
                            parte2 = division[1];
                        }
                    }
                    if (!parte1.equals("") && !parte2.equals("")) {
                        String[] infoArticulo = Consultar.ConsultarInfoArticulo(parte2);

                        if (infoArticulo != null) {
                            nombre = infoArticulo[0];
                            precio = infoArticulo[1];
                            precioT = String.valueOf(Double.parseDouble(precio) * Double.parseDouble(parte2));

                            modelTabla.addRow(new String[]{parte1, parte2, nombre, precio, precioT});
                            txtTotal.setText(String.valueOf(Double.parseDouble(totalA) + Double.parseDouble(precioT)));
                            txtAdd.setText("");
                        } else if (infoArticulo == null) {
                            setSeleccion();
                        }
                    } else {
                        String[] infoArticulo = Consultar.ConsultarInfoArticulo(cadena);

                        if (infoArticulo != null) {
                            nombre = infoArticulo[0];
                            precio = infoArticulo[1];
                            precioT = precio;

                            modelTabla.addRow(new String[]{"1", cadena, nombre, precio, precioT});
                            txtTotal.setText(String.valueOf(Double.parseDouble(totalA) + Double.parseDouble(precioT)));
                            txtAdd.setText("");
                        } else if (infoArticulo == null) {
                            setSeleccion();
                        }
                    }
                }
            }
        });
    }

    private void setSeleccion() {
        int seleccion = JOptionPane.showOptionDialog(null, "¿Desea agregarlo como articulo nuevo?",
                "El articulo no existe",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"SI", "NO"},
                "SI");
        if (seleccion == JOptionPane.YES_OPTION) {
            new gui.dialogs.NuevoArticulo().setVisible(true);
        }
    }

    /*Declaración de objetos y variables de clase*/
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaEquiposT;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTable tablaVentas;
}
