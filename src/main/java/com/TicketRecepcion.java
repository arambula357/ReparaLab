package com;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diego Arambula
 */
public class TicketRecepcion {

    private String empresa;
    private String propietario;
    private String rfc;
    private String direccion;
    private String telefono;
    private String folio;
    private String nombreCliente;
    private String contactoCliente;
    private String observaciones;
    private String condiciones;
    private String numeroSerie;
    private String tipoEquipo;
    private String marca;
    private String modelo;
    private String vendedor;
    private String fechaHora;

    public TicketRecepcion(String[] infoEmpresa) {
        empresa = dato(infoEmpresa, 0);
        propietario = dato(infoEmpresa, 1);
        rfc = dato(infoEmpresa, 2);
        direccion = dato(infoEmpresa, 3);
        telefono = dato(infoEmpresa, 4);
        condiciones = dato(infoEmpresa, 5);
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setContactoCliente(String contactoCliente){
        this.contactoCliente = contactoCliente;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = texto(observaciones);
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void LlenarOrden() throws JRException {
        JasperViewer.viewReport(crearOrden(), false);
    }

    JasperPrint crearOrden() throws JRException {
        String master = System.getProperty("user.dir") + "/reports/OrdenServicio.jrxml";
        Map<String, Object> parametros = new HashMap<>();

        /*
         * Cabecera "Datos generales del negocio"
         */
        parametros.put("empresa", texto(empresa));
        parametros.put("propietario", texto(propietario));
        parametros.put("rfc", texto(rfc));
        parametros.put("direccion", texto(direccion));
        parametros.put("telefono", texto(telefono));

        /*
         * Datos generales de la orden
         */
        parametros.put("folio", texto(folio));
        parametros.put("fechaHora", texto(fechaHora));
        parametros.put("nombreCliente", texto(nombreCliente));
        parametros.put("contactoCliente", texto(contactoCliente));

        /*
         * Datos especificos del equipo
         */
        parametros.put("numeroSerie", texto(numeroSerie));
        parametros.put("tipoEquipo", texto(tipoEquipo));
        parametros.put("marca", texto(marca));
        parametros.put("modelo", texto(modelo));
        parametros.put("observaciones", texto(observaciones));

        // Condiciones de servicio
        parametros.put("condiciones", texto(condiciones));

        parametros.put("vendedor", texto(vendedor));
        parametros.put("conformidad", texto(nombreCliente));


        JasperReport report = JasperCompileManager.compileReport(master);
        return JasperFillManager.fillReport(report, parametros, new JREmptyDataSource(1));
    }

    private static String dato(String[] datos, int indice) {
        return datos != null && indice < datos.length ? texto(datos[indice]) : "";
    }

    private static String texto(String valor) {
        return valor == null ? "" : valor;
    }
}
