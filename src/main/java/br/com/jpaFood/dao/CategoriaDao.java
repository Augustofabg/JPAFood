package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
        System.out.println("Entidade Cadastrada " + categoria.toString());
    }

    public void excluir(Categoria categoria){
        this.entityManager.remove(categoria);
    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public Categoria consultar(final Integer id){
        return this.entityManager.find(Categoria.class,id);
    }

    public List<Categoria> consultarTodos(){
        String JSQL = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(JSQL,Categoria.class).getResultList();
    }

}
