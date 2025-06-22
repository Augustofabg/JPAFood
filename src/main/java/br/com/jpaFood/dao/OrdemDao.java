package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Cliente;
import br.com.jpaFood.entity.Endereco;
import br.com.jpaFood.entity.Ordem;
import br.com.jpaFood.vo.ItensPrincipaisVo;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class OrdemDao {
    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Ordem ordem){
        this.entityManager.persist(ordem);
        System.out.println("Entidade Cadastrada " + ordem.toString());
    }

    public void excluir(Ordem ordem){
        this.entityManager.remove(ordem);
    }

    public void atualizar(Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public List<Ordem> consultarTodos(){
        try {
            String SQL = "SELECT c FROM Ordem";
            return this.entityManager.createQuery(SQL,Ordem.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public Ordem consultarId(final Integer id){
        return this.entityManager.find(Ordem.class,id);
    }


    public Ordem joinFetchClient(final Integer id){
            String SQL = "SELECT o FROM Ordem o JOIN FETCH  o.cliente WHERE o.id = :id";
            return this.entityManager.createQuery(SQL,Ordem.class).setParameter("id", id).getSingleResult();
    }




    public List<ItensPrincipaisVo> consultarMaisVendidos(){
            String SQL = "SELECT new br.com.jpaFood.vo.ItensPrincipaisVo (" +
            "c.name, SUM(oc.amount)) FROM Ordem o " +
            "JOIN OrdensCardapio oc on o.id = oc.cardapio.id " +
            "JOIN oc.cardapio c " + "GROUP BY c.name " + "ORDER BY SUM(oc.amount) DESC";
            return this.entityManager.createQuery(SQL,ItensPrincipaisVo.class).getResultList();
    }

}
