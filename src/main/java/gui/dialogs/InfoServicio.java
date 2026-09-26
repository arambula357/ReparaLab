package gui.dialogs;

import com.bd.Consultar;
import com.bd.Actualizar;
import com.construir.Imagenes;
import com.utilidades.Utilidades;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class InfoServicio extends javax.swing.JDialog {

    public InfoServicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InfoServicio(String codigo) {
        initComponents();
        this.codigo = codigo;
        this.idServicio = Consultar.ConsultarIdArticulo(codigo);
        this.infoServicio = Consultar.ConsultarInfoServicio(codigo);
        this.usuario = Utilidades.getUsuarioActivo();
        setSize(435, 345);
        setTitle("Información servicio");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_Wallpaper);
        Imagenes.setImagenBoton(jButton_Actualizar, "images/iconoActualizar.png", false);

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

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        jLabel_Codigo = new javax.swing.JLabel();
        txt_Codigo = new javax.swing.JTextField();
        jLabel_Precio = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jLabel_UltimaActualizacion = new javax.swing.JLabel();
        txt_UltimaActualizacion = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo.setText("Información del servicio");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 430, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        jLabel_Codigo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Codigo.setText("Código:");
        getContentPane().add(jLabel_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txt_Codigo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Codigo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Codigo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        jLabel_Precio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Precio.setText("Precio:");
        getContentPane().add(jLabel_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_Precio.setBackground(new java.awt.Color(3, 37, 251));
        txt_Precio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Precio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Precio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        jLabel_UltimaActualizacion.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_UltimaActualizacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UltimaActualizacion.setText("Ultima modificacion:");
        getContentPane().add(jLabel_UltimaActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_UltimaActualizacion.setBackground(new java.awt.Color(3, 37, 251));
        txt_UltimaActualizacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_UltimaActualizacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_UltimaActualizacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_UltimaActualizacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_UltimaActualizacion.setEnabled(false);
        getContentPane().add(txt_UltimaActualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 110, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        String nombre = txt_Nombre.getText().trim();
        codigo = txt_Codigo.getText().trim();
        String precio = txt_Precio.getText().trim();

        if ((txt_Nombre.getText().trim()).equals("") || (txt_Codigo.getText().trim()).equals("")
                || (txt_Precio.getText().trim()).equals("")) {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        } else {
            if (Consultar.ConsultarCodigoArticulo(idServicio, codigo)) {
                JOptionPane.showMessageDialog(null, "El código no esta disponible, intenta con otro");
            } else {

                Actualizar.ActualizarInfoServicio(idServicio, new String[]{codigo, nombre, precio, usuario});
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void initTextFields() {
        txt_Nombre.setText(infoServicio[0]);
        txt_Codigo.setText(codigo);
        txt_Precio.setText(infoServicio[1]);
        txt_UltimaActualizacion.setText(infoServicio[2]);
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
            java.util.logging.Logger.getLogger(InfoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoServicio dialog = new InfoServicio(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_UltimaActualizacion;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_UltimaActualizacion;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private int idServicio;
    private String codigo;
    private String usuario;
    private String[] infoServicio;

}
