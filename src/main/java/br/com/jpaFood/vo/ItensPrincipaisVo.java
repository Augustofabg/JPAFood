package br.com.jpaFood.vo;

public class ItensPrincipaisVo {

    private String name;
    private Long amount;



    public ItensPrincipaisVo() {

    }

    public ItensPrincipaisVo(String name, Long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return " Itens mais vendidos [ " +
                "name='" + name +
                ", amount=" + amount +
                " ] ";
    }
}
