package gui.ventanas;

import com.bd.Consultar;
import com.construir.Tablas;
import com.construir.Imagenes;
import com.utilidades.Utilidades;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tecnico extends javax.swing.JFrame {

    public Tecnico() {
        initComponents();
        setSize(795, 720);
        setTitle("Administrador");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initFondos();

        jLabel_NombreUsurario.setText(Consultar.ConsultarNombreUsuario(Utilidades.getUsuarioActivo()));
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

        jTabbedPane_General = new javax.swing.JTabbedPane();
        jPanel_VistaTecnico = new javax.swing.JPanel();
        jTabbedPane_VistaTecnico = new javax.swing.JTabbedPane();
        jPanel_GestionarEquipos = new javax.swing.JPanel();
        jLabel_Titulo4 = new javax.swing.JLabel();
        cmb_Estatus = new javax.swing.JComboBox<>();
        scrollEquipos = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jLabel_FondoGestionarEquipos = new javax.swing.JLabel();
        jLabel_FondoVistaTecnico = new javax.swing.JLabel();
        jLabel_NombreUsurario = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu_Opciones = new javax.swing.JMenu();
        jMenuItem_CerrarSesion = new javax.swing.JMenuItem();
        jMenuItem_Acercade = new javax.swing.JMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_InfoVersion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_VistaTecnico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaTecnico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_GestionarEquipos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GestionarEquipos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo4.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        jLabel_Titulo4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo4.setText("Equipos registrados");
        jPanel_GestionarEquipos.add(jLabel_Titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 740, 40));

        cmb_Estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "En revision", "Reparado", "No reparado", "Entregado" }));
        cmb_Estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_EstatusActionPerformed(evt);
            }
        });
        jPanel_GestionarEquipos.add(cmb_Estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 130, -1));

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEquipos.setToolTipText("");
        scrollEquipos.setViewportView(tablaEquipos);
        modelEquipos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelEquipos.setRowCount(0);
        modelEquipos.setColumnCount(0);
        tablaEquipos = new JTable(modelEquipos);
        scrollEquipos.setViewportView(tablaEquipos);
        String Q_Equipos = "select id_equipo, marca, modelo, estatus from equipos";
        String[] T_Equipos = {"Folio", "Marca", "Modelo", "Estatus"};
        buildTabla.buildTablaEquiposT(modelEquipos, tablaEquipos, scrollEquipos, Q_Equipos, 4, T_Equipos);

        jPanel_GestionarEquipos.add(scrollEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 715, 410));
        jPanel_GestionarEquipos.add(jLabel_FondoGestionarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 740, 520));

        jTabbedPane_VistaTecnico.addTab("Gestionar equipos", jPanel_GestionarEquipos);

        jPanel_VistaTecnico.add(jTabbedPane_VistaTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 550));
        jPanel_VistaTecnico.add(jLabel_FondoVistaTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Vista Tecnico", jPanel_VistaTecnico);

        getContentPane().add(jTabbedPane_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 760, 600));

        jLabel_NombreUsurario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsurario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsurario.setText("jLabel1");
        getContentPane().add(jLabel_NombreUsurario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 790, 700));

        jMenu_Opciones.setText("Opciones");

        jMenuItem_CerrarSesion.setText("Cerrar sesión");
        jMenuItem_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CerrarSesionActionPerformed(evt);
            }
        });
        jMenu_Opciones.add(jMenuItem_CerrarSesion);

        jMenuItem_Acercade.setText("Acerca de");
        jMenuItem_Acercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AcercadeActionPerformed(evt);
            }
        });
        jMenu_Opciones.add(jMenuItem_Acercade);

        jMenuBar.add(jMenu_Opciones);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_InfoVersion.setText("info versión");
        jMenuItem_InfoVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_InfoVersionActionPerformed(evt);
            }
        });
        jMenu_Ayuda.add(jMenuItem_InfoVersion);

        jMenuBar.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CerrarSesionActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_CerrarSesionActionPerformed

    private void jMenuItem_AcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AcercadeActionPerformed

        JOptionPane.showMessageDialog(null, "Creado por Diego arambula", "Acerca de", HEIGHT);

    }//GEN-LAST:event_jMenuItem_AcercadeActionPerformed

    private void cmb_EstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_EstatusActionPerformed
        String seleccion = cmb_Estatus.getSelectedItem().toString();
        String Q_Equipos;
        String[] T_Equipos = {"Folio", "Marca", "Modelo", "Estatus"};

        modelEquipos.setRowCount(0);
        modelEquipos.setColumnCount(0);
        tablaEquipos = new JTable(modelEquipos);
        scrollEquipos.setViewportView(tablaEquipos);

        if (seleccion.equals("Todos")) {
            Q_Equipos = "select id_equipo, marca, modelo, estatus from equipos";
        } else {
            Q_Equipos = "select id_equipo, marca, modelo, estatus from equipos where estatus = ?";
        }

        buildTabla.buildTablaEquiposT(modelEquipos, tablaEquipos, scrollEquipos, Q_Equipos, 4, T_Equipos, seleccion.equals("Todos") ? new Object[]{} : new Object[]{seleccion});
    }//GEN-LAST:event_cmb_EstatusActionPerformed

    private void jMenuItem_InfoVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_InfoVersionActionPerformed
        new gui.dialogs.InfoVersion().setVisible(true);
    }//GEN-LAST:event_jMenuItem_InfoVersionActionPerformed

    private void initFondos() {
        Imagenes.setImagenFondo(jLabel_Wallpaper);
        Imagenes.setImagenFondo(jLabel_FondoVistaTecnico);
        Imagenes.setImagenFondo(jLabel_FondoGestionarEquipos);
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
            java.util.logging.Logger.getLogger(Tecnico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Estatus;
    private javax.swing.JLabel jLabel_FondoGestionarEquipos;
    private javax.swing.JLabel jLabel_FondoVistaTecnico;
    private javax.swing.JLabel jLabel_NombreUsurario;
    private javax.swing.JLabel jLabel_Titulo4;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem_Acercade;
    private javax.swing.JMenuItem jMenuItem_CerrarSesion;
    private javax.swing.JMenuItem jMenuItem_InfoVersion;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_Opciones;
    private javax.swing.JPanel jPanel_GestionarEquipos;
    private javax.swing.JPanel jPanel_VistaTecnico;
    private javax.swing.JTabbedPane jTabbedPane_General;
    private javax.swing.JTabbedPane jTabbedPane_VistaTecnico;
    private javax.swing.JScrollPane scrollEquipos;
    private javax.swing.JTable tablaEquipos;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private Tablas buildTabla = new Tablas();

    public static DefaultTableModel modelUsuarios;
    public static DefaultTableModel modelClientes;
    public static DefaultTableModel modelEquipos;
    public static DefaultTableModel modelArticulos;
    public static DefaultTableModel modelProductos;
    public static DefaultTableModel modelServicios;
    public static DefaultTableModel modelVentas;
}
