package pe.edu.upc.vwalletweb.dtos;

public class totalViajesRealizadosPorTransporteidDTO {
    private int idTransporte;
    private String universidadSalida;
    private String universidadLlegada;
    private int totalNumViajes;

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getUniversidadSalida() {
        return universidadSalida;
    }

    public void setUniversidadSalida(String universidadSalida) {
        this.universidadSalida = universidadSalida;
    }

    public String getUniversidadLlegada() {
        return universidadLlegada;
    }

    public void setUniversidadLlegada(String universidadLlegada) {
        this.universidadLlegada = universidadLlegada;
    }

    public int getTotalNumViajes() {
        return totalNumViajes;
    }

    public void setTotalNumViajes(int totalNumViajes) {
        this.totalNumViajes = totalNumViajes;
    }
}
