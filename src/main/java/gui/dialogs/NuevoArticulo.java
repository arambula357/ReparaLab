package gui.dialogs;

import com.bd.Consultar;
import com.bd.Registrar;
import com.construir.Imagenes;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class NuevoArticulo extends javax.swing.JDialog {

    public NuevoArticulo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public NuevoArticulo() {
        initComponents();
        setSize(435, 455);
        setTitle("Nuevo articulo");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_Wallpaper);
        Imagenes.setImagenBoton(jButton_Alta, "images/iconoNUbeFlecha.png", false);
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
        cmb_TipoArticulo = new javax.swing.JComboBox<>();
        jLabel_TipoArticulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_Codigo = new javax.swing.JLabel();
        txt_Codigo = new javax.swing.JTextField();
        jLabel_Precio = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jLabel_CantidadActual = new javax.swing.JLabel();
        txt_Cantidad = new javax.swing.JTextField();
        jButton_Alta = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Nuevo articulo");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        cmb_TipoArticulo.setEditable(true);
        cmb_TipoArticulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto", "Servicio" }));
        cmb_TipoArticulo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_TipoArticuloItemStateChanged(evt);
            }
        });
        getContentPane().add(cmb_TipoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel_TipoArticulo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_TipoArticulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TipoArticulo.setText("Tipo de articulo:");
        getContentPane().add(jLabel_TipoArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        jLabel_Codigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Codigo.setText("Código:");
        getContentPane().add(jLabel_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_Codigo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Codigo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        jLabel_Precio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Precio.setText("Precio:");
        getContentPane().add(jLabel_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_Precio.setBackground(new java.awt.Color(3, 37, 251));
        txt_Precio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Precio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        jLabel_CantidadActual.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_CantidadActual.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_CantidadActual.setText("Cantidad:");
        getContentPane().add(jLabel_CantidadActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txt_Cantidad.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, -1));

        jButton_Alta.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AltaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 110, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_TipoArticuloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_TipoArticuloItemStateChanged

        if ((cmb_TipoArticulo.getSelectedItem()).equals("Producto")) {
            txt_Cantidad.setEnabled(true);
        } else {
            txt_Cantidad.setEnabled(false);
        }

    }//GEN-LAST:event_cmb_TipoArticuloItemStateChanged

    private void jButton_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltaActionPerformed
        String nombre = txt_Nombre.getText().trim();
        String codigo = txt_Codigo.getText().trim();
        String cantidad = txt_Cantidad.getText().trim();
        String precio = txt_Precio.getText().trim();
        String tipo = cmb_TipoArticulo.getSelectedItem().toString();

        if (tipo.equals("Producto")) {
            if (nombre.equals("") || codigo.equals("") || precio.equals("") || cantidad.equals("")) {

                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos, incluye la cantidad");
            } else{
                if (Consultar.ConsultarCodigoArticulo(codigo)) {

                    JOptionPane.showMessageDialog(null, "el código no esta disponible,\nintente con otro nuevamente");
                } else {

                    Registrar.RegistrarProducto(new String[]{nombre, codigo, cantidad, precio, tipo});

                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
        } else {
            if (nombre.equals("") || codigo.equals("") || precio.equals("") || cantidad.equals("")) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos, incluye la cantidad");
            } else{
                if (Consultar.ConsultarCodigoArticulo(codigo)) {

                    JOptionPane.showMessageDialog(null, "el código no esta disponible,\nintente con otro nuevamente");
                } else {

                    Registrar.RegistrarServicio(new String[]{nombre, codigo, precio, tipo});

                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
            }
        }
    }//GEN-LAST:event_jButton_AltaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NuevoArticulo dialog = new NuevoArticulo(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmb_TipoArticulo;
    private javax.swing.JButton jButton_Alta;
    private javax.swing.JLabel jLabel_CantidadActual;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JLabel jLabel_TipoArticulo;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_Cantidad;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    // End of variables declaration//GEN-END:variables
}
