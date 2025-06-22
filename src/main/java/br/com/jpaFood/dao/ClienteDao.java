package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        this.entityManager.persist(cliente);
        System.out.println("Entidade Cadastrada " + cliente.toString());
    }

    public void excluir(Cliente cliente){
        this.entityManager.remove(cliente);
    }

    public void atualizar(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public Cliente consultarCpf(final String cpf){
        return this.entityManager.find(Cliente.class,cpf);
    }

    public List<Cliente> consularPorNome(final String Filtro){
        try {
            String SQL = "SELECT c FROM Cliente c WHERE UPPER(c.name) = UPPER(:name)";
            return this.entityManager.createQuery(SQL,Cliente.class).setParameter("name", Filtro).getResultList();
        } catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Cliente> consultarTodos(){
        try {
            String SQL = "SELECT c FROM Cliente";
            return this.entityManager.createQuery(SQL,Cliente.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

}
