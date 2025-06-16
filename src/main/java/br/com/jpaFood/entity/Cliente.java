package br.com.jpaFood.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;

    private String name;
    private String cep;

    public Cliente() {
    }

    public Cliente(String cpf, String name, String cep) {
        this.cpf = cpf;
        this.name = name;
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    @Override
    public String
    toString() {
        return "Cliente: [ " +
                "cpf: " + cpf +
                ", name: " + name +
                ", cep: " + cep +
                " ]";
    }
}
