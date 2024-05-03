package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "typeUsers", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "typeTypeUser"})})
public class TypeUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTyperUser;

    private String typeTypeUser;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public TypeUser() {
    }

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
