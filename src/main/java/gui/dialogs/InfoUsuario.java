package gui.dialogs;

import com.construir.Imagenes;
import com.bd.Consultar;
import com.bd.Actualizar;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class InfoUsuario extends javax.swing.JDialog {

    public InfoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InfoUsuario(String usuario) {
        initComponents();
        this.usuario = usuario;
        this.idUsuario = Consultar.ConsultarIdUsuario(usuario);
        this.InfoUsuario = Consultar.ConsultarInfoUsuario(idUsuario);
        setSize(630, 450);
        setTitle("Información de usuario");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_Wallpaper);

        initTextFields();
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

        Label_Titulo = new javax.swing.JLabel();
        Label_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        Label_EmailUsuario = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        Label_TelefonoUsuario = new javax.swing.JLabel();
        txt_Telefono = new javax.swing.JTextField();
        Label_Permisos = new javax.swing.JLabel();
        cmb_Permisos = new javax.swing.JComboBox<>();
        Label_Usuario = new javax.swing.JLabel();
        txt_Usuario = new javax.swing.JTextField();
        Label_Estatus = new javax.swing.JLabel();
        cmb_Estatus = new javax.swing.JComboBox<>();
        Label_RegistradoPor = new javax.swing.JLabel();
        txt_RegistradoPor = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_RestaurarPassword = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        Label_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Label_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Titulo.setText("Información de usuario");
        getContentPane().add(Label_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 10, 630, -1));

        Label_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Label_Nombre.setText("Nombre:");
        getContentPane().add(Label_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        Label_EmailUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_EmailUsuario.setForeground(new java.awt.Color(255, 255, 255));
        Label_EmailUsuario.setText("Email:");
        getContentPane().add(Label_EmailUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_Email.setBackground(new java.awt.Color(3, 37, 251));
        txt_Email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Email.setForeground(new java.awt.Color(255, 255, 255));
        txt_Email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        Label_TelefonoUsuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_TelefonoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        Label_TelefonoUsuario.setText("Teléfono");
        getContentPane().add(Label_TelefonoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txt_Telefono.setBackground(new java.awt.Color(3, 37, 251));
        txt_Telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        Label_Permisos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_Permisos.setForeground(new java.awt.Color(255, 255, 255));
        Label_Permisos.setText("Permisos de:");
        getContentPane().add(Label_Permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        cmb_Permisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(cmb_Permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        Label_Usuario.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Label_Usuario.setText("Usuario:");
        getContentPane().add(Label_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        txt_Usuario.setBackground(new java.awt.Color(3, 37, 251));
        txt_Usuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        txt_Usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        Label_Estatus.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_Estatus.setForeground(new java.awt.Color(255, 255, 255));
        Label_Estatus.setText("Estatus:");
        getContentPane().add(Label_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        Label_RegistradoPor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Label_RegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        Label_RegistradoPor.setText("Registrado por:");
        getContentPane().add(Label_RegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txt_RegistradoPor.setBackground(new java.awt.Color(3, 37, 251));
        txt_RegistradoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_RegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_RegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_RegistradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_RegistradoPor.setEnabled(false);
        getContentPane().add(txt_RegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar usuario");
        jButton_Actualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));

        jButton_RestaurarPassword.setBackground(new java.awt.Color(1, 89, 255));
        jButton_RestaurarPassword.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RestaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestaurarPassword.setText("Restaurar password");
        jButton_RestaurarPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_RestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        int validacion = 0;
        String nombre, mail, telefono, username, permisos, estatus;

        nombre = txt_Nombre.getText().trim();
        mail = txt_Email.getText().trim();
        telefono = txt_Telefono.getText().trim();
        username = txt_Usuario.getText().trim();
        permisos = cmb_Permisos.getSelectedItem().toString();
        estatus = cmb_Estatus.getSelectedItem().toString();

        if (nombre.equals("") || mail.equals("") || telefono.equals("") || username.equals("")) {
            validacion++;
        }
        if (validacion == 0) {

            if (Consultar.ConsultarUsuario(idUsuario, usuario)) {

                JOptionPane.showMessageDialog(null, "El usuario no esta disponible, intenete con uno diferente");
            } else {
                Actualizar.ActualizarInfoUsuario(idUsuario, new String[]{nombre, mail, telefono, username, permisos, estatus});
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar");
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_RestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarPasswordActionPerformed
        RestaurarPass restaurarPass = new RestaurarPass(idUsuario);
        restaurarPass.setVisible(true);
    }//GEN-LAST:event_jButton_RestaurarPasswordActionPerformed

    private void initTextFields() {
        txt_Nombre.setText(InfoUsuario[0]);
        txt_Email.setText(InfoUsuario[1]);
        txt_Telefono.setText(InfoUsuario[2]);
        txt_Usuario.setText(InfoUsuario[3]);
        cmb_Permisos.setSelectedItem(InfoUsuario[4]);
        cmb_Estatus.setSelectedItem(InfoUsuario[5]);
        txt_RegistradoPor.setText(InfoUsuario[6]);
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
            java.util.logging.Logger.getLogger(InfoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoUsuario dialog = new InfoUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Label_EmailUsuario;
    private javax.swing.JLabel Label_Estatus;
    private javax.swing.JLabel Label_Nombre;
    private javax.swing.JLabel Label_Permisos;
    private javax.swing.JLabel Label_RegistradoPor;
    private javax.swing.JLabel Label_TelefonoUsuario;
    private javax.swing.JLabel Label_Titulo;
    private javax.swing.JLabel Label_Usuario;
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JComboBox<String> cmb_Permisos;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_RestaurarPassword;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_RegistradoPor;
    private javax.swing.JTextField txt_Telefono;
    private javax.swing.JTextField txt_Usuario;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private String usuario;
    private String[] InfoUsuario;
    private int idUsuario;

}
