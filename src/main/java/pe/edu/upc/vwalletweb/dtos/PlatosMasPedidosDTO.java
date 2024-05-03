package pe.edu.upc.vwalletweb.dtos;

public class PlatosMasPedidosDTO {
    private String plato_mas_pedido;
    private int cantidad;

    public String getPlato_mas_pedido() {
        return plato_mas_pedido;
    }

    public void setPlato_mas_pedido(String plato_mas_pedido) {
        this.plato_mas_pedido = plato_mas_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
