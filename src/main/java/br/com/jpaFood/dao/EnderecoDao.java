package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Cliente;
import br.com.jpaFood.entity.Endereco;
import br.com.jpaFood.entity.Ordem;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class EnderecoDao {
    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Endereco endereco){
        this.entityManager.persist(endereco);
        System.out.println("Entidade Cadastrada " + endereco.toString());
    }

    public void excluir(Endereco endereco){
        this.entityManager.remove(endereco);
    }

    public void atualizar(Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public List<Endereco> consultarTodos(){
        try {
            String SQL = "SELECT c FROM Endereco";
            return this.entityManager.createQuery(SQL,Endereco.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public Endereco consultarId(final Integer id){
        return this.entityManager.find(Endereco.class,id);
    }

}
