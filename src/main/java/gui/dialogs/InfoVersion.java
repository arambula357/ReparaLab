package gui.dialogs;

import com.construir.Imagenes;
import com.utilidades.Updater;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class InfoVersion extends javax.swing.JDialog {

    public InfoVersion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InfoVersion(){
        initComponents();
        setSize(375, 275);
        setTitle("Información de la versión");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jButton_DescargarActualizacion.setVisible(false);
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
        jLabel_VersionActual = new javax.swing.JLabel();
        jLabel_NumeroVersionActual = new javax.swing.JLabel();
        jLabel_Actualizacion = new javax.swing.JLabel();
        jButton_BuscarActualizacion = new javax.swing.JButton();
        jButton_DescargarActualizacion = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Información de la versión");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 30));

        jLabel_VersionActual.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel_VersionActual.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_VersionActual.setText("Versión actual:         v");
        getContentPane().add(jLabel_VersionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 150, 30));

        jLabel_NumeroVersionActual.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel_NumeroVersionActual.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NumeroVersionActual.setText("3.0.0");
        getContentPane().add(jLabel_NumeroVersionActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 50, 30));

        jLabel_Actualizacion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel_Actualizacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Actualizacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Actualizacion.setText("Verificar actualizaciones");
        getContentPane().add(jLabel_Actualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 370, 30));

        jButton_BuscarActualizacion.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarActualizacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_BuscarActualizacion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_BuscarActualizacion.setText("Buscar");
        jButton_BuscarActualizacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarActualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActualizacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_BuscarActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 120, 30));

        jButton_DescargarActualizacion.setBackground(new java.awt.Color(1, 89, 255));
        jButton_DescargarActualizacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_DescargarActualizacion.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DescargarActualizacion.setText("Descargar");
        jButton_DescargarActualizacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_DescargarActualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DescargarActualizacionActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_DescargarActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 100, 30));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 269));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BuscarActualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActualizacionActionPerformed

        jLabel_Actualizacion.setText("Buscando actualización...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

                    if (Updater.ConfirmarConexion() == true) {
                        if (Updater.ObtenerVersion().equals(versionA)) {
                            jLabel_Actualizacion.setText("El programa esta actualizado");
                        } else {
                            jLabel_Actualizacion.setText("Versión " + Updater.ObtenerVersion() + " disponible");
                            jButton_DescargarActualizacion.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al conectar!\n Verifique su conexión a internet");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Error al consultar actualizaciones");
                }
            }
        }).start();
    }//GEN-LAST:event_jButton_BuscarActualizacionActionPerformed

    private void jButton_DescargarActualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DescargarActualizacionActionPerformed
        Updater.EnlazarDescarga();
    }//GEN-LAST:event_jButton_DescargarActualizacionActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoVersion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoVersion dialog = new InfoVersion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_BuscarActualizacion;
    private javax.swing.JButton jButton_DescargarActualizacion;
    private javax.swing.JLabel jLabel_Actualizacion;
    private javax.swing.JLabel jLabel_NumeroVersionActual;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_VersionActual;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private String versionA;
}
