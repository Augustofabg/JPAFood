package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Cardapio;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {
    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade Cadastrada " + cardapio.toString());
    }

    public void excluir(Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }

    public void atualizar(Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public Cardapio consultarporID(final Integer id){
      return this.entityManager.find(Cardapio.class,id);
    }

    public List<Cardapio> consultartTodos(){
        try {
            String SQL = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(SQL,Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    public List<Cardapio> consultarValor(final BigDecimal filtro){
        try {
            String SQL = "SELECT c FROM Cardapio c WHERE c.price = :price";
            return this.entityManager.createQuery(SQL,Cardapio.class).setParameter("price", filtro).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Cardapio consultarNome(final String Filtro){
        try {
            String SQl = "SELECT c FROM Cardapio c WHERE UPPER(c.name) = UPPER(:name)";
            return this.entityManager.createQuery(SQl,Cardapio.class).setParameter("name", Filtro).getSingleResult();
        } catch (Exception e) {
            return null;
        }


    }


}
