package gui.dialogs;

import com.construir.Imagenes;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Arambula
 */
public class Comun extends javax.swing.JDialog {

    public Comun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Comun(DefaultTableModel modelTabla, JTextField txt) {
        initComponents();
        this.modelTabla = modelTabla;
        this.txt = txt;
        setSize(400, 240);
        setTitle("Producto Comun");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_FondoComun);

        totalA = txt.getText().trim();
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

        jLabel_Cantidad = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_Precio = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jButton_Aceptar = new javax.swing.JButton();
        jLabel_FondoComun = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Cantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cantidad.setText("Cantidad:");
        getContentPane().add(jLabel_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 25));

        jLabel_Nombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, 25));

        jLabel_Precio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Precio.setText("Precio:");
        getContentPane().add(jLabel_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txt_Precio.setBackground(new java.awt.Color(3, 37, 251));
        txt_Precio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Precio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, 25));

        jButton_Aceptar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Aceptar.setText("Aceptar");
        jButton_Aceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 100, 40));
        getContentPane().add(jLabel_FondoComun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AceptarActionPerformed
        cantidad = txt_Cantidad.getText().trim();
        nombre = txt_Nombre.getText().trim();
        precio = txt_Precio.getText().trim();

        if (cantidad.equals("") || nombre.equals("") || precio.equals("")) {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {

            precioT = String.valueOf(Integer.parseInt(cantidad) * Double.parseDouble(precio));
            totalN = String.valueOf(Double.parseDouble(totalA) + Double.parseDouble(precioT));

            modelTabla.addRow(new String[]{cantidad, "P. Comun", nombre, precio, precioT});
            txt.setText(totalN);

            txt_Cantidad.setText("");
            txt_Nombre.setText("");
            txt_Precio.setText("");
            this.dispose();
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
            java.util.logging.Logger.getLogger(Comun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Comun dialog = new Comun(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel_FondoComun;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private DefaultTableModel modelTabla;
    private JTextField txt;

    private String cantidad;
    private String nombre;
    private String precio;
    private String precioT;
    private String totalA;
    private String totalN;
}
