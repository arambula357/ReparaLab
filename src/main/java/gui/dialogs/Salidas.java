package gui.dialogs;

import com.bd.Registrar;
import com.construir.Imagenes;
import com.utilidades.Utilidades;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego Arambula
 */
public class Salidas extends javax.swing.JDialog {

    public Salidas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Salidas() {
        initComponents();
        setSize(420, 230);
        setTitle("Salidas de efectivo");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_FondoSalida);
    }

    public Image getIconImage() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image retValue = tk.getImage("images/icono.png");
        setIconImage(retValue);
        return retValue;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Cantidad = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        jLabel_Concepto = new javax.swing.JLabel();
        txt_Concepto = new javax.swing.JTextField();
        jLabel_Simbolo = new javax.swing.JLabel();
        jButton_Aceptar = new javax.swing.JButton();
        jLabel_FondoSalida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cantidad.setText("Monto:");
        getContentPane().add(jLabel_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 25));

        jLabel_Concepto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Concepto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Concepto.setText("Concepto:");
        getContentPane().add(jLabel_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_Concepto.setBackground(new java.awt.Color(3, 37, 251));
        txt_Concepto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Concepto.setForeground(new java.awt.Color(255, 255, 255));
        txt_Concepto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Concepto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Concepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 290, 25));

        jLabel_Simbolo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Simbolo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Simbolo.setText("$");
        getContentPane().add(jLabel_Simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, -1, -1));

        jButton_Aceptar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Aceptar.setText("Aceptar");
        jButton_Aceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, 40));
        getContentPane().add(jLabel_FondoSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AceptarActionPerformed
        String cantidad, concepto;

        cantidad = txt_Cantidad.getText().trim();
        concepto = txt_Concepto.getText().trim();

        if (!cantidad.equals("") && !concepto.equals("")) {

            Registrar.RegistrarSalida(cantidad, concepto, Utilidades.getUsuarioActivo());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar ambos campos");
        }
    }//GEN-LAST:event_jButton_AceptarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Salidas dialog = new Salidas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Aceptar;
    private javax.swing.JLabel jLabel_Cantidad;
    private javax.swing.JLabel jLabel_Concepto;
    private javax.swing.JLabel jLabel_FondoSalida;
    private javax.swing.JLabel jLabel_Simbolo;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Concepto;
    // End of variables declaration//GEN-END:variables
}
