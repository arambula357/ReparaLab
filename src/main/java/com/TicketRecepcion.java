package com;

import java.util.HashMap;

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
        empresa = infoEmpresa[0];
        propietario = infoEmpresa[1];
        rfc = infoEmpresa[2];
        direccion = infoEmpresa[3];
        telefono = infoEmpresa[4];
        condiciones = infoEmpresa[5];
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
        int count = 0;
        int nLineas = observaciones.length();

        for (int i = 0; i < nLineas; i++) {
            char caracter = observaciones.charAt(i);
            if (caracter == '\n') {
                count++;
            }
        }
        if (count != 6) {
            int tLineas = 6 - count;
            for (int i = 0; i < tLineas; i++) {
                observaciones = observaciones + "\n";
            }
            this.observaciones = observaciones;
        } else {
            this.observaciones = observaciones;
        }
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void LlenarOrden() throws JRException{

        String master = System.getProperty("user.dir") + "/reports/OrdenServicio.jrxml";
        HashMap parametros = new HashMap();

        /*
         * Cabecera "Datos generales del negocio"
         */
        parametros.put("empresa", empresa);
        parametros.put("propietario", propietario);
        parametros.put("rfc", rfc);
        parametros.put("direccion", direccion);
        parametros.put("telefono", telefono);

        /*
         * Datos generales de la orden
         */
        parametros.put("folio", folio);
        parametros.put("fechaHora", fechaHora);
        parametros.put("nombreCliente", nombreCliente);
        parametros.put("contactoCliente", contactoCliente);

        /*
         * Datos especificos del equipo
         */
        parametros.put("numeroSerie", numeroSerie);
        parametros.put("tipoEquipo", tipoEquipo);
        parametros.put("marca", marca);
        parametros.put("modelo", modelo);
        parametros.put("observaciones", observaciones);

        // Condiciones de servicio
        parametros.put("condiciones", condiciones);

        parametros.put("vendedor", vendedor);
        parametros.put("conformidad", nombreCliente);


        JasperReport report = JasperCompileManager.compileReport(master);
        JasperPrint jp = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
        JasperViewer.viewReport(jp, false);
    }
}
