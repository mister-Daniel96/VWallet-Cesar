package pe.edu.upc.vwalletweb.dtos;

public class TotalRecargadoUsuarioDTO {
    private int idUsuario;
    private float total_recargado;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getTotal_recargado() {
        return total_recargado;
    }

    public void setTotal_recargado(float total_recargado) {
        this.total_recargado = total_recargado;
    }
}
