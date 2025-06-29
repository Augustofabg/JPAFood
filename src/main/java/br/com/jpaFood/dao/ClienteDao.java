package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Cliente;
import br.com.jpaFood.entity.ClienteId;
import br.com.jpaFood.entity.Endereco;
import br.com.jpaFood.vo.ClienteVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public Cliente consultarId(String email, String cpf) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
        Root<Cliente> root = query.from(Cliente.class);

        Predicate predicate = builder.conjunction(); // sempre true

        if (email != null) {
            predicate = builder.and(predicate,
                    builder.equal(builder.upper(root.get("email")), email.toUpperCase()));
        }

        if (cpf != null) {
            predicate = builder.and(predicate,
                    builder.equal(root.get("id").get("cpf"), cpf));
        }

        query.select(root).where(predicate);

        List<Cliente> resultados = entityManager.createQuery(query).getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }


    public List<Cliente> consultarNome(final String name){
        try {
            String SQL = "SELECT c FROM Cliente c WHERE UPPER(c.name) LIKE UPPER(:name)";
            return this.entityManager.createQuery(SQL,Cliente.class).setParameter("name", "%"+ name +"%").getResultList();
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
