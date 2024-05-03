package pe.edu.upc.vwalletweb.dtos;

public class TotalGastoxUsuarioDTO {
    private int usuarioId;
    private float totalGasto;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public float getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(float totalGasto) {
        this.totalGasto = totalGasto;
    }
}
