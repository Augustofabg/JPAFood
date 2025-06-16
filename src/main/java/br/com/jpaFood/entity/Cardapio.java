package br.com.jpaFood.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cardapio")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private  String description;
    private boolean avaliable;
    private BigDecimal price;

    @ManyToOne
    private Categoria categoria;

    @Column(name = "Registration_Date")
    private LocalDateTime registrationDate = LocalDateTime.now();

    public Cardapio() {
    }

    public Cardapio(String name, String description, boolean avaliable, BigDecimal price, Categoria categoria) {
        this.name = name;
        this.description = description;
        this.avaliable = avaliable;
        this.price = price;
        this.categoria = categoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cardapio: [" +
                "id:" + id +
                ", name: " + name + '\'' +
                ", description: " + description + '\'' +
                ", avaliable: " + avaliable +
                ", price: " + price +
                ", Categoria: " + categoria +
                ", registrationDate: " + registrationDate +
                " ]";
    }
}
