package gui.dialogs;

import com.bd.Registrar;
import com.construir.Imagenes;
import com.utilidades.Utilidades;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class InicioTurno extends javax.swing.JDialog {

    public InicioTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InicioTurno() {
        initComponents();
        setSize(300, 200);
        setTitle("Efectivo al inicio");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_FondoInicio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Cantidad = new javax.swing.JTextField();
        jLabel_Cantidad = new javax.swing.JLabel();
        jButtonI_Aceptar = new javax.swing.JButton();
        jLabel_FondoInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 190, 25));

        jLabel_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cantidad.setText("Cantidad inicio:");
        getContentPane().add(jLabel_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jButtonI_Aceptar.setBackground(new java.awt.Color(1, 89, 255));
        jButtonI_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonI_Aceptar.setText("Aceptar");
        jButtonI_Aceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonI_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonI_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonI_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 100, 40));
        getContentPane().add(jLabel_FondoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonI_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonI_AceptarActionPerformed
        String cantidadS = txt_Cantidad.getText().trim();
        double cantidad = Double.parseDouble(cantidadS);

        String fecha = Utilidades.FechaActual();

        if (!cantidadS.equals("")) {

            Registrar.RegistroInicioTurno(cantidad, fecha, Utilidades.getUsuarioActivo());
            new gui.ventanas.Capturista().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar el campo para continuar");
        }
    }//GEN-LAST:event_jButtonI_AceptarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InicioTurno dialog = new InicioTurno(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonI_Aceptar;
    private javax.swing.JLabel jLabel_Cantidad;
    private javax.swing.JLabel jLabel_FondoInicio;
    private javax.swing.JTextField txt_Cantidad;
    // End of variables declaration//GEN-END:variables
}
