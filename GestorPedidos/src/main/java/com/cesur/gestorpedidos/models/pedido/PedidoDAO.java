package com.cesur.gestorpedidos.models.pedido;

import java.util.ArrayList;

/**
 * Interfaz para definir el DAO de pedido
 */
public interface PedidoDAO {
    public ArrayList<Pedido> loadAllByUser();
}
