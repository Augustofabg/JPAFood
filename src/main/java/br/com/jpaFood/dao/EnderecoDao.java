package br.com.jpaFood.dao;

import br.com.jpaFood.entity.Cliente;
import br.com.jpaFood.entity.Endereco;
import br.com.jpaFood.entity.Ordem;
import br.com.jpaFood.vo.ClienteVo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public List<ClienteVo> consultarClientesCriteria(String state, String city, String street){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteVo> criteriaQuery = builder.createQuery(ClienteVo.class);
        Root<Endereco> root = criteriaQuery.from(Endereco.class);
        criteriaQuery.select(builder.construct(ClienteVo.class,root.get("cliente").get("clienteId").get("cpf"), root.get("cliente").get("name")));
        Predicate predicate = builder.and();

        if(Objects.nonNull(state)){
           predicate = builder.and(predicate,builder.equal(builder.upper(root.get("state")), state.toUpperCase()));
        }
        if(Objects.nonNull(city)){
            predicate = builder.and(predicate,builder.equal(builder.upper(root.get("city")), city.toUpperCase()));
        }
        if(Objects.nonNull(street)){
            predicate = builder.and(predicate,builder.equal(builder.upper(root.get("street")), street.toUpperCase()));
        }

        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }


    public Endereco consultarId(final Integer id){
        return this.entityManager.find(Endereco.class,id);
    }

}
