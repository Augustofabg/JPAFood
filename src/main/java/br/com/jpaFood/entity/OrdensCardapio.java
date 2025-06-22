package br.com.jpaFood.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "ordens_cardapio")
public class OrdensCardapio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ordem ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cardapio cardapio;

    private BigDecimal price;
    private Integer amount;

    public OrdensCardapio() {
    }

    public OrdensCardapio(Ordem ordem, Cardapio cardapio, Integer amount) {
        this.ordem = ordem;
        this.cardapio = cardapio;
        this.amount = amount;
        this.price = cardapio.getPrice();
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) { this.amount = amount; }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return   " [ " +
                  "id:" + id +
                ", cardapio: " + cardapio +
                ", price: " + price +
                ", amount: " + amount +
                " ]";
    }
}
