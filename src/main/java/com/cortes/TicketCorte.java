package com.cortes;

import com.utilidades.Utilidades;

import java.io.IOException;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.PrintException;
import javax.print.ServiceUI;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

public class TicketCorte {

    public TicketCorte(String[] infoEmpresa){
        empresa = infoEmpresa[0];
        propietario = infoEmpresa[1];
        rfc = infoEmpresa[2];
        direccion = infoEmpresa[3];
        telefono = infoEmpresa[4];
    }

    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setFecha() {
        fecha = Utilidades.FechaActual();
    }
    public void setCantidadI(double cantidadI){
        if (cantidadI == 0.0) {
            this.cantidadI = "N/A";
        } else {
            this.cantidadI = String.valueOf(cantidadI);
        }
    }

    public void setSalidas(String salidas){
        this.salidas = salidas;
    }

    public void setTotalSalidas(String totalSalidas){
        this.totalSalidas = totalSalidas;
    }

    public void setEfectivo(double totalEfectivo){
        this.totalEfectivo = String.valueOf(totalEfectivo);
    }

    public void setTarjeta(double totaltarjeta){
        this.totalTarjeta = String.valueOf(totaltarjeta);
    }

    public void setTransfer(double totalTranfer){
        this.totalTranfer = String.valueOf(totalTranfer);
    }

    public void print(boolean flagServicio) throws IOException {

        this.formatoTicket = formatoTicket.replace("{{empresa}}", empresa);
        this.formatoTicket = formatoTicket.replace("{{propietario}}", propietario);
        this.formatoTicket = formatoTicket.replace("{{rfc}}", rfc);
        this.formatoTicket = formatoTicket.replace("{{direccion}}", direccion);
        this.formatoTicket = formatoTicket.replace("{{telefono}}", telefono);
        this.formatoTicket = formatoTicket.replace("{{fecha}}", fecha);
        this.formatoTicket = formatoTicket.replace("{{articulos}}", articulos);
        this.formatoTicket = formatoTicket.replace("{{salidas}}", salidas);
        this.formatoTicket = formatoTicket.replace("{{cantidadI}}", cantidadI);
        this.formatoTicket = formatoTicket.replace("{{total}}", total);
        this.formatoTicket = formatoTicket.replace("{{totalSalidas}}", totalSalidas);
        this.formatoTicket = formatoTicket.replace("{{efectivo}}", totalEfectivo);
        this.formatoTicket = formatoTicket.replace("{{tarjeta}}", totalTarjeta);
        this.formatoTicket = formatoTicket.replace("{{tranfer}}", totalTranfer);

        //Especificamos el tipo de dato a imprimir
        //Tipo: bytes -- Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        //Creamos un arreglo de tipo byte y le agregamos el string convertido (cuerpo del ticket)
        //a bytes tal como lo maneja la impresora.
        byte[] bytes = this.formatoTicket.getBytes();
        //Creamos un documento a imprimir pasandole el arreglo de byte
        Doc doc = new SimpleDoc(bytes, flavor, null);

        //Creamos un trabajo de impresión
        DocPrintJob job = null;
        //Creamos una bandera para determinar si se encontro la impresora
        //que especificamos en este caso "subarasi" O si usamos la impresora predeterminada del S.O.
        boolean flagJob = false;

        //Opcion 1 ->nos da el array de los servicios de impresion
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        //Opcion 2-> servicios de impresion por default
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //Opcion 3-> mostramos dialogo para seleccionar impresoras que soporten arreglos de bits
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);

        if (flagServicio == true) {
            if (services.length > 0) {//usamos la opcion 1 y comprobamos si hay impresoras disponibles
                //Recorremos el arreglo de impresoras
                for (PrintService service1 : services) {
                    //Aqui definimos el nombre de la impresora (para este ejemplo: subarasi)
                    // y comparamos si esta dentro del arreglo de impresoras
                    if (service1.getName().equals("58 Printer")) {
                        job = service1.createPrintJob(); // creamos el trabajo de impresion
                        flagJob = true; //si la impresora existe ponemos en TRUE la bandera
                    }
                }
            }
            //En caso de que la opcion 1 no encuentre la impresora que buscamos
            // el flagJob es false y job es null, entonces empleamos la opcion 2
            if (job == null && flagJob == false) {
                //creamos el trabajo de impresion con el servicio de impresion por default
                //(la impresora establecida como predeterminada en el sistema operativo)
                job = defaultService.createPrintJob();
            }
            flagJob = false;
        } else {
            //si flagServicio es false, usamos la opcion 3 para crear el trabajo de impresion
            //seleccionando la impresora desde el cuadro de dialogo de impresion
            PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
            job = service.createPrintJob();
        }

        //por ultimo Imprimimos dentro de un try obligatoriamente para el contro de excepciones
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            JOptionPane.showMessageDialog(null, "IMPRIMIR TICKET (Compruebe impresion) " + ex.getMessage());
        }
    }

    /*Declaración de objetos y variables de clase*/
    private String empresa;
    private String propietario;
    private String rfc;
    private String direccion;
    private String telefono;
    private String articulos;
    private String total;
    private String fecha;
    private String cantidadI;
    private String salidas;
    private String totalSalidas;
    private String totalEfectivo;
    private String totalTarjeta;
    private String totalTranfer;

    private String formatoTicket
            = "\n" + (char) 27 + (char) 112 + (char) 0 + (char) 10 + (char) 100 + "      {{empresa}}\n"
            + " {{propietario}}\n"
            + "     R.F.C. {{rfc}}\n"
            + "{{direccion}}\n"
            + "     TElS: {{telefono}}\n"
            + "\n"
            + "FECHA: {{fecha}}\n"
            + "\n"
            + "CANT.   DESCIP.     TOTAL U.  \n"
            + "================================\n"
            + "{{articulos}}\n"
            + "================================\n"
            + "SALIDAS:  \n"
            + "\n"
            + "{{salidas}}\n"
            + "================================\n"
            + "INICIO TURNO:    $ {{cantidadI}}\n"
            + "TOTAL VENTAS:   $ {{total}}\n"
            + "TOTAL SALIDAS:   $ {{totalSalidas}}\n"
            + "================================\n"
            + "TOTAL EFECTIVO:   $ {{efectivo}}\n"
            + "TOTAL TARJETA:    $ {{tarjeta}}\n"
            + "TOTAL TRANFER:    $ {{tranfer}}\n"
            + "\n"
            + "\n\n";
}
