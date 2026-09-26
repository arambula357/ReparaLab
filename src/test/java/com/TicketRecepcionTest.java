package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JasperPrint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketRecepcionTest {

    private TicketRecepcion orden(String observaciones) {
        TicketRecepcion orden = new TicketRecepcion(new String[]{
            "ReparaLab", "Equipo Demo", "", "Calle de prueba", "", "Condiciones de prueba. ".repeat(35)
        });
        orden.setFolio("123");
        orden.setFechaHora("26/09/2026 11:00");
        orden.setNombreCliente("Cliente Demo");
        orden.setContactoCliente("5550000000");
        orden.setTipoEquipo("Teléfono");
        orden.setMarca("Marca Demo");
        orden.setModelo("Modelo Demo");
        orden.setNumeroSerie("SERIE-123");
        orden.setObservaciones(observaciones);
        orden.setVendedor("Recepción Demo");
        return orden;
    }

    @Test
    void llenaTodosLosCamposSinValoresNull() throws JRException {
        JasperPrint print = orden("Pantalla dañada").crearOrden();
        String texto = texto(print);
        for (String esperado : List.of("ReparaLab", "Folio: 123", "Cliente: Cliente Demo",
                "SERIE-123", "Pantalla dañada", "Condiciones de prueba.", "Recibió: Recepción Demo")) {
            assertTrue(texto.contains(esperado), esperado);
        }
        assertFalse(texto.contains("null"));
    }

    @Test
    void textoLargoNoSeSuperponeConLasFirmas() throws JRException {
        JasperPrint print = orden("Falla observada: ".repeat(35)).crearOrden();
        assertTrue(print.getPages().size() > 1);
        for (var page : print.getPages()) {
            List<JRPrintElement> elementos = new ArrayList<>(page.getElements());
            elementos.sort(Comparator.comparingInt(JRPrintElement::getY));
            for (int i = 1; i < elementos.size(); i++) {
                JRPrintElement anterior = elementos.get(i - 1);
                JRPrintElement actual = elementos.get(i);
                assertTrue(anterior.getY() + anterior.getHeight() <= actual.getY(),
                        "Se superponen elementos en y=" + anterior.getY() + " y=" + actual.getY());
            }
        }
        assertTrue(texto(print).contains("Conformidad: Cliente Demo"));
    }

    @Test
    void observacionesExtensasConservanElFinalDelTexto() throws JRException {
        String observaciones = "INICIO-" + "falla ".repeat(800) + "-FIN";
        JasperPrint print = orden(observaciones).crearOrden();
        assertTrue(print.getPages().size() > 1);
        assertTrue(texto(print).contains("-FIN"));
    }
    private String texto(JasperPrint print) {
        StringBuilder contenido = new StringBuilder();
        for (var page : print.getPages()) {
            for (JRPrintElement element : page.getElements()) {
                if (element instanceof JRPrintText campo) {
                    contenido.append(campo.getFullText()).append('\n');
                }
            }
        }
        return contenido.toString();
    }
}
