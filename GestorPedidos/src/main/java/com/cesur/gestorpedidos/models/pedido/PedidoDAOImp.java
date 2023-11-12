package com.cesur.gestorpedidos.models.pedido;

import com.cesur.gestorpedidos.Session;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementacion del DAO pedido
 */
public class PedidoDAOImp implements PedidoDAO{
    /* Log para trazar la clase */
    static final org.slf4j.Logger LOG = LoggerFactory.getLogger(PedidoDAOImp.class);

    /*Conexion a la base de datos que va a recibir de la clase Database*/
    private final Connection connection;


    //Constantes para las Querys
    private static final String QUERY_LOAD_ALL_BY_USER="SELECT * FROM PEDIDO WHERE usuario_id=?";

    /**
     * Constructor que almacena la conexion en la variable c para trabajar con ella
     * @param c Conexion que viene de la clase Database
     */
    public PedidoDAOImp(Connection c){
        this.connection=c;

    }

    /**
     * Metodo para leer todos los pedidos de un Usuario
     * @return ArrayList con los pedidos del usuario logueado
     */
    @Override
    public ArrayList<Pedido> loadAllByUser() {

        var salida = new ArrayList<Pedido>();


        try(PreparedStatement pst=connection.prepareStatement(QUERY_LOAD_ALL_BY_USER)){

            pst.setLong(1, Session.getUsuarioLogueado().getId());

            LOG.info(QUERY_LOAD_ALL_BY_USER);

            ResultSet rs = pst.executeQuery();


            while (rs.next()) {

                Pedido p=new Pedido();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setUsuario_id(Session.getUsuarioLogueado().getId());
                p.setFecha(rs.getString("fecha"));
                p.setTotal(rs.getInt("total"));

                salida.add(p);

            }

            LOG.info("Pedidos devueltos correctamente");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salida;
    }
}
