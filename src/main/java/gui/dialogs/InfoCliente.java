package gui.dialogs;

import com.bd.Conexion;
import com.bd.Consultar;
import com.bd.Actualizar;
import com.construir.Imagenes;
import com.construir.Tablas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Image;
import java.awt.Toolkit;

import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.*;

/**
 *
 * @author Diego Arambula
 */
public class InfoCliente extends javax.swing.JDialog {

    public InfoCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InfoCliente(int idCliente) {
        initComponents();
        this.idCliente = idCliente;
        this.info = Consultar.ConsultarInfoCliente(idCliente);
        setSize(640, 480);
        setTitle("Información de cliente");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_Wallpaper);
        Imagenes.setImagenBoton(jButton_ImprimirReporte, "images/impresora.png", false);

        initTextFields();

        String Q_Equipos = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = ?";
        String[] T_Equipos = {"Folio", "Marca", "Modelo", "Estatus"};
        buildTabla.buildTablaEquipos(modelEquipos, tablaEquipos, scrollEquipos, Q_Equipos, 4, T_Equipos, idCliente);
    }

    public Image getIconImage() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image retValue = tk.getImage("images/icono.png");
        setIconImage(retValue);
        return retValue;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        cmb_Estatus = new javax.swing.JComboBox<>();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        jLabel_ModificadoPor = new javax.swing.JLabel();
        txt_ModificadoPor = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_ImprimirReporte = new javax.swing.JButton();
        scrollEquipos = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Información del cliente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 650, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "En revision", "Reparado", "No reparado", "Entregado" }));
        cmb_Estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_EstatusActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 130, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, -1));

        jLabel_Telefono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Telefono.setText("Teléfono:");
        getContentPane().add(jLabel_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txt_Telefono.setBackground(new java.awt.Color(3, 37, 251));
        txt_Telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 210, -1));

        jLabel_ModificadoPor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_ModificadoPor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ModificadoPor.setText("Modificado por:");
        getContentPane().add(jLabel_ModificadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txt_ModificadoPor.setBackground(new java.awt.Color(3, 37, 251));
        txt_ModificadoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ModificadoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_ModificadoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ModificadoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ModificadoPor.setEnabled(false);
        getContentPane().add(txt_ModificadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 80, 35));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(1, 89, 255));
        jButton_ImprimirReporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_ImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 100, 80));

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollEquipos.setViewportView(tablaEquipos);
        modelEquipos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelEquipos.setRowCount(0);
        modelEquipos.setColumnCount(0);
        tablaEquipos = new JTable(modelEquipos);
        scrollEquipos.setViewportView(tablaEquipos);

        getContentPane().add(scrollEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 380, 180));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        String nombre, telefono;

        nombre = txt_Nombre.getText().trim();
        telefono = txt_Telefono.getText().trim();

        if (!nombre.equals("") || !telefono.equals("")) {
            Actualizar.ActualizarInfoCliente(idCliente, new String[]{nombre, telefono});
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar ambos campos");
        }

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_ImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirReporteActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + info[0] + ".pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("images/BannerPDF.jpg");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph tituloCliente = new Paragraph();
            tituloCliente.setAlignment(Paragraph.ALIGN_CENTER);
            tituloCliente.add("Informacion del cliente\n\n");
            tituloCliente.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            Paragraph tituloEquipos = new Paragraph();
            tituloEquipos.setAlignment(Paragraph.ALIGN_CENTER);
            tituloEquipos.add("\n\nEquipos registrados\n\n");
            tituloEquipos.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(tituloCliente);
            documento.add(TablaCliente());
            documento.add(tituloEquipos);
            documento.add(TablaEquipo());

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");
        } catch (DocumentException | IOException e) {
            System.out.println("Error en PDF o ruta de imagen " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar PDF,\n"
                    + "Revise su conexión a internet o llame al administrador\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_ImprimirReporteActionPerformed

    private void cmb_EstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_EstatusActionPerformed
        String seleccion = cmb_Estatus.getSelectedItem().toString();
        String Q_Equipos;
        String[] T_Equipos = {"Folio", "Marca", "Modelo", "Estatus"};

        modelEquipos.setRowCount(0);
        modelEquipos.setColumnCount(0);
        tablaEquipos = new JTable(modelEquipos);
        scrollEquipos.setViewportView(tablaEquipos);

        if (seleccion.equals("Todos")) {
            Q_Equipos = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = ?";
        } else {
            Q_Equipos = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = ? and estatus = ?";
        }

        buildTabla.buildTablaEquipos(modelEquipos, tablaEquipos, scrollEquipos, Q_Equipos, 4, T_Equipos, seleccion.equals("Todos") ? new Object[]{idCliente} : new Object[]{idCliente, seleccion});
    }//GEN-LAST:event_cmb_EstatusActionPerformed

    private PdfPTable TablaCliente() {
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Telefono");
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select * from clientes where id_cliente = ?");
                pst.setObject(1, idCliente);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString("id_cliente"));
                        tabla.addCell(rs.getString("nombre_cliente"));
                        tabla.addCell(rs.getString("tel_cliente"));
                    } while (rs.next());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del cliente para el documento: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del cliente para el documento,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    private PdfPTable TablaEquipo() {
        PdfPTable tabla = new PdfPTable(6);
        tabla.addCell("ID");
        tabla.addCell("Tipo");
        tabla.addCell("Marca");
        tabla.addCell("Modelo");
        tabla.addCell("No. Serie");
        tabla.addCell("Estatus");

        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_equipo, tipo_equipo, marca, modelo, num_serie, estatus from equipos where id_cliente = ?");
                pst.setObject(1, idCliente);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString("id_equipo"));
                        tabla.addCell(rs.getString("tipo_equipo"));
                        tabla.addCell(rs.getString("marca"));
                        tabla.addCell(rs.getString("modelo"));
                        tabla.addCell(rs.getString("num_serie"));
                        tabla.addCell(rs.getString("estatus"));
                    } while (rs.next());

                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los equipos del cliente para el documento: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener los equipos del cliente para el documento,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    private void initTextFields() {
        txt_Nombre.setText(info[0]);
        txt_Telefono.setText(info[1]);
        txt_ModificadoPor.setText(info[2]);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoCliente dialog = new InfoCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JLabel jLabel_ModificadoPor;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane scrollEquipos;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField txt_ModificadoPor;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private Tablas buildTabla = new Tablas();

    private DefaultTableModel modelEquipos;

    private String[] info;
    private int idCliente;
}
