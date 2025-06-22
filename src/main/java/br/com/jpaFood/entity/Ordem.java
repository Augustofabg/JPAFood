package br.com.jpaFood.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column (name = "total_price")
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Column (name = "creation_date")
    private final LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(mappedBy = "ordem",cascade = CascadeType.ALL)
    private List<OrdensCardapio> ordensCardapioList = new ArrayList<>();

    public Ordem(){
    }

    public void addOrdensCardapio(OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapioList.add(ordensCardapio);
        this.totalPrice = totalPrice.add(ordensCardapio.getPrice().multiply(new BigDecimal(ordensCardapio.getAmount())));

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

    public Integer getId() {
        return Id;
    }

    public List<OrdensCardapio> getOrdensCardapioList() {
        return ordensCardapioList;
    }

    public void setOrdensCardapioList(List<OrdensCardapio> ordensCardapioList) {
        this.ordensCardapioList = ordensCardapioList;

    }

    @Override
    public String toString() {
        return "Ordem{" +
                "Id=" + Id +
                ", totalPrice=" + totalPrice +
                ", creationDate=" + creationDate +
                ", cliente=" + cliente +
                ", ordensCardapioList=" + ordensCardapioList +
                '}';
    }
}
