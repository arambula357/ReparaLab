package gui.dialogs;

import com.bd.Actualizar;
import com.bd.Consultar;
import com.construir.Imagenes;
import com.TicketRecepcion;
import com.utilidades.Utilidades;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class InfoEquipoTec extends javax.swing.JDialog {

    public InfoEquipoTec(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InfoEquipoTec(int idEquipo){
        initComponents();
        this.idEquipo = idEquipo;
        this.infoEquipo = Consultar.ConsultarInfoEquipo(idEquipo);
        setTitle("Información de equipo");
        setSize(680, 510);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_Wallpaper);

        initTextField();

        if (!infoEquipo[7].equals("Entregado")) {
            cmb_Estatus.setEnabled(true);
            txt_ComentariosTecnico.setEditable(true);
            jButton_Actualizar.setEnabled(true);
        } else {
            cmb_Estatus.setEnabled(false);
            txt_ComentariosTecnico.setEditable(false);
            jButton_Actualizar.setEnabled(false);
            jLabel_Titulo.setText("Información de equipo (Entregado)");
        }
    }

    public Image getIconImage() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image retValue = tk.getImage("images/icono.png");
        setIconImage(retValue);
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        jLabel_Nombre1 = new javax.swing.JLabel();
        txt_TipoEquipo = new javax.swing.JTextField();
        jLabel_Nombre2 = new javax.swing.JLabel();
        txt_Modelo = new javax.swing.JTextField();
        jLabel_Nombre3 = new javax.swing.JLabel();
        txt_Marca = new javax.swing.JTextField();
        jLabel_Nombre4 = new javax.swing.JLabel();
        txt_NumeroSerie = new javax.swing.JTextField();
        jLabel_Nombre5 = new javax.swing.JLabel();
        txt_Fecha = new javax.swing.JTextField();
        jLabel_Nombre6 = new javax.swing.JLabel();
        txt_RegistradoPor = new javax.swing.JTextField();
        jLabel_Nombre7 = new javax.swing.JLabel();
        cmb_Estatus = new javax.swing.JComboBox<>();
        jLabel_Nombre8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Observaciones = new javax.swing.JTextPane();
        jLabel_RevisionTecnicaDe = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_ComentariosTecnico = new javax.swing.JTextPane();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Información de equipo");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 10, 670, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NombreCliente.setEnabled(false);
        getContentPane().add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txt_TipoEquipo.setBackground(new java.awt.Color(3, 37, 251));
        txt_TipoEquipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TipoEquipo.setForeground(new java.awt.Color(255, 255, 255));
        txt_TipoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TipoEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_TipoEquipo.setEnabled(false);
        getContentPane().add(txt_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Modelo.setEnabled(false);
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txt_Marca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Marca.setEnabled(false);
        getContentPane().add(txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Número de serie:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txt_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txt_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_NumeroSerie.setEnabled(false);
        getContentPane().add(txt_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Fecha de ingreso:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        txt_Fecha.setBackground(new java.awt.Color(3, 37, 251));
        txt_Fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_Fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Fecha.setEnabled(false);
        getContentPane().add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ultima modificación");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        txt_RegistradoPor.setBackground(new java.awt.Color(3, 37, 251));
        txt_RegistradoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_RegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_RegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_RegistradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_RegistradoPor.setEnabled(false);
        getContentPane().add(txt_RegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        jLabel_Nombre7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setText("Estatus:");
        getContentPane().add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "En revision", "Reparado", "No reparado" }));
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setText("Daño reportado y observaciones:");
        getContentPane().add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        txt_Observaciones.setEditable(false);
        jScrollPane1.setViewportView(txt_Observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jLabel_RevisionTecnicaDe.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_RevisionTecnicaDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_RevisionTecnicaDe.setText("Comentarios y actualizaciones técnicas:");
        getContentPane().add(jLabel_RevisionTecnicaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jScrollPane2.setViewportView(txt_ComentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jButton_Actualizar.setBackground(new java.awt.Color(3, 37, 251));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar equipo");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        String estatus, observaciones;

        estatus = cmb_Estatus.getSelectedItem().toString();
        observaciones = txt_ComentariosTecnico.getText();

        if (observaciones.equals("")) {
            txt_ComentariosTecnico.setText("Sin observaciones");
            observaciones = "Sin observaciones";
        }

        Actualizar.ActualizarInfoEquipoT(idEquipo, new String[]{observaciones, estatus, Utilidades.getUsuarioActivo()});
        this.dispose();
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void initTextField() {
        txt_TipoEquipo.setText(infoEquipo[0]);
        txt_Marca.setText(infoEquipo[1]);
        txt_Modelo.setText(infoEquipo[2]);
        txt_NumeroSerie.setText(infoEquipo[3]);
        txt_Fecha.setText(infoEquipo[4]);
        txt_Observaciones.setText(infoEquipo[6]);
        cmb_Estatus.setSelectedItem(infoEquipo[7]);
        txt_ComentariosTecnico.setText(infoEquipo[8]);
        jLabel_RevisionTecnicaDe.setText("Comentarios y actualizaciones técnicas de " + infoEquipo[9]);
        txt_RegistradoPor.setText(infoEquipo[10]);
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
            java.util.logging.Logger.getLogger(InfoEquipoTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoEquipoTec dialog = new InfoEquipoTec(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_RevisionTecnicaDe;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txt_ComentariosTecnico;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_NumeroSerie;
    private javax.swing.JTextPane txt_Observaciones;
    private javax.swing.JTextField txt_RegistradoPor;
    private javax.swing.JTextField txt_TipoEquipo;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private int idEquipo;
    private String[] infoEquipo;
}
