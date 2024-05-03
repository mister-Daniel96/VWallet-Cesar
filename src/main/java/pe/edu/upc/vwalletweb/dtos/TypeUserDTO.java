package pe.edu.upc.vwalletweb.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.vwalletweb.entities.Usuario;

public class TypeUserDTO {

    private Long idTyperUser;

    private String typeTypeUser;

    private Usuario usuario;

    public Long getIdTyperUser() {
        return idTyperUser;
    }

    public void setIdTyperUser(Long idTyperUser) {
        this.idTyperUser = idTyperUser;
    }

    public String getTypeTypeUser() {
        return typeTypeUser;
    }

    public void setTypeTypeUser(String typeTypeUser) {
        this.typeTypeUser = typeTypeUser;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
