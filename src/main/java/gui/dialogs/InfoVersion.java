package gui.dialogs;

import com.construir.Imagenes;

import java.awt.Image;
import java.awt.Toolkit;

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
        setSize(375, 120);
        setTitle("Información de la versión");
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
        jLabel_VersionActual = new javax.swing.JLabel();
        jLabel_NumeroVersionActual = new javax.swing.JLabel();
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

        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel_NumeroVersionActual;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_VersionActual;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
