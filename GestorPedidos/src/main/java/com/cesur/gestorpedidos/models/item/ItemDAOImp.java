package com.cesur.gestorpedidos.models.item;

import Database.Database;
import com.cesur.gestorpedidos.models.pedido.Pedido;
import com.cesur.gestorpedidos.models.producto.ProductoDAOImp;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementacion del DAO Item
 */
public class ItemDAOImp implements ItemDAO{

    /* Log para trazar la clase */
    static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ItemDAOImp.class);

    /*Conexion a la base de datos que va a recibir de la clase Database*/
    private final Connection connection;

    ProductoDAOImp productDAOImp = new ProductoDAOImp(Database.getConnection());


    //Constantes para las Querys
    private static final String QUERY_LOAD_ALL_BY_PEDIDO="SELECT * FROM item WHERE codigoPedido=?";

    /**
     * Constructor que almacena la conexion en la variable c para trabajar con ella
     * @param c Conexion que viene de la clase Database
     */
    public ItemDAOImp(Connection c){
        this.connection=c;

    }
    @Override
    public ArrayList<Item> loadByPedido(Pedido p) {
        var result = new ArrayList<Item>();

        try(PreparedStatement pst=connection.prepareStatement(QUERY_LOAD_ALL_BY_PEDIDO)){

            pst.setString(1,p.getCodigo());

            ResultSet rs = pst.executeQuery();

            while (rs.next()){

                Item i = new Item();

                i.setIdPedido(rs.getInt("id"));
                i.setCodigoPedido(rs.getString("codigoPedido"));
                i.setCantidad(rs.getInt("cantidad"));
                i.setIdProducto(rs.getInt("idProducto"));
                i.setProducto(productDAOImp.load(rs.getInt("idProducto")));

                result.add(i);

            }
            return result;
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
