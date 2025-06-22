package br.com.jpaFood.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cep;
    private String street;
    private String complement;
    private String city;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;


    public Endereco() {
    }

    public Endereco(String cep, String street, String complement, String city, String state) {
        this.cep = cep;
        this.street = street;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return " [ " +
                "id: " + id +
                ", cep: " + cep +
                ", street: " + street +
                ", complement: " + complement +
                ", city: " + city +
                ", state: " + state +
                " ] ";
    }
}
