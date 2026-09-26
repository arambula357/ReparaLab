package com.construir;

import com.eventos.Mouse;
import com.eventos.Teclado;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Arambula
 */
public class Tablas {

    /**
     * Método de la clase que permite la personalización de la tabla y sus
     * características. Deberá ser llamado desdé el contructor de la clase que
     * contiene la tabla.
     *
     * @param modelTabla - TableModel de la tabla que recibira la
     * personalización.
     * @param tabla - JTable que se personalizará.
     * @param scroll - JScrollPane dondé se encuentra nuestra tabla.
     * @param query - Instrucciones para la bd.
     * @param cantColumnas - Número entero de la cantidad de columnas que tendrá
     * nuestra tabla.
     * @param titulosColumnas - Arreglo de tipo String con los nombres de cada
     * columna en orden.
     */
    public void buildTablaUsuarios(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaUsuarios(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshUsuarios(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickUsuarios(modelTabla, tabla);
    }

    public void buildTablaClientes(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaClientes(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshClientes(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickClientes(modelTabla, tabla);
    }

    public void buildTablaEquipos(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaEquipos(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshEquipos(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickEquipos(modelTabla, tabla);
    }

    public void buildTablaEquiposT(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaEquiposT(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshEquiposT(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickEquiposT(modelTabla, tabla);
    }

    public void buildTablaArticulos(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
    }

    public void buildTablaVentas(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaVentas(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshVentas(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickVentas(modelTabla, tabla);
    }

    public void buildTablaProductos(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaProductos(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshProductos(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickProductos(modelTabla, tabla);
    }

    public void buildTablaServicios(DefaultTableModel modelTabla, JTable tabla, JScrollPane scroll, String query, int cantColumnas, String[] titulosColumnas, Object... parametros) {
        for (int i = 0; i < cantColumnas; i++) {
            modelTabla.addColumn(titulosColumnas[i]);
        }

        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);

        LlenarTabla.LlenarTablaServicios(modelTabla, cantColumnas, query, parametros);
        new Teclado().RefreshServicios(modelTabla, tabla, scroll, query, cantColumnas, titulosColumnas, parametros);
        Mouse.DobleClickServicios(modelTabla, tabla);
    }

    /*Declaración de objetos y variables de clase*/
}
