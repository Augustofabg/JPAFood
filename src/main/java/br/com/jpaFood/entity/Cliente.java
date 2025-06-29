package br.com.jpaFood.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @EmbeddedId
    private ClienteId clienteId;

    private String name;

    @Embedded
    private Contato contato;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpf, String email, String name) {
        this.clienteId = new ClienteId(email, cpf);
        this.name = name;
    }

    public void addEndereco(Endereco endereco){
        endereco.setCliente(this);
        this.endereco.add(endereco);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getCpf(){
        return clienteId.getCpf();
    }


    public String getEmail(){
        return clienteId.getEmail();
    }

    public void setCpf(String cpf){
       this.clienteId.setCpf(cpf);
    }

    public void setEmail(String email){
        this.clienteId.setEmail(email);
    }

    @Override
    public String
    toString() {
        return ", Cliente: [ " +
                " cpf: " + clienteId.getCpf() +
                ", email " + clienteId.getEmail() +
                ", name: " + name +
                ", endereço: " + endereco +
                ", contato: "  + contato +
                " ] ";
    }
}
