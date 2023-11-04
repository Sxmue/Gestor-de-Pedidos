package com.cesur.gestorpedidos.models.usuario;


import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Implementacion del DAO Usuario
 */
public class UsuarioDAOImp implements UsuarioDAO {

    /* Log para trazar la clase */
    static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UsuarioDAOImp.class);

    /*Conexion a la base de datos que va a recibir de la clase Database*/
    private final Connection connection;


    //Constantes para las Querys
    private static final String QUERY_LOAD = "SELECT * FROM usuario Where nombre=? and pass=?";

    /**
     * Constructor que almacena la conexion en la variable c para trabajar con ella
     *
     * @param c Conexion que viene de la clase Database
     */
    public UsuarioDAOImp(Connection c) {
        this.connection = c;

    }

    /**
     * Metodo para leer un Usuario de la base de datos
     * @param nombre nombre del usuario
     * @param pass contraseña del usuario
     * @return el usuario de la base de datos
     */
    @Override
    public Usuario load(String nombre, String pass) {

        Usuario u = new Usuario();

        try (var pst = connection.prepareStatement(QUERY_LOAD)) {

            LOG.info(QUERY_LOAD);

            pst.setString(1, nombre);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setPass(rs.getString("pass"));
                u.setEmail(rs.getString("email"));

                LOG.info("Usuario creado y devuelto correctamente");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;

    }


}
