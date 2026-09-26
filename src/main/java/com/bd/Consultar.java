package com.bd;

import java.sql.*;
import com.utilidades.PasswordUtil;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Arambula
 */
public class Consultar {

    public static String[] ConsultarInfoEmpresa() {
        String empresa, propietario, rfc, direccion, telefono, condiciones;
        try {
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement("select empresa, propietario, rfc, direccion, telefono, condiciones from preferencias where nombre = 'InfoEmpresa'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                empresa = rs.getString("empresa");
                propietario = rs.getString("propietario");
                rfc = rs.getString("rfc");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                condiciones = rs.getString("condiciones");

                return new String[]{empresa, propietario, rfc, direccion, telefono, condiciones};
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar info de la empresa " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar información de la empresa,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static boolean ConsultarInicio(String fecha) {
        try {
            Connection cn = Conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement("select id_inicioturno from inicioturno where fecha = ?");
                pst.setObject(1, fecha);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el inicio de turno: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el inicio de turno,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static String[] ConsultarAcceso(String usuario, String pass) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select password, tipo_nivel, estatus from usuarios where username = ?");
                pst.setString(1, usuario);
                ResultSet rs = pst.executeQuery();
                if (rs.next() && PasswordUtil.verify(pass, rs.getString("password"))) {
                    String tipoNivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    String storedPassword = rs.getString("password");
                    if (PasswordUtil.isLegacy(storedPassword)) {
                        try (PreparedStatement upgrade = cn.prepareStatement(
                                "update usuarios set password = ? where username = ? and password = ?")) {
                            upgrade.setString(1, PasswordUtil.hash(pass));
                            upgrade.setString(2, usuario);
                            upgrade.setString(3, storedPassword);
                            upgrade.executeUpdate();
                        }
                    }
                    return new String[]{tipoNivel, estatus};
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar permisos y estatus del usuario: " + e.getMessage()); //Envia un mensaje color rojo
            JOptionPane.showMessageDialog(null, "Error al consultar permisos y estatus del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static String ConsultarNombreUsuario(String usuario) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre_usuario from usuarios where username = ?");
                pst.setObject(1, usuario);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getString("nombre_usuario");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar nombre completo del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar nombre completo del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static int ConsultarIdUsuario(String usuario) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_usuario from usuarios where username = ?");
                pst.setObject(1, usuario);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_usuario");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar nombre completo del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar nombre completo del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static boolean ConsultarUsuario(String usuario) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select username from usuarios where username = ?");
                pst.setObject(1, usuario);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar existencia del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar existencia del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static boolean ConsultarUsuario(int idUsuario, String usuario) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select username from usuarios where username = ? and not id_usuario = ?");
                pst.setObject(1, usuario);
                pst.setObject(2, idUsuario);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar existencia del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar existencia del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static String[] ConsultarInfoUsuario(int idUsuario) {
        String nombre, email, telefono, username, tipoNivel, estatus, registrado_por;
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre_usuario, email, telefono, username, tipo_nivel, estatus, registrado_por from usuarios "
                        + "where id_usuario = ?");
                pst.setObject(1, idUsuario);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    nombre = rs.getString("nombre_usuario");
                    email = rs.getString("email");
                    telefono = rs.getString("telefono");
                    username = rs.getString("username");
                    tipoNivel = rs.getString("tipo_nivel");
                    estatus = rs.getString("estatus");
                    registrado_por = rs.getString("registrado_por");

                    return new String[]{nombre, email, telefono, username, tipoNivel, estatus, registrado_por};
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la información completa del usuario " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar la información completa del usuario,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static String ConsultarNombreCliente(int idCliente) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre_cliente from clientes where id_cliente = ?");
                pst.setObject(1, idCliente);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getString("nombre_cliente");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el nombre del cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el nombre del cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static int ConsultarIdCliente(int idEquipo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_cliente from equipos where id_equipo = ?");
                pst.setObject(1, idEquipo);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_cliente");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el id del cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el id del cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static int ConsultarIdCliente(String nombreCliente) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_cliente from clientes where nombre_cliente = ?");
                pst.setObject(1, nombreCliente);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id_cliente");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el id del cliente " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el id del cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static String[] ConsultarInfoCliente(int idCliente) {
        String nombre, telefono, modificadoPor;
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select * from clientes where id_cliente = ?");
                pst.setObject(1, idCliente);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    nombre = rs.getString("nombre_cliente");
                    telefono = rs.getString("tel_cliente");
                    modificadoPor = rs.getString("ultima_modificacion");

                    return new String[]{nombre, telefono, modificadoPor};
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la información completa del cliente " + e);
            JOptionPane.showMessageDialog(null, "Error al consultar la información completa del cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static String ConsultarInfoCliente(String nombreCliente) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select * from clientes where nombre_cliente = ?");
                pst.setObject(1, nombreCliente);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    return rs.getString("tel_cliente");

                } else {

                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la información de cliente: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar la información de cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static int ConsultarUltimoCliente() {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select max(id_cliente) as id from clientes");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el nuevo id del cliente: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el nuevo id del cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static String[] ConsultarInfoEquipo(int idEquipo) {
        String tipoEquipo, marca, modelo, numSerie, fecha, hora, observaciones, estatus, comentarioTecnicos,
                revisionTecnica, ultimaModificacion;
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select * from equipos where id_equipo = ?");
                pst.setObject(1, idEquipo);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    tipoEquipo = rs.getString("tipo_equipo");
                    marca = rs.getString("marca");
                    modelo = rs.getString("modelo");
                    numSerie = rs.getString("num_serie");
                    fecha = rs.getString("dia_ingreso") + "/" + rs.getString("mes_ingreso") + "/" + rs.getString("annio_ingreso");
                    hora = rs.getString("hora_ingreso");
                    observaciones = rs.getString("observaciones");
                    estatus = rs.getString("estatus");
                    comentarioTecnicos = rs.getString("comentarios_tecnicos");
                    revisionTecnica = rs.getString("revision_tecnica_de");
                    ultimaModificacion = rs.getString("ultima_modificacion");

                    return new String[]{tipoEquipo, marca, modelo, numSerie, fecha, hora, observaciones, estatus, comentarioTecnicos,
                        revisionTecnica, ultimaModificacion};
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la información completa del cliente " + e);
            JOptionPane.showMessageDialog(null, "Error al consultar la información completa del cliente,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static String[] ConsultarInfoEquipo(int folio, int idCliente) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select marca, modelo, num_serie from equipos where id_equipo = ? and id_cliente = ?");
                pst.setObject(1, folio);
                pst.setObject(2, idCliente);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String marca = rs.getString("marca");
                    String modelo = rs.getString("modelo");
                    String numSerie = rs.getString("num_serie");

                    return new String[]{marca, modelo, numSerie};
                } else {
                    JOptionPane.showMessageDialog(null, "El equipo no pertenece al cliente");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar la informacion del equipo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al recuperar la informacion del equipo,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static int ConsultarUltimoEquipo() {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select max(id_equipo) as id from equipos");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el id del nuevo equipo registrado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el id del nuevo equipo registrado,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static int ConsultarIdArticulo(String codigo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_articulo from articulos where codigo = ?");
                pst.setObject(1, codigo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id_articulo");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la informacion del producto " + e.getMessage());
        }
        return 0;
    }

    public static String[] ConsultarInfoArticulo(String codigo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre, precio from articulos where codigo = ?");
                pst.setObject(1, codigo);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    return new String[]{rs.getString("nombre"), rs.getString("precio")};
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al caprurar datos en tabla articulos: " + e.getMessage());
        }
        return null;
    }

    public static String[] ConsultarInfoProducto(String codigo) {
        String nombre, cantidad, precio, ultimaMod;
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_articulo, nombre, cantidad, precio, ultima_modificacion from articulos where codigo = ?");
                pst.setObject(1, codigo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    nombre = rs.getString("nombre");
                    cantidad = rs.getString("cantidad");
                    precio = rs.getString("precio");
                    ultimaMod = rs.getString("ultima_modificacion");
                    return new String[]{nombre, cantidad, precio, ultimaMod};
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la informacion del producto " + e.getMessage());
        }
        return null;
    }

    public static String[] ConsultarInfoServicio(String codigo) {
        String nombre, precio, ultimaMod;
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select id_articulo, nombre, precio, ultima_modificacion from articulos where codigo = ?");
                pst.setObject(1, codigo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    nombre = rs.getString("nombre");
                    precio = rs.getString("precio");
                    ultimaMod = rs.getString("ultima_modificacion");
                    return new String[]{nombre, precio, ultimaMod};
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la informacion del producto " + e.getMessage());
        }
        return null;
    }

    public static boolean ConsultarCodigoArticulo(int idArticulo, String codigo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select codigo from articulos where codigo = ? and not id_articulo = ?");
                pst.setObject(1, codigo);
                pst.setObject(2, idArticulo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la informacion del producto " + e.getMessage());
        }
        return false;
    }

    public static String[] ConsultarInfoVenta(int idVenta) {
        String idCliente, folio, tipoVenta, total, fecha, vendedor, articulos, estatus, cancelado;
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select * from ventas where id_venta = ?");
                pst.setObject(1, idVenta);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    idCliente = String.valueOf(rs.getInt("id_cliente"));
                    folio = String.valueOf(rs.getInt("id_equipo"));
                    tipoVenta = rs.getString("tipo_venta");
                    total = String.valueOf(rs.getDouble("total"));
                    fecha = String.valueOf(rs.getDate("fecha_venta"));
                    vendedor = rs.getString("vendedor");
                    articulos = rs.getString("articulos");
                    estatus = rs.getString("estatus");
                    cancelado = rs.getString("cancelada_por");

                    return new String[]{idCliente, folio, tipoVenta, total, fecha, vendedor, articulos, estatus, cancelado};
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar la informacion de la venta " + e);
        }
        return null;
    }

    public static int ConsultarUltimaVenta(){
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select max(id_venta) as id from ventas");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el id del nuevo equipo registrado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar el id del nuevo equipo registrado,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "Error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static int ConsultarCantidad(String codigo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select cantidad from articulos where codigo = ? and tipo_articulo = 'Producto'");
                pst.setObject(1, codigo);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("cantidad");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la cantidad de articulo " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar la cantidad de articulo,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }

    public static boolean ConsultarCodigoArticulo(String codigo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select codigo from articulos where codigo = ?");
                pst.setObject(1, codigo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al validar codigo de articulo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al validar codigo de articulo,\n"
                    + "Revisa tu conexión a internet o llama al administrador,\n"
                    + "error: " + e.getMessage(),
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static double ConsultaPrecio(String codigo) {
        try {
            try ( Connection cn = Conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select precio from articulos where codigo = ?");
                pst.setObject(1, codigo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    return Double.parseDouble(rs.getString("precio"));
                }
            }
        } catch (SQLException e) {
        }
        return 0.0;
    }

}
