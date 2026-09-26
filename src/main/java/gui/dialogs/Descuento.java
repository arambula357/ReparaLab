package gui.dialogs;

import com.construir.Imagenes;
import com.bd.Consultar;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Diego Arambula
 */
public class Descuento extends javax.swing.JDialog {

    public Descuento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Descuento(DefaultTableModel modelTabla, JTable tabla, JTextField txt, String codigo, int fila) {
        initComponents();
        this.modelTabla = modelTabla;
        this.tabla = tabla;
        this.txt = txt;
        this.fila = fila;
        setSize(330, 230);
        setTitle("Generar descuento");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_FondoDescuento);

        totalActual = txt.getText().trim();
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

        jLabel_Monto = new javax.swing.JLabel();
        txt_Monto = new javax.swing.JTextField();
        jLabel_Porcentaje = new javax.swing.JLabel();
        txt_Porcentaje = new javax.swing.JTextField();
        jButton_Aceptar = new javax.swing.JButton();
        jLabel_Simbolo = new javax.swing.JLabel();
        jLabel_FondoDescuento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Monto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Monto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Monto.setText("Nuevo precio:");
        getContentPane().add(jLabel_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txt_Monto.setBackground(new java.awt.Color(3, 37, 251));
        txt_Monto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Monto.setForeground(new java.awt.Color(255, 255, 255));
        txt_Monto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Monto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 25));

        jLabel_Porcentaje.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Porcentaje.setText("Porcentaje:");
        getContentPane().add(jLabel_Porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_Porcentaje.setBackground(new java.awt.Color(3, 37, 251));
        txt_Porcentaje.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        txt_Porcentaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Porcentaje.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 25));

        jButton_Aceptar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Aceptar.setText("Aceptar");
        jButton_Aceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 100, 40));

        jLabel_Simbolo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Simbolo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Simbolo.setText("%");
        getContentPane().add(jLabel_Simbolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 100, -1, 30));
        getContentPane().add(jLabel_FondoDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AceptarActionPerformed
        double operacionPorcien = 0.0;

        cantidad = (String) tabla.getValueAt(fila, 0);
        codigo = (String) tabla.getValueAt(fila, 1);
        precioT = (String) tabla.getValueAt(fila, 4);
        monto = txt_Monto.getText().trim();
        porcentaje = txt_Porcentaje.getText().trim();

        if (!monto.equals("") && !porcentaje.equals("")) {
            JOptionPane.showMessageDialog(null, "Solo es posible realizar un calculo a la vez");
        } else if (!monto.equals("") || !porcentaje.equals("")) {
            if (!monto.equals("")) {
                if (codigo.equals("P. Comun")) {
                    JOptionPane.showMessageDialog(null, "No puedes realizar un descuento a este tipo de productos,\nRecomendamos eliminar de la tabla y crear nuevo registro");
                } else {
                    precioTotal = String.valueOf(Integer.parseInt(cantidad) * Integer.parseInt(monto));
                    nuevoTotal = String.valueOf((Double.parseDouble(totalActual) - Double.parseDouble(precioT)) + Double.parseDouble(precioTotal));

                    modelTabla.setValueAt(monto, fila, 3);
                    modelTabla.setValueAt(precioTotal, fila, 4);

                    txt.setText(nuevoTotal);
                    txt_Monto.setText("");
                    txt_Porcentaje.setText("");
                    this.dispose();
                }
            } else if (!porcentaje.equals("")) {
                if (codigo.equals("P. Comun")) {
                    JOptionPane.showMessageDialog(null, "No puedes realizar un descuento a este tipo de productos,\nRecomendamos eliminar de la tabla y crear nuevo registro");
                } else {
                    operacionPorcien = (Double.parseDouble(porcentaje) * Consultar.ConsultaPrecio(codigo)) / 100; // Equivalente del porcentaje
                    monto = String.valueOf(Consultar.ConsultaPrecio(codigo) - operacionPorcien);
                    precioTotal = String.valueOf(Integer.parseInt(cantidad) * Double.parseDouble(monto));
                    nuevoTotal = String.valueOf((Double.parseDouble(totalActual) - Double.parseDouble(precioT)) + Double.parseDouble(precioTotal));

                    modelTabla.setValueAt(monto, fila, 3);
                    modelTabla.setValueAt(precioTotal, fila, 4);

                    txt.setText(nuevoTotal);
                    txt_Monto.setText("");
                    txt_Porcentaje.setText("");
                    this.dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar al menos uno de los campos");
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
            java.util.logging.Logger.getLogger(Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Descuento dialog = new Descuento(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel_FondoDescuento;
    private javax.swing.JLabel jLabel_Monto;
    private javax.swing.JLabel jLabel_Porcentaje;
    private javax.swing.JLabel jLabel_Simbolo;
    private javax.swing.JTextField txt_Monto;
    private javax.swing.JTextField txt_Porcentaje;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private DefaultTableModel modelTabla;
    private JTable tabla;
    private JTextField txt;

    private String monto;
    private String porcentaje;
    private String cantidad;
    private String codigo;
    private String precioT;
    private String precioTotal;
    private String totalActual;
    private String nuevoTotal;

    private int fila;
}
