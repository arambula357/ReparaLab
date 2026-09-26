package gui.ventanas;

import com.TicketRecepcion;
import com.TicketVenta;
import com.bd.Conexion;
import com.bd.Consultar;
import com.bd.Registrar;
import com.bd.Actualizar;
import com.construir.Tablas;
import com.construir.Imagenes;
import com.eventos.Teclado;
import com.eventos.Mouse;
import com.utilidades.Utilidades;
import com.utilidades.NumeroLetras;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.sql.*;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.FileOutputStream;

import net.sf.jasperreports.engine.JRException;

public class Capturista extends javax.swing.JFrame {

    public Capturista() {
        initComponents();
        setSize(795, 720);
        setTitle("Capturista");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initFondos();
        initBotones();
        initCamposVenta();

        jLabel_NombreUsurario.setText(Consultar.ConsultarNombreUsuario(Utilidades.getUsuarioActivo()));

        Mouse.DobleClickArticulos(modelArticulos, tablaArticulos, txtV_Total);
        eventoTeclado.setCambio(txtV_PagaCon, txtV_Cambio, txtV_Total);
        eventoTeclado.BuscarHistorial(txt_BuscarCliente, modelClientes, tablaClientes, scrollClientes);
        eventoTeclado.BuscarProducto(txt_BuscarProducto, modelProductos, tablaProductos, scrollProductos);
        eventoTeclado.BuscarServicio(txt_BuscarServicio, modelServicios, tablaServicios, scrollServicios);
        eventoTeclado.addProducto(txtV_addProducto, txtV_Total, modelArticulos);
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
        jPanel_VistaCapturista = new javax.swing.JPanel();
        jTabbedPane_VistaCapturista = new javax.swing.JTabbedPane();
        jPanel_RegistrarEquipo = new javax.swing.JPanel();
        jLabel_Titulo2 = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        txt_NombreCliente = new javax.swing.JTextField();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        txt_Modelo = new javax.swing.JTextField();
        jLabel_Nombre4 = new javax.swing.JLabel();
        txt_NumeroSerie = new javax.swing.JTextField();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jScrollPane_Observaciones = new javax.swing.JScrollPane();
        txt_Observaciones = new javax.swing.JTextPane();
        jButton_RegistrarEquipo = new javax.swing.JButton();
        txt_TipoEquipo = new javax.swing.JTextField();
        txt_Marca = new javax.swing.JTextField();
        txt_TelefonoCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton_BuscarCliente = new javax.swing.JButton();
        jLabel_FondoRegistrarEquipo = new javax.swing.JLabel();
        jPanel_GestionarClientes = new javax.swing.JPanel();
        scrollClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel_Titulo3 = new javax.swing.JLabel();
        jButton_Imprimir = new javax.swing.JButton();
        txt_BuscarCliente = new javax.swing.JTextField();
        jLabel_FondoGestionarClientes = new javax.swing.JLabel();
        jLabel_FondoVistaCapturista = new javax.swing.JLabel();
        jPanel_VistaVentas = new javax.swing.JPanel();
        jTabbedPane_VistaVentas = new javax.swing.JTabbedPane();
        jPanel_GenerarVenta = new javax.swing.JPanel();
        jLabelV_NombreCliente = new javax.swing.JLabel();
        txtV_NombreCliente = new javax.swing.JTextField();
        jLabelV_Folio = new javax.swing.JLabel();
        txtV_Folio = new javax.swing.JTextField();
        jLabelV_Modelo = new javax.swing.JLabel();
        txtV_Modelo = new javax.swing.JTextField();
        jLabelV_NumeroSerie = new javax.swing.JLabel();
        txtV_NumeroSerie = new javax.swing.JTextField();
        jLabelV_Marca = new javax.swing.JLabel();
        scrollArticulos = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        jButton_BuscarEquipo = new javax.swing.JButton();
        jButton_CerrarVenta = new javax.swing.JButton();
        txtV_Total = new javax.swing.JTextField();
        jLabel_Total = new javax.swing.JLabel();
        jLabel_PagaCon = new javax.swing.JLabel();
        txtV_PagaCon = new javax.swing.JTextField();
        txtV_Cambio = new javax.swing.JTextField();
        jLabel_Cambio = new javax.swing.JLabel();
        cmbV_TipoVenta = new javax.swing.JComboBox<>();
        cmbV_VentaRegistrada = new javax.swing.JComboBox<>();
        txtV_Marca = new javax.swing.JTextField();
        jLabel_VentaRegistrada = new javax.swing.JLabel();
        jButton_Comun = new javax.swing.JButton();
        jButton_Salida = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        txtV_addProducto = new javax.swing.JTextField();
        jLabel_FondoGenerarVenta = new javax.swing.JLabel();
        jPanel_Inventario = new javax.swing.JPanel();
        scrollProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        scrollServicios = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        txt_BuscarServicio = new javax.swing.JTextField();
        txt_BuscarProducto = new javax.swing.JTextField();
        jButton_Altas = new javax.swing.JButton();
        jLabel_FondoInventario = new javax.swing.JLabel();
        jPanel_Cortes = new javax.swing.JPanel();
        scrollVentas = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        cmb_DeDia = new javax.swing.JComboBox<>();
        cmb_DeMes = new javax.swing.JComboBox<>();
        cmb_DeAnnio = new javax.swing.JComboBox<>();
        cmb_ADia = new javax.swing.JComboBox<>();
        cmb_AMes = new javax.swing.JComboBox<>();
        cmb_AAnnio = new javax.swing.JComboBox<>();
        jLabel_De = new javax.swing.JLabel();
        jLabel_A = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton_Mostrar = new javax.swing.JButton();
        jButton_CorteDiario = new javax.swing.JButton();
        jButton_CorteCustom = new javax.swing.JButton();
        jLabel_Corte = new javax.swing.JLabel();
        jLabel_FondoCortes = new javax.swing.JLabel();
        jLabel_FondoVistaVentas = new javax.swing.JLabel();
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

        jPanel_VistaCapturista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaCapturista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_RegistrarEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_RegistrarEquipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo2.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        jLabel_Titulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo2.setText("Registro de equipo");
        jPanel_RegistrarEquipo.add(jLabel_Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 740, 40));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 210, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txt_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 210, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Número de serie:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        txt_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txt_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Daño reportado y observaciones:");
        jPanel_RegistrarEquipo.add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jScrollPane_Observaciones.setViewportView(txt_Observaciones);

        jPanel_RegistrarEquipo.add(jScrollPane_Observaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 420, 260));

        jButton_RegistrarEquipo.setBackground(new java.awt.Color(1, 89, 255));
        jButton_RegistrarEquipo.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarEquipo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_RegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarEquipoActionPerformed(evt);
            }
        });
        jPanel_RegistrarEquipo.add(jButton_RegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 120, 100));

        txt_TipoEquipo.setBackground(new java.awt.Color(3, 37, 251));
        txt_TipoEquipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TipoEquipo.setForeground(new java.awt.Color(255, 255, 255));
        txt_TipoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TipoEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_TipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 210, -1));

        txt_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txt_Marca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        txt_TelefonoCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_TelefonoCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_TelefonoCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_TelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TelefonoCliente.setToolTipText("");
        txt_TelefonoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_RegistrarEquipo.add(txt_TelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teléfono:");
        jPanel_RegistrarEquipo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jButton_BuscarCliente.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarClienteActionPerformed(evt);
            }
        });
        jPanel_RegistrarEquipo.add(jButton_BuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 30, 25));
        jPanel_RegistrarEquipo.add(jLabel_FondoRegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        jTabbedPane_VistaCapturista.addTab("Registrar equipo", jPanel_RegistrarEquipo);

        jPanel_GestionarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GestionarClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollClientes.setViewportView(tablaClientes);
        modelClientes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelClientes.setRowCount(0);
        modelClientes.setColumnCount(0);
        tablaClientes = new JTable(modelClientes);
        scrollClientes.setViewportView(tablaClientes);
        String Q_Clientes = "select id_cliente, nombre_cliente, tel_cliente from clientes";
        String[] T_Clientes = {"ID", "Nombre", "Telefono"};
        buildTabla.buildTablaClientes(modelClientes, tablaClientes, scrollClientes, Q_Clientes, 3, T_Clientes);

        jPanel_GestionarClientes.add(scrollClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 715, 300));

        jLabel_Titulo3.setFont(new java.awt.Font("Arial", 0, 28)); // NOI18N
        jLabel_Titulo3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Titulo3.setText("Clientes registrados");
        jPanel_GestionarClientes.add(jLabel_Titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 740, 40));

        jButton_Imprimir.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Imprimir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Imprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });
        jPanel_GestionarClientes.add(jButton_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 120, 100));

        txt_BuscarCliente.setBackground(new java.awt.Color(3, 37, 251));
        txt_BuscarCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_BuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GestionarClientes.add(txt_BuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 210, 25));
        jPanel_GestionarClientes.add(jLabel_FondoGestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 510));

        jTabbedPane_VistaCapturista.addTab("Gestionar clientes", jPanel_GestionarClientes);

        jPanel_VistaCapturista.add(jTabbedPane_VistaCapturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 530));
        jPanel_VistaCapturista.add(jLabel_FondoVistaCapturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Vista Capturista", jPanel_VistaCapturista);

        jPanel_VistaVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_VistaVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane_VistaVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel_GenerarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_GenerarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelV_NombreCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_NombreCliente.setText("Nombre cliente:");
        jPanel_GenerarVenta.add(jLabelV_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtV_NombreCliente.setBackground(new java.awt.Color(3, 37, 251));
        txtV_NombreCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtV_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 25));

        jLabelV_Folio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_Folio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_Folio.setText("Folio:");
        jPanel_GenerarVenta.add(jLabelV_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtV_Folio.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Folio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Folio.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Folio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Folio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 25));

        jLabelV_Modelo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_Modelo.setText("Modelo:");
        jPanel_GenerarVenta.add(jLabelV_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtV_Modelo.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Modelo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Modelo.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 210, 25));

        jLabelV_NumeroSerie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_NumeroSerie.setText("Número de serie:");
        jPanel_GenerarVenta.add(jLabelV_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        txtV_NumeroSerie.setBackground(new java.awt.Color(3, 37, 251));
        txtV_NumeroSerie.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txtV_NumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_NumeroSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_NumeroSerie.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_NumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 210, 25));

        jLabelV_Marca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelV_Marca.setForeground(new java.awt.Color(255, 255, 255));
        jLabelV_Marca.setText("Marca:");
        jPanel_GenerarVenta.add(jLabelV_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        tablaArticulos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaArticulos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollArticulos.setViewportView(tablaArticulos);
        if (tablaArticulos.getColumnModel().getColumnCount() > 0) {
            tablaArticulos.getColumnModel().getColumn(0).setPreferredWidth(5);
        }
        modelArticulos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelArticulos.setRowCount(0);
        modelArticulos.setColumnCount(0);
        tablaArticulos = new JTable(modelArticulos);
        scrollArticulos.setViewportView(tablaArticulos);
        String[] T_Articulos = {"Cantidad", "Codigo", "Nombre", "Precio U.", "Precio T."};
        buildTabla.buildTablaArticulos(modelArticulos, tablaArticulos, scrollArticulos, "", 5, T_Articulos);

        jPanel_GenerarVenta.add(scrollArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 500, 230));

        jButton_BuscarEquipo.setBackground(new java.awt.Color(1, 89, 255));
        jButton_BuscarEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_BuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarEquipoActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_BuscarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 30, 25));

        jButton_CerrarVenta.setBackground(new java.awt.Color(1, 89, 255));
        jButton_CerrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CerrarVenta.setText("Cerrar venta");
        jButton_CerrarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_CerrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CerrarVentaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_CerrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 80, 60));

        txtV_Total.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtV_Total.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Total.setText("0.0");
        txtV_Total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Total.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 100, 30));

        jLabel_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Total.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Total.setText("Total:");
        jPanel_GenerarVenta.add(jLabel_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jLabel_PagaCon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_PagaCon.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_PagaCon.setText("Paga con:");
        jPanel_GenerarVenta.add(jLabel_PagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        txtV_PagaCon.setBackground(new java.awt.Color(3, 37, 251));
        txtV_PagaCon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtV_PagaCon.setForeground(new java.awt.Color(255, 255, 255));
        txtV_PagaCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_PagaCon.setText("0.0");
        txtV_PagaCon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_PagaCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 100, 30));

        txtV_Cambio.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Cambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtV_Cambio.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Cambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Cambio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Cambio.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 100, 30));

        jLabel_Cambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_Cambio.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Cambio.setText("Cambio:");
        jPanel_GenerarVenta.add(jLabel_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, -1, -1));

        cmbV_TipoVenta.setForeground(new java.awt.Color(0, 0, 0));
        cmbV_TipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Transferencia" }));
        cmbV_TipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbV_TipoVentaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(cmbV_TipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 110, -1));

        cmbV_VentaRegistrada.setForeground(new java.awt.Color(0, 0, 0));
        cmbV_VentaRegistrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        cmbV_VentaRegistrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbV_VentaRegistradaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(cmbV_VentaRegistrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        txtV_Marca.setBackground(new java.awt.Color(3, 37, 251));
        txtV_Marca.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtV_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txtV_Marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtV_Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtV_Marca.setEnabled(false);
        jPanel_GenerarVenta.add(txtV_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, 25));

        jLabel_VentaRegistrada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel_VentaRegistrada.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_VentaRegistrada.setText("¿Venta registrada?");
        jPanel_GenerarVenta.add(jLabel_VentaRegistrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_Comun.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Comun.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Comun.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Comun.setText("Común");
        jButton_Comun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ComunActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_Comun, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 85, 25));

        jButton_Salida.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Salida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Salida.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salida.setText("Salida");
        jButton_Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalidaActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 75, 25));

        jButton_Eliminar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Eliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Eliminar.setText("Eliminar");
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        jPanel_GenerarVenta.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 90, 25));

        txtV_addProducto.setBackground(new java.awt.Color(3, 37, 251));
        txtV_addProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtV_addProducto.setForeground(new java.awt.Color(255, 255, 255));
        txtV_addProducto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtV_addProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_GenerarVenta.add(txtV_addProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 220, 25));
        jPanel_GenerarVenta.add(jLabel_FondoGenerarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

        jTabbedPane_VistaVentas.addTab("Generar venta", jPanel_GenerarVenta);

        jPanel_Inventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_Inventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProductos.setViewportView(tablaProductos);
        modelProductos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelProductos.setRowCount(0);
        modelProductos.setColumnCount(0);
        tablaProductos = new JTable(modelProductos);
        scrollProductos.setViewportView(tablaProductos);
        String Q_Productos = "select codigo, nombre, cantidad, precio from articulos where tipo_articulo = 'producto'";
        String[] T_Prodcutos = {"Código", "Nombre", "Cantidad", "Precio"};
        buildTabla.buildTablaProductos(modelProductos, tablaProductos, scrollProductos, Q_Productos, 4, T_Prodcutos);

        jPanel_Inventario.add(scrollProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 720, 170));

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollServicios.setViewportView(tablaServicios);
        modelServicios = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelServicios.setRowCount(0);
        modelServicios.setColumnCount(0);
        tablaServicios = new JTable(modelServicios);
        scrollServicios.setViewportView(tablaServicios);
        String Q_Servicios = "select codigo, nombre, precio from articulos where tipo_articulo = 'servicio'";
        String[] T_Servicios = {"Código", "Nombre", "Precio"};
        buildTabla.buildTablaServicios(modelServicios, tablaServicios, scrollServicios, Q_Servicios, 3, T_Servicios);

        jPanel_Inventario.add(scrollServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 720, 170));

        txt_BuscarServicio.setBackground(new java.awt.Color(3, 37, 251));
        txt_BuscarServicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_BuscarServicio.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarServicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Inventario.add(txt_BuscarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 210, 25));

        txt_BuscarProducto.setBackground(new java.awt.Color(3, 37, 251));
        txt_BuscarProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_BuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        txt_BuscarProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_BuscarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Inventario.add(txt_BuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 210, 25));

        jButton_Altas.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Altas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Altas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AltasActionPerformed(evt);
            }
        });
        jPanel_Inventario.add(jButton_Altas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 100, 70));
        jPanel_Inventario.add(jLabel_FondoInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

        jTabbedPane_VistaVentas.addTab("Inventario", jPanel_Inventario);

        jPanel_Cortes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollVentas.setViewportView(tablaVentas);
        modelVentas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelVentas.setRowCount(0);
        modelVentas.setColumnCount(0);
        tablaVentas = new JTable(modelVentas);
        scrollVentas.setViewportView(tablaVentas);
        String Q_Ventas = "select id_venta, id_equipo, tipo_venta, total, fecha_venta from ventas";
        String[] T_Ventas = {"ID", "Folio", "Tipo venta", "Total", "Fecha"};
        buildTabla.buildTablaVentas(modelVentas, tablaVentas, scrollVentas, Q_Ventas, 5, T_Ventas);

        jPanel_Cortes.add(scrollVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 720, 330));

        cmb_DeDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel_Cortes.add(cmb_DeDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cmb_DeMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel_Cortes.add(cmb_DeMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        cmb_DeAnnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", " " }));
        jPanel_Cortes.add(cmb_DeAnnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        cmb_ADia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel_Cortes.add(cmb_ADia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        cmb_AMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel_Cortes.add(cmb_AMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        cmb_AAnnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        jPanel_Cortes.add(cmb_AAnnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel_De.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_De.setText("De:");
        jPanel_Cortes.add(jLabel_De, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel_A.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_A.setText("A:");
        jPanel_Cortes.add(jLabel_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DD      /    MM     /     AAAA");
        jPanel_Cortes.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DD      /    MM     /     AAAA");
        jPanel_Cortes.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 160, -1));

        jButton_Mostrar.setBackground(new java.awt.Color(1, 89, 255));
        jButton_Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Mostrar.setText("Mostrar");
        jButton_Mostrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MostrarActionPerformed(evt);
            }
        });
        jPanel_Cortes.add(jButton_Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 30, 60, -1));

        jButton_CorteDiario.setBackground(new java.awt.Color(1, 89, 255));
        jButton_CorteDiario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_CorteDiario.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CorteDiario.setText("Diario");
        jButton_CorteDiario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_CorteDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CorteDiarioActionPerformed(evt);
            }
        });
        jPanel_Cortes.add(jButton_CorteDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 130, 40));

        jButton_CorteCustom.setBackground(new java.awt.Color(1, 89, 255));
        jButton_CorteCustom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_CorteCustom.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CorteCustom.setText("Personalizado");
        jButton_CorteCustom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_CorteCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CorteCustomActionPerformed(evt);
            }
        });
        jPanel_Cortes.add(jButton_CorteCustom, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 130, 40));

        jLabel_Corte.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_Corte.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Corte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Corte.setText("Corte:");
        jPanel_Cortes.add(jLabel_Corte, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 100, 30));
        jPanel_Cortes.add(jLabel_FondoCortes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 530));

        jTabbedPane_VistaVentas.addTab("Cortes", jPanel_Cortes);

        jPanel_VistaVentas.add(jTabbedPane_VistaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 740, 550));
        jPanel_VistaVentas.add(jLabel_FondoVistaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        jTabbedPane_General.addTab("Vista Ventas", jPanel_VistaVentas);

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

    private void jButton_RegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarEquipoActionPerformed
        orden = new TicketRecepcion(Consultar.ConsultarInfoEmpresa());

        String nombreCliente = txt_NombreCliente.getText().trim();
        String telefono = txt_TelefonoCliente.getText().trim();
        String tipo_equipo = txt_TipoEquipo.getText().trim();
        String marca = txt_Marca.getText().trim();
        String modelo = txt_Modelo.getText().trim();
        String numeroSerie = txt_NumeroSerie.getText().trim();
        String observaciones = txt_Observaciones.getText();
        String estatus = "Nuevo ingreso";
        String fechaHora = Utilidades.FechaActual() + " " + Utilidades.HoraActual();

        if (observaciones.equals("")) {
            txt_Observaciones.setText("Sin observaciones.");
            observaciones = "Sin observaciones";
        }
        if (tipo_equipo.equals("") || marca.equals("") || modelo.equals("")
                || numeroSerie.equals("") || nombreCliente.equals("") || telefono.equals("")) {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar");

        } else {

            int idCliente = Consultar.ConsultarIdCliente(nombreCliente);

            if (idCliente == 0) {

                Registrar.RegistrarCliente(nombreCliente, telefono);
                Registrar.RegistrarEquipo(Consultar.ConsultarUltimoCliente(), new String[]{tipo_equipo, marca, modelo, numeroSerie,
                    Utilidades.getDia(), Utilidades.getMes(), Utilidades.getAnnio(), Utilidades.HoraActual(), observaciones, estatus});

            } else {

                Actualizar.ActualizarInfoCliente(idCliente, new String[]{nombreCliente, telefono});
                Registrar.RegistrarEquipo(idCliente, new String[]{tipo_equipo, marca, modelo, numeroSerie,
                    Utilidades.getDia(), Utilidades.getMes(), Utilidades.getAnnio(), Utilidades.HoraActual(), observaciones, estatus});

            }
            LlenarOrden(new String[]{String.valueOf(Consultar.ConsultarUltimoEquipo()), fechaHora, nombreCliente, telefono, numeroSerie, tipo_equipo, marca, modelo, observaciones});
        }
    }//GEN-LAST:event_jButton_RegistrarEquipoActionPerformed

    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Cartera_Clientes.pdf"));

            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("images/BannerPDF.jpg");
            header.scaleToFit(550, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph tituloCliente = new Paragraph();
            tituloCliente.setAlignment(Paragraph.ALIGN_CENTER);
            tituloCliente.add("Informacion del cliente\n\n");
            tituloCliente.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            Paragraph tituloEquipos = new Paragraph();
            tituloEquipos.setAlignment(Paragraph.ALIGN_CENTER);
            tituloEquipos.add("\n\nEquipos registrados\n\n");
            tituloEquipos.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(tituloCliente);
            documento.add(TablaCliente());

            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");
        } catch (DocumentException | IOException e) {
            System.out.println("Error en PDF o ruta de imagen " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar PDF,\n"
                    + "Revise su conexión a internet o llame al administrador\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

    private void jMenuItem_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CerrarSesionActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem_CerrarSesionActionPerformed

    private void jMenuItem_AcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AcercadeActionPerformed

        JOptionPane.showMessageDialog(null, "Creado por Diego arambula", "Acerca de", HEIGHT);

    }//GEN-LAST:event_jMenuItem_AcercadeActionPerformed

    private void jButton_BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarClienteActionPerformed

        String nombreCliente = txt_NombreCliente.getText().trim();

        if (!(txt_NombreCliente.getText().trim()).equals("")) {

            txt_TelefonoCliente.setText(Consultar.ConsultarInfoCliente(nombreCliente));

        } else {
            JOptionPane.showMessageDialog(null, "El campo 'Nombre del cliente' esta vacio");
        }

    }//GEN-LAST:event_jButton_BuscarClienteActionPerformed

    private void jButton_BuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarEquipoActionPerformed
        int idCliente;
        String nombreCliente, folio;

        nombreCliente = txtV_NombreCliente.getText().trim();
        folio = txtV_Folio.getText().trim();

        if (!nombreCliente.equals("") && !folio.equals("")) {

            idCliente = Consultar.ConsultarIdCliente(nombreCliente);
            String[] info = Consultar.ConsultarInfoEquipo(Integer.parseInt(folio), idCliente);

            txtV_Marca.setText(info[0]);
            txtV_Modelo.setText(info[1]);
            txtV_NumeroSerie.setText(info[2]);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar los campos 'Nombre del cliente' y 'Folio'");
        }
    }//GEN-LAST:event_jButton_BuscarEquipoActionPerformed

    private void jButton_CerrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CerrarVentaActionPerformed
        ticketVenta = new TicketVenta(Consultar.ConsultarInfoEmpresa());
        String seleccion = cmbV_VentaRegistrada.getSelectedItem().toString();
        String tipoVenta = cmbV_TipoVenta.getSelectedItem().toString();
        String[] infoVenta = getInfoVenta();

        if (seleccion.equals("Si")) {
            if (infoVenta[0].equals("") || infoVenta[1].equals("") || infoVenta[2].equals("") || infoVenta[3].equals("") || infoVenta[4].equals("")) {

                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar");
            } else {
                if (tipoVenta.equals("Efectivo")) {
                    if (Double.parseDouble(infoVenta[7]) >= Double.parseDouble(infoVenta[6])) {

                        Registrar.RegistrarVenta(Consultar.ConsultarIdCliente(Integer.parseInt(infoVenta[1])), Integer.parseInt(infoVenta[1]),
                                new String[]{setAcumulacionV(), tipoVenta, infoVenta[6]});

                        Registrar.RegistrarSumatoria(Consultar.ConsultarUltimaVenta(), getCantidad(), getCodigo(), getNombre(), getPrecioT(), tipoVenta, modelArticulos.getRowCount());

                        setInfoTicket(new String[]{infoVenta[1], infoVenta[0], infoVenta[5], infoVenta[6], infoVenta[7], infoVenta[8]});

                        CopiaTicket(new String[]{infoVenta[1], infoVenta[0], infoVenta[5], infoVenta[6], infoVenta[7], infoVenta[8]});

                        JOptionPane.showMessageDialog(null, "Venta exitosa");
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad recibida no puede ser menor al total");
                    }
                } else {
                    Registrar.RegistrarVenta(Consultar.ConsultarIdCliente(Integer.parseInt(infoVenta[1])), Integer.parseInt(infoVenta[1]),
                            new String[]{setAcumulacionV(), tipoVenta, infoVenta[6]});

                    Registrar.RegistrarSumatoria(Consultar.ConsultarUltimaVenta(), getCantidad(), getCodigo(), getNombre(), getPrecioT(), tipoVenta, modelArticulos.getRowCount());

                    setInfoTicket(new String[]{infoVenta[1], infoVenta[0], infoVenta[5], infoVenta[6], "N/A", "N/A"});

                    CopiaTicket(new String[]{infoVenta[1], infoVenta[0], infoVenta[5], infoVenta[6], "N/A", "N/A"});

                    JOptionPane.showMessageDialog(null, "Venta exitosa");
                }
            }
        } else if (seleccion.equals("No")) {
            if (tipoVenta.equals("Efectivo")) {
                if (Double.parseDouble(infoVenta[7]) >= Double.parseDouble(infoVenta[6])) {

                    Registrar.RegistrarVenta(0, 0, new String[]{setAcumulacionV(), tipoVenta, infoVenta[6]});

                    Registrar.RegistrarSumatoria(Consultar.ConsultarUltimaVenta(), getCantidad(), getCodigo(), getNombre(), getPrecioT(), tipoVenta, modelArticulos.getRowCount());

                    setInfoTicket(new String[]{"S/Folio", "S/Registro", infoVenta[5], infoVenta[6], infoVenta[7], infoVenta[8]});

                    CopiaTicket(new String[]{"S/Folio", "S/Registro", infoVenta[5], infoVenta[6], infoVenta[7], infoVenta[8]});

                    JOptionPane.showMessageDialog(null, "Venta exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad recibida no puede ser menor al total");
                }
            } else {
                Registrar.RegistrarVenta(0, 0, new String[]{setAcumulacionV(), tipoVenta, infoVenta[6]});

                Registrar.RegistrarSumatoria(Consultar.ConsultarUltimaVenta(), getCantidad(), getCodigo(), getNombre(), getPrecioT(), tipoVenta, modelArticulos.getRowCount());

                setInfoTicket(new String[]{"S/Folio", "S/Registro", infoVenta[5], infoVenta[6], "N/A", "N/A"});

                CopiaTicket(new String[]{"S/Folio", "S/Registro", infoVenta[5], infoVenta[6], "N/A", "N/A"});

                JOptionPane.showMessageDialog(null, "Venta exitosa");
            }
        }
    }//GEN-LAST:event_jButton_CerrarVentaActionPerformed

    private void jButton_AltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AltasActionPerformed
        new gui.dialogs.NuevoArticulo().setVisible(true);
    }//GEN-LAST:event_jButton_AltasActionPerformed

    private void jButton_CorteDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CorteDiarioActionPerformed
        com.cortes.CorteDiario corte = new com.cortes.CorteDiario();
        corte.GenerarCorteDiario();
    }//GEN-LAST:event_jButton_CorteDiarioActionPerformed

    private void jButton_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MostrarActionPerformed
        modelVentas.setRowCount(0);
        modelVentas.setColumnCount(0);
        tablaVentas = new JTable(modelVentas);
        scrollVentas.setViewportView(tablaVentas);

        String deDia = cmb_DeDia.getSelectedItem().toString();
        String deMes = cmb_DeMes.getSelectedItem().toString();
        String deAnnio = cmb_DeAnnio.getSelectedItem().toString();
        String aDia = cmb_ADia.getSelectedItem().toString();
        String aMes = cmb_AMes.getSelectedItem().toString();
        String aAnnio = cmb_AAnnio.getSelectedItem().toString();
        String fechaI = deAnnio + "-" + deMes + "-" + deDia;
        String fechaF = aAnnio + "-" + aMes + "-" + aDia;

        java.sql.Date dateSQLI = java.sql.Date.valueOf(fechaI);
        java.sql.Date dateSQLF = java.sql.Date.valueOf(fechaF);

        String Q_Ventas = "select id_venta, id_equipo, tipo_venta, total, fecha_venta from ventas where fecha_venta between ? and ?";
        String[] T_Ventas = {"ID", "Folio", "Tipo venta", "Total", "Fecha"};

        buildTabla.buildTablaVentas(modelVentas, tablaVentas, scrollVentas, Q_Ventas, 5, T_Ventas, dateSQLI, dateSQLF);
    }//GEN-LAST:event_jButton_MostrarActionPerformed

    private void jButton_CorteCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CorteCustomActionPerformed
        String deDia = cmb_DeDia.getSelectedItem().toString();
        String deMes = cmb_DeMes.getSelectedItem().toString();
        String deAnnio = cmb_DeAnnio.getSelectedItem().toString();
        String aDia = cmb_ADia.getSelectedItem().toString();
        String aMes = cmb_AMes.getSelectedItem().toString();
        String aAnnio = cmb_AAnnio.getSelectedItem().toString();
        String fechaI = deAnnio + "-" + deMes + "-" + deDia;
        String fechaF = aAnnio + "-" + aMes + "-" + aDia;

        java.sql.Date dateSQLI = java.sql.Date.valueOf(fechaI);
        java.sql.Date dateSQLF = java.sql.Date.valueOf(fechaF);

        com.cortes.CorteCustom corte = new com.cortes.CorteCustom();
        corte.GenerarCorteCustom(dateSQLI, dateSQLF);
    }//GEN-LAST:event_jButton_CorteCustomActionPerformed

    private void cmbV_VentaRegistradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbV_VentaRegistradaActionPerformed
        String seleccion = cmbV_VentaRegistrada.getSelectedItem().toString();
        if (seleccion.equals("Si")) {
            txtV_NombreCliente.setEnabled(true);
            txtV_Folio.setEnabled(true);
            jButton_BuscarEquipo.setEnabled(true);
            jLabelV_NombreCliente.setVisible(true);
            jLabelV_Folio.setVisible(true);
            jLabelV_Marca.setVisible(true);
            jLabelV_Modelo.setVisible(true);
            jLabelV_NumeroSerie.setVisible(true);
            txtV_NombreCliente.setVisible(true);
            txtV_Folio.setVisible(true);
            txtV_Marca.setVisible(true);
            txtV_Modelo.setVisible(true);
            txtV_NumeroSerie.setVisible(true);
            jButton_BuscarEquipo.setVisible(true);
        } else if (seleccion.equals("No")) {
            txtV_NombreCliente.setEnabled(false);
            txtV_Folio.setEnabled(false);
            jButton_BuscarEquipo.setEnabled(false);
            jLabelV_NombreCliente.setVisible(false);
            jLabelV_Folio.setVisible(false);
            jLabelV_Marca.setVisible(false);
            jLabelV_Modelo.setVisible(false);
            jLabelV_NumeroSerie.setVisible(false);
            txtV_NombreCliente.setVisible(false);
            txtV_Folio.setVisible(false);
            txtV_Marca.setVisible(false);
            txtV_Modelo.setVisible(false);
            txtV_NumeroSerie.setVisible(false);
            jButton_BuscarEquipo.setVisible(false);
        }
    }//GEN-LAST:event_cmbV_VentaRegistradaActionPerformed

    private void jMenuItem_InfoVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_InfoVersionActionPerformed
        new gui.dialogs.InfoVersion().setVisible(true);
    }//GEN-LAST:event_jMenuItem_InfoVersionActionPerformed

    private void jButton_SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalidaActionPerformed
        new gui.dialogs.Salidas().setVisible(true);
    }//GEN-LAST:event_jButton_SalidaActionPerformed

    private void jButton_ComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ComunActionPerformed
        new gui.dialogs.Comun(modelArticulos, txtV_Total).setVisible(true);
    }//GEN-LAST:event_jButton_ComunActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        int filaSeleccionada = tablaArticulos.getSelectedRow();
        if (tablaArticulos.getValueAt(filaSeleccionada, 2).equals("")) {
            modelArticulos.removeRow(filaSeleccionada);
        } else {
            String precioTotal = (String) tablaArticulos.getValueAt(filaSeleccionada, 4);
            String totalActual = txtV_Total.getText().trim();
            String totalNuevo = String.valueOf(Double.parseDouble(totalActual) - Double.parseDouble(precioTotal));

            txtV_Total.setText(totalNuevo);
            modelArticulos.removeRow(filaSeleccionada);
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void cmbV_TipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbV_TipoVentaActionPerformed
        String tipoVenta = cmbV_TipoVenta.getSelectedItem().toString();

        if (tipoVenta.equals("Efectivo")) {
            txtV_PagaCon.setVisible(true);
        } else {
            txtV_PagaCon.setVisible(false);
        }
    }//GEN-LAST:event_cmbV_TipoVentaActionPerformed

    private void initFondos() {
        Imagenes.setImagenFondo(jLabel_Wallpaper);
        Imagenes.setImagenFondo(jLabel_FondoVistaCapturista);
        Imagenes.setImagenFondo(jLabel_FondoRegistrarEquipo);
        Imagenes.setImagenFondo(jLabel_FondoGestionarClientes);
        Imagenes.setImagenFondo(jLabel_FondoVistaVentas);
        Imagenes.setImagenFondo(jLabel_FondoGenerarVenta);
        Imagenes.setImagenFondo(jLabel_FondoInventario);
        Imagenes.setImagenFondo(jLabel_FondoCortes);
    }

    private void initBotones() {
        Imagenes.setImagenBoton(jButton_RegistrarEquipo, "images/addSmartphone.png", false);
        Imagenes.setImagenBoton(jButton_BuscarCliente, "images/iconoLupa.png", true);
        Imagenes.setImagenBoton(jButton_Imprimir, "images/impresora.png", false);
        Imagenes.setImagenBoton(jButton_BuscarEquipo, "images/iconoLupa.png", true);
        Imagenes.setImagenBoton(jButton_Altas, "images/iconoSignoMas.png", false);
    }

    private void initCamposVenta() {
        txtV_NombreCliente.setEnabled(true);
        txtV_Folio.setEnabled(true);
        jButton_BuscarEquipo.setEnabled(true);
        jLabelV_NombreCliente.setVisible(true);
        jLabelV_Folio.setVisible(true);
        jLabelV_Marca.setVisible(true);
        jLabelV_Modelo.setVisible(true);
        jLabelV_NumeroSerie.setVisible(true);
        txtV_NombreCliente.setVisible(true);
        txtV_Folio.setVisible(true);
        txtV_Marca.setVisible(true);
        txtV_Modelo.setVisible(true);
        txtV_NumeroSerie.setVisible(true);
        jButton_BuscarEquipo.setVisible(true);
    }

    private void LlenarOrden(String[] info) {
        orden.setFolio(info[0]);
        orden.setFechaHora(info[1]);
        orden.setNombreCliente(info[2]);
        orden.setContactoCliente(info[3]);
        orden.setNumeroSerie(info[4]);
        orden.setTipoEquipo(info[5]);
        orden.setMarca(info[6]);
        orden.setModelo(info[7]);
        orden.setObservaciones(info[8]);
        orden.setVendedor(Utilidades.getUsuarioActivo());

        try {
            orden.LlenarOrden();
        } catch (JRException ex) {
            System.err.println("Error al llenar la informacion del ticket " + ex);
        }
        txt_NombreCliente.setText("");
        txt_TelefonoCliente.setText("");
        txt_TipoEquipo.setText("");
        txt_Marca.setText("");
        txt_Modelo.setText("");
        txt_NumeroSerie.setText("");
        txt_Observaciones.setText("");
    }

    private PdfPTable TablaCliente() {
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Telefono");
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString("id_cliente"));
                        tabla.addCell(rs.getString("nombre_cliente"));
                        tabla.addCell(rs.getString("tel_cliente"));
                    } while (rs.next());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del cliente para el documento: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del cliente para el documento,\n"
                    + "Revise su conexión a internet o llame al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    private String[] getInfoVenta() {
        String nombreCliente = txtV_NombreCliente.getText().trim();
        String folio = txtV_Folio.getText().trim();
        String marca = txtV_Marca.getText().trim();
        String modelo = txtV_Modelo.getText().trim();
        String numeroSerie = txtV_NumeroSerie.getText().trim();
        String subTotal = txtV_Total.getText().trim();
        String total = txtV_Total.getText().trim();
        String recibo = txtV_PagaCon.getText().trim();
        String cambio = txtV_Cambio.getText().trim();
        String fecha = Utilidades.FechaActual();

        return new String[]{nombreCliente, folio, marca, modelo, numeroSerie, subTotal, total, recibo, cambio, fecha};
    }

    private String setAcumulacionT() {
        String articulosT = "";
        String[] cantidad = new String[modelArticulos.getRowCount()];
        String[] nombre = new String[modelArticulos.getRowCount()];
        String[] precio = new String[modelArticulos.getRowCount()];

        for (int i = 0; i < modelArticulos.getRowCount(); i++) {
            cantidad[i] = (String) modelArticulos.getValueAt(i, 0);
                nombre[i] = (String) modelArticulos.getValueAt(i, 2);
                precio[i] = (modelArticulos.getValueAt(i, 4)).toString();
                if (articulosT.equals("")) {

                    articulosT = cantidad[i] + " " + nombre[i] + " " + precio[i] + "\n";
                } else {

                    articulosT = articulosT + cantidad[i] + " " + nombre[i] + " " + precio[i] + "\n";
                }
            }
        return articulosT;
    }

    private String setAcumulacionV() {
        String articulosV = "";
        String[] cantidad = new String[modelArticulos.getRowCount()];
        String[] codigo = new String[modelArticulos.getRowCount()];
        String[] nombre = new String[modelArticulos.getRowCount()];

        for (int i = 0; i < modelArticulos.getRowCount(); i++) {
            cantidad[i] = (String) modelArticulos.getValueAt(i, 0);
            codigo[i] = (String) modelArticulos.getValueAt(i, 1);
            nombre[i] = (String) modelArticulos.getValueAt(i, 2);
            if (articulosV.equals("")) {

                articulosV = cantidad[i] + " " + codigo[i] + " " + nombre[i] + "\n";
            } else {

                articulosV = articulosV + cantidad[i] + " " + codigo[i] + " " + nombre[i] + "\n";
            }
        }
        return articulosV;
    }

    private String[] getCantidad() {
        String[] cantidad = new String[modelArticulos.getRowCount()];

        for (int i = 0; i < modelArticulos.getRowCount(); i++) {

            cantidad[i] = (String) modelArticulos.getValueAt(i, 0);
        }
        return cantidad;

    }

    private String[] getCodigo() {
        String[] codigo = new String[modelArticulos.getRowCount()];

        for (int i = 0; i < modelArticulos.getRowCount(); i++) {

            codigo[i] = (String) modelArticulos.getValueAt(i, 1);
        }
        return codigo;

    }

    private String[] getNombre() {
        String[] nombre = new String[modelArticulos.getRowCount()];

        for (int i = 0; i < modelArticulos.getRowCount(); i++) {

            nombre[i] = (String) modelArticulos.getValueAt(i, 2);
        }
        return nombre;

    }

    private String[] getPrecioT() {
        String[] precio = new String[modelArticulos.getRowCount()];

        for (int i = 0; i < modelArticulos.getRowCount(); i++) {

            precio[i] = modelArticulos.getValueAt(i, 4).toString();
        }
        return precio;

    }

    private void setInfoTicket(String[] infoVenta) {
        ticketVenta.setFolio(infoVenta[0]);
        ticketVenta.setCliente(infoVenta[1]);
        ticketVenta.setArticulos(setAcumulacionT());
        ticketVenta.setSubTotal(infoVenta[2]);
        ticketVenta.setTotal(infoVenta[3]);
        ticketVenta.setRecibo(infoVenta[4]);
        ticketVenta.setCambio(infoVenta[5]);
        ticketVenta.setTotalLetra(numeroLetras.Convertir(infoVenta[3], true));
        ticketVenta.setVendedor(Utilidades.getUsuarioActivo());
        ticketVenta.setFecha(Utilidades.FechaActual());

        try {
            ticketVenta.print(false);
        } catch (IOException e) {
            System.out.println("Error al generar venta: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al generar venta,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CopiaTicket(String[] infoVenta) {
        int seleccion = JOptionPane.showOptionDialog(null, "¿Desea duplicado del ticket?",
                "El articulo no existe",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"SI", "NO"},
                "SI");
        if (seleccion == JOptionPane.YES_OPTION) {
            ticketVenta.setFolio(infoVenta[0]);
            ticketVenta.setCliente(infoVenta[1]);
            ticketVenta.setArticulos(setAcumulacionT());
            ticketVenta.setSubTotal(infoVenta[2]);
            ticketVenta.setTotal(infoVenta[3]);
            ticketVenta.setRecibo(infoVenta[4]);
            ticketVenta.setCambio(infoVenta[5]);
            ticketVenta.setTotalLetra(numeroLetras.Convertir(infoVenta[3], true));
            ticketVenta.setVendedor(Utilidades.getUsuarioActivo());
            ticketVenta.setFecha(Utilidades.FechaActual());

            try {
                ticketVenta.print(false);
            } catch (IOException e) {
                System.out.println("Error al generar duplicado: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al generar duplicado,\n"
                        + "Revisa tu conexión a internet o llama al administrador,\n"
                        + "Error: " + e.getMessage(),
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

            txtV_Total.setText("0.0");
            txtV_PagaCon.setText("0.0");
            txtV_Cambio.setText("");
            modelArticulos.setRowCount(0);
        } else {

            txtV_Total.setText("0.0");
            txtV_PagaCon.setText("0.0");
            txtV_Cambio.setText("");
            modelArticulos.setRowCount(0);
        }
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
            java.util.logging.Logger.getLogger(Capturista.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbV_TipoVenta;
    private javax.swing.JComboBox<String> cmbV_VentaRegistrada;
    private javax.swing.JComboBox<String> cmb_AAnnio;
    private javax.swing.JComboBox<String> cmb_ADia;
    private javax.swing.JComboBox<String> cmb_AMes;
    private javax.swing.JComboBox<String> cmb_DeAnnio;
    private javax.swing.JComboBox<String> cmb_DeDia;
    private javax.swing.JComboBox<String> cmb_DeMes;
    private javax.swing.JButton jButton_Altas;
    private javax.swing.JButton jButton_BuscarCliente;
    private javax.swing.JButton jButton_BuscarEquipo;
    private javax.swing.JButton jButton_CerrarVenta;
    private javax.swing.JButton jButton_Comun;
    private javax.swing.JButton jButton_CorteCustom;
    private javax.swing.JButton jButton_CorteDiario;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JButton jButton_Mostrar;
    private javax.swing.JButton jButton_RegistrarEquipo;
    private javax.swing.JButton jButton_Salida;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelV_Folio;
    private javax.swing.JLabel jLabelV_Marca;
    private javax.swing.JLabel jLabelV_Modelo;
    private javax.swing.JLabel jLabelV_NombreCliente;
    private javax.swing.JLabel jLabelV_NumeroSerie;
    private javax.swing.JLabel jLabel_A;
    private javax.swing.JLabel jLabel_Cambio;
    private javax.swing.JLabel jLabel_Corte;
    private javax.swing.JLabel jLabel_De;
    private javax.swing.JLabel jLabel_FondoCortes;
    private javax.swing.JLabel jLabel_FondoGenerarVenta;
    private javax.swing.JLabel jLabel_FondoGestionarClientes;
    private javax.swing.JLabel jLabel_FondoInventario;
    private javax.swing.JLabel jLabel_FondoRegistrarEquipo;
    private javax.swing.JLabel jLabel_FondoVistaCapturista;
    private javax.swing.JLabel jLabel_FondoVistaVentas;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_NombreUsurario;
    private javax.swing.JLabel jLabel_PagaCon;
    private javax.swing.JLabel jLabel_Titulo2;
    private javax.swing.JLabel jLabel_Titulo3;
    private javax.swing.JLabel jLabel_Total;
    private javax.swing.JLabel jLabel_VentaRegistrada;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem_Acercade;
    private javax.swing.JMenuItem jMenuItem_CerrarSesion;
    private javax.swing.JMenuItem jMenuItem_InfoVersion;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_Opciones;
    private javax.swing.JPanel jPanel_Cortes;
    private javax.swing.JPanel jPanel_GenerarVenta;
    private javax.swing.JPanel jPanel_GestionarClientes;
    private javax.swing.JPanel jPanel_Inventario;
    private javax.swing.JPanel jPanel_RegistrarEquipo;
    private javax.swing.JPanel jPanel_VistaCapturista;
    private javax.swing.JPanel jPanel_VistaVentas;
    private javax.swing.JScrollPane jScrollPane_Observaciones;
    private javax.swing.JTabbedPane jTabbedPane_General;
    private javax.swing.JTabbedPane jTabbedPane_VistaCapturista;
    private javax.swing.JTabbedPane jTabbedPane_VistaVentas;
    private javax.swing.JScrollPane scrollArticulos;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JScrollPane scrollServicios;
    private javax.swing.JScrollPane scrollVentas;
    private javax.swing.JTable tablaArticulos;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtV_Cambio;
    private javax.swing.JTextField txtV_Folio;
    private javax.swing.JTextField txtV_Marca;
    private javax.swing.JTextField txtV_Modelo;
    private javax.swing.JTextField txtV_NombreCliente;
    private javax.swing.JTextField txtV_NumeroSerie;
    private javax.swing.JTextField txtV_PagaCon;
    private javax.swing.JTextField txtV_Total;
    private javax.swing.JTextField txtV_addProducto;
    private javax.swing.JTextField txt_BuscarCliente;
    private javax.swing.JTextField txt_BuscarProducto;
    private javax.swing.JTextField txt_BuscarServicio;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_NumeroSerie;
    private javax.swing.JTextPane txt_Observaciones;
    private javax.swing.JTextField txt_TelefonoCliente;
    private javax.swing.JTextField txt_TipoEquipo;
    // End of variables declaration//GEN-END:variables

    /*Declaración de objetos y variables de clase*/
    private Tablas buildTabla = new Tablas();
    private NumeroLetras numeroLetras = new NumeroLetras();
    private Teclado eventoTeclado = new Teclado();
    private TicketRecepcion orden;
    private TicketVenta ticketVenta;

    public static DefaultTableModel modelUsuarios;
    public static DefaultTableModel modelClientes;
    public static DefaultTableModel modelEquipos;
    public static DefaultTableModel modelArticulos;
    public static DefaultTableModel modelProductos;
    public static DefaultTableModel modelServicios;
    public static DefaultTableModel modelVentas;
}
