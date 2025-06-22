package br.com.jpaFood.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;

    private String name;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public void addEndereco(Endereco endereco){
        endereco.setCliente(this);
        this.endereco.add(endereco);
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

    @Override
    public String
    toString() {
        return ", Cliente: [ " +
                "cpf: " + cpf +
                ", name: " + name +
                ", Endereço: " + endereco +
                " ] ";
    }
}
