package gui.ventanas;

import com.bd.Consultar;
import com.construir.Imagenes;
import com.utilidades.Utilidades;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setSize(500, 750);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);

        Imagenes.setImagenFondo(jLabel_Wallpaper);

        ImageIcon logo = new ImageIcon("images/logo.png");
        Icon icono_logo = new ImageIcon(logo.getImage().getScaledInstance(jLabel_Logo.getWidth(), jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();

        Ingresar();
    }

    // Colocando icono a ventana
    @Override
    public Image getIconImage() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image retValue = tk.getImage("images/icono.png");
        setIconImage(retValue);
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Logo = new javax.swing.JLabel();
        jLabel_User = new javax.swing.JLabel();
        txt_User = new javax.swing.JTextField();
        jLabel_Password = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 204));
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 270, 270));

        jLabel_User.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_User.setText("Usuario:");
        getContentPane().add(jLabel_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        txt_User.setBackground(new java.awt.Color(3, 37, 251));
        txt_User.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_User.setForeground(new java.awt.Color(255, 255, 255));
        txt_User.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_User.setToolTipText("");
        txt_User.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 270, -1));

        jLabel_Password.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel_Password.setText("Password:");
        getContentPane().add(jLabel_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        txt_Password.setBackground(new java.awt.Color(3, 37, 251));
        txt_Password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 270, -1));

        jButton_Acceder.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 120, 30));

        jLabel_Footer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel_Footer.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Footer.setText("Creado por Diego Arambula");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 687, 500, 20));

        jLabel_Wallpaper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Wallpaper.setAutoscrolls(true);
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
        user = txt_User.getText().trim();
        pass = txt_Password.getText().trim();
        if (!user.equals("") && !pass.equals("")) {

            info = Consultar.ConsultarAcceso(user, pass);
            if (info != null) {
                if (info[0].equals("Administrador") && info[1].equals("Activo")) {

                    Utilidades.setUsuarioActivo(user);
                    new Administrador().setVisible(true);
                    this.dispose();

                } else if (info[0].equals("Capturista") && info[1].equals("Activo")) {

                    if (Consultar.ConsultarInicio(Utilidades.FechaActual())) {

                        Utilidades.setUsuarioActivo(user);
                        new Capturista().setVisible(true);
                        this.dispose();

                    } else {

                        Utilidades.setUsuarioActivo(user);
                        new gui.dialogs.InicioTurno().setVisible(true);
                    }
                } else if (info[0].equals("Tecnico") && info[1].equals("Activo")) {

                    Utilidades.setUsuarioActivo(user);
                    new Tecnico().setVisible(true);
                    this.dispose();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Los datos de acceso son incorrectos");
                txt_User.setText("");
                txt_Password.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar ambos campos");
        }
    }//GEN-LAST:event_jButton_AccederActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Password;
    private javax.swing.JLabel jLabel_User;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_User;
    // End of variables declaration//GEN-END:variables

    private void Ingresar() {
        txt_Password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    user = txt_User.getText().trim();
                    pass = txt_Password.getText().trim();
                    if (!user.equals("") && !pass.equals("")) {

                        info = Consultar.ConsultarAcceso(user, pass);
                        if (info != null) {
                            if (info[0].equals("Administrador") && info[1].equals("Activo")) {

                                Utilidades.setUsuarioActivo(user);
                                new Administrador().setVisible(true);
                                dispose();

                            } else if (info[0].equals("Capturista") && info[1].equals("Activo")) {

                                if (Consultar.ConsultarInicio(Utilidades.FechaActual())) {

                                    Utilidades.setUsuarioActivo(user);
                                    new Capturista().setVisible(true);
                                    dispose();

                                } else {

                                    Utilidades.setUsuarioActivo(user);
                                    new gui.dialogs.InicioTurno().setVisible(true);
                                }
                            } else if (info[0].equals("Tecnico") && info[1].equals("Activo")) {

                                Utilidades.setUsuarioActivo(user);
                                new Tecnico().setVisible(true);
                                dispose();

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Los datos de acceso son incorrectos");
                            txt_User.setText("");
                            txt_Password.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe llenar ambos campos");
                    }
                }
            }
        });
    }

    /*Declaración de objetos y variables de clase*/
    private String user;
    private String pass;

    private String[] info;
}
