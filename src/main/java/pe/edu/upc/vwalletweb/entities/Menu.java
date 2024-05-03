package pe.edu.upc.vwalletweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;
    @Column(name = "entrada",nullable = false,length = 100)
    private String entrada;
    @Column(name = "platoPrincipal",nullable = false,length = 100)
    private String platoPrincipal;
    @Column(name = "postre",nullable = false,length = 100)
    private String postre;
    @Column(name = "refresco",nullable = false,length = 100)
    private String refresco;
    @Column(name = "precioMenu",nullable = false)
    private float precioMenu;

    @ManyToOne
    @JoinColumn(name = "cafeteria_id")
    private Cafeteria cafeteria;

    public Menu() {
    }

    public Menu(int idMenu, String entrada, String platoPrincipal, String postre, String refresco, float precioMenu, Cafeteria cafeteria) {
        this.idMenu = idMenu;
        this.entrada = entrada;
        this.platoPrincipal = platoPrincipal;
        this.postre = postre;
        this.refresco = refresco;
        this.precioMenu = precioMenu;
        this.cafeteria = cafeteria;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getPlatoPrincipal() {
        return platoPrincipal;
    }

    public void setPlatoPrincipal(String platoPrincipal) {
        this.platoPrincipal = platoPrincipal;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getRefresco() {
        return refresco;
    }

    public void setRefresco(String refresco) {
        this.refresco = refresco;
    }

    public float getPrecioMenu() {
        return precioMenu;
    }

    public void setPrecioMenu(float precioMenu) {
        this.precioMenu = precioMenu;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }
}
