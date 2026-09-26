package gui.dialogs;

import com.bd.Actualizar;
import com.construir.Imagenes;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class RestaurarPass extends javax.swing.JDialog {

    public RestaurarPass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public RestaurarPass(int idUsuario) {
        initComponents();
        this.idUsuario = idUsuario;
        setTitle("Restaurar contraseña");
        setSize(360, 260);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        Imagenes.setImagenFondo(jLabel_Wallpaper);
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
        jLabel_Pass = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jLabel_ConfirmarPass = new javax.swing.JLabel();
        txt_PasswordConfirmacion = new javax.swing.JPasswordField();
        jButton_RestaurarPassword = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Restaurar password");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 360, -1));

        jLabel_Pass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Pass.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Pass.setText("Nuevo Password: ");
        getContentPane().add(jLabel_Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        txt_Password.setBackground(new java.awt.Color(3, 37, 251));
        txt_Password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 210, -1));

        jLabel_ConfirmarPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_ConfirmarPass.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ConfirmarPass.setText("Confirmar Password:");
        getContentPane().add(jLabel_ConfirmarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        txt_PasswordConfirmacion.setBackground(new java.awt.Color(3, 37, 251));
        txt_PasswordConfirmacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_PasswordConfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_PasswordConfirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_PasswordConfirmacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_PasswordConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, -1));

        jButton_RestaurarPassword.setBackground(new java.awt.Color(1, 89, 255));
        jButton_RestaurarPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_RestaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestaurarPassword.setText("Aceptar");
        jButton_RestaurarPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_RestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 90, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarPasswordActionPerformed
        String password, confirmacion_password;

        password = new String(txt_Password.getPassword()).trim();
        confirmacion_password = new String(txt_PasswordConfirmacion.getPassword()).trim();

        if (!password.equals("") && !confirmacion_password.equals("")) {
            if (password.equals(confirmacion_password)) {
                Actualizar.ActualizarPass(idUsuario, password);
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar ambos campos");
        }
    }//GEN-LAST:event_jButton_RestaurarPasswordActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RestaurarPass dialog = new RestaurarPass(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_RestaurarPassword;
    private javax.swing.JLabel jLabel_ConfirmarPass;
    private javax.swing.JLabel jLabel_Pass;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JPasswordField txt_PasswordConfirmacion;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private int idUsuario;
}
