package br.com.jpaFood.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column (name = "total_price")
    private BigDecimal totalPrice;

    @Column (name = "creation_date")
    private final LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "ordem")
    private List<OrdensCardapio> ordensCardapioList;

    public Ordem(){
    }

    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
    }

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public String toString() {
        return  "  Ordem: [ " +
                "Id:" + Id +
                ", totalPrice:" + totalPrice +
                ", creationDate:" + creationDate +
                ", cliente:" + cliente + " ]";
    }
}
