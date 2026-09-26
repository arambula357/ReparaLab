package gui.dialogs;

import com.bd.Consultar;
import com.bd.Actualizar;
import com.construir.Imagenes;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;

/**
 *
 * @author Diego Arambula
 */
public class InfoVenta extends javax.swing.JDialog {

    public InfoVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public InfoVenta(int idVenta) {
        initComponents();
        this.idVenta = idVenta;
        info = Consultar.ConsultarInfoVenta(idVenta);
        setSize(650, 500);
        setTitle("Información de venta");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Imagenes.setImagenFondo(jLabel_Wallpaper);

        if (info[0].equals("0")) {
            nombreCliente = "S/ Registro";
        } else {
            nombreCliente = Consultar.ConsultarNombreCliente(Integer.parseInt(info[0]));
        }

        initTextFields();

        if (info[7].equals("Correcta")) {

            jButton_Cancelar.setVisible(true);
            jLabel_Titulo.setText("Información de venta");
            txt_Cancelado.setVisible(false);
            jLabel_Cancelado.setVisible(false);
        } else {

            jButton_Cancelar.setVisible(false);
            jLabel_Titulo.setText("Información de venta (Cancelada)");
            jLabel_Titulo.setForeground(Color.GRAY);
            txt_Cancelado.setVisible(true);
            jLabel_Cancelado.setVisible(true);
            txt_Cancelado.setText(info[8]);
        }
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
        jLabel_Folio = new javax.swing.JLabel();
        txt_Folio = new javax.swing.JTextField();
        jLabel_TipoVenta = new javax.swing.JLabel();
        txt_TipoVenta = new javax.swing.JTextField();
        jLabel_Total = new javax.swing.JLabel();
        txt_Total = new javax.swing.JTextField();
        jLabel_Fecha = new javax.swing.JLabel();
        txt_Fecha = new javax.swing.JTextField();
        jLabel_Vendedor = new javax.swing.JLabel();
        txt_Vendedor = new javax.swing.JTextField();
        jLabel_Articulos = new javax.swing.JLabel();
        jLabel_Descrip = new javax.swing.JLabel();
        jLabel_Cancelado = new javax.swing.JLabel();
        txt_Cancelado = new javax.swing.JTextField();
        jScrollPane_Articulos = new javax.swing.JScrollPane();
        txt_Articulos = new javax.swing.JTextPane();
        jButton_Cancelar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información de venta");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txt_Nombre.setBackground(new java.awt.Color(3, 37, 251));
        txt_Nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Nombre.setEnabled(false);
        getContentPane().add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, -1));

        jLabel_Folio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Folio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Folio.setText("Folio:");
        getContentPane().add(jLabel_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txt_Folio.setBackground(new java.awt.Color(3, 37, 251));
        txt_Folio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Folio.setForeground(new java.awt.Color(255, 255, 255));
        txt_Folio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Folio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Folio.setEnabled(false);
        getContentPane().add(txt_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 210, -1));

        jLabel_TipoVenta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_TipoVenta.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_TipoVenta.setText("Tipo de venta:");
        getContentPane().add(jLabel_TipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        txt_TipoVenta.setBackground(new java.awt.Color(3, 37, 251));
        txt_TipoVenta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TipoVenta.setForeground(new java.awt.Color(255, 255, 255));
        txt_TipoVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TipoVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_TipoVenta.setEnabled(false);
        getContentPane().add(txt_TipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 210, -1));

        jLabel_Total.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Total.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Total.setText("Total:");
        getContentPane().add(jLabel_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txt_Total.setBackground(new java.awt.Color(3, 37, 251));
        txt_Total.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Total.setForeground(new java.awt.Color(255, 255, 255));
        txt_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Total.setEnabled(false);
        getContentPane().add(txt_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, -1));

        jLabel_Fecha.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Fecha.setText("Fecha:");
        getContentPane().add(jLabel_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txt_Fecha.setBackground(new java.awt.Color(3, 37, 251));
        txt_Fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_Fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Fecha.setEnabled(false);
        getContentPane().add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 210, -1));

        jLabel_Vendedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Vendedor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Vendedor.setText("Vendedor:");
        getContentPane().add(jLabel_Vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        txt_Vendedor.setBackground(new java.awt.Color(3, 37, 251));
        txt_Vendedor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Vendedor.setForeground(new java.awt.Color(255, 255, 255));
        txt_Vendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Vendedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Vendedor.setEnabled(false);
        getContentPane().add(txt_Vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 210, -1));

        jLabel_Articulos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Articulos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Articulos.setText("Articulos:");
        getContentPane().add(jLabel_Articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jLabel_Descrip.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Descrip.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Descrip.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Descrip.setText("Cant            Codigo               Nombre");
        getContentPane().add(jLabel_Descrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 350, -1));

        jLabel_Cancelado.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Cancelado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cancelado.setText("Cancelada por:");
        getContentPane().add(jLabel_Cancelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        txt_Cancelado.setBackground(new java.awt.Color(3, 37, 251));
        txt_Cancelado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Cancelado.setForeground(new java.awt.Color(255, 255, 255));
        txt_Cancelado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Cancelado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_Cancelado.setEnabled(false);
        getContentPane().add(txt_Cancelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 210, -1));

        jScrollPane_Articulos.setEnabled(false);

        txt_Articulos.setEditable(false);
        jScrollPane_Articulos.setViewportView(txt_Articulos);

        getContentPane().add(jScrollPane_Articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 350, 250));

        jButton_Cancelar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Cancelar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cancelar.setText("Cancelar venta");
        jButton_Cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 130, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed

        int seleccion = JOptionPane.showOptionDialog(null, "Al cancelar la venta no elimina el registro,\neste proceso no se podrá revertir\n¿Desea continuar?",
                "Cancelar venta",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"SI", "NO"},
                "SI");

        if (seleccion == JOptionPane.YES_OPTION) {

            Actualizar.ActualizarVenta(idVenta);
            Actualizar.ActualizarSumatoria(idVenta);
            JOptionPane.showMessageDialog(null, "La venta ha sido cancelada");
            this.dispose();
        }

    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void initTextFields() {
        txt_Nombre.setText(nombreCliente);
        txt_Folio.setText(String.valueOf(info[1]));
        txt_TipoVenta.setText(info[2]);
        txt_Total.setText(String.valueOf(info[3]));
        txt_Fecha.setText(String.valueOf(info[4]));
        txt_Vendedor.setText(info[5]);
        txt_Articulos.setText(info[6]);
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
            java.util.logging.Logger.getLogger(InfoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoVenta dialog = new InfoVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_Cancelar;
    private javax.swing.JLabel jLabel_Articulos;
    private javax.swing.JLabel jLabel_Cancelado;
    private javax.swing.JLabel jLabel_Descrip;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_Folio;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_TipoVenta;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Total;
    private javax.swing.JLabel jLabel_Vendedor;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane_Articulos;
    private javax.swing.JTextPane txt_Articulos;
    private javax.swing.JTextField txt_Cancelado;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_Folio;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_TipoVenta;
    private javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_Vendedor;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private int idVenta;

    private String nombreCliente;
    private String[] info;
}
