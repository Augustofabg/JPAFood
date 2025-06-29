package br.com.jpaFood.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Embeddable
@Table (name = "id_Cliente")
public class ClienteId implements Serializable {

    private String email;
    private String cpf;

    public ClienteId() {
    }

    public ClienteId(String email, String cpf) {
        this.email = email;
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return " ClienteId: [" +
                " email: " + email +
                ", cpf: " + cpf +
                " ] ";
    }
}
