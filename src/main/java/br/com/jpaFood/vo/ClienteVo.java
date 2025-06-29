package br.com.jpaFood.vo;

public class ClienteVo {

    private String cpf;

    private String name;

    public ClienteVo() {
    }

    public ClienteVo(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
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
    public String toString() {
        return "Busca por local: [ " +
                "cpf: " + cpf +
                ", name: " + name +
                " ] ";
    }
}
