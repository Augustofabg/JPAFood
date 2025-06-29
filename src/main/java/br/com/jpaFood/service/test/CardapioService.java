package br.com.jpaFood.service.test;

import br.com.jpaFood.dao.CardapioDao;
import br.com.jpaFood.dao.ClienteDao;
import br.com.jpaFood.util.CargaDeDadosUtil;
import br.com.jpaFood.util.JPAutil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;


public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAutil.getEntityManagerJPAFOOD();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.CadastrarCategoria(entityManager);
        CargaDeDadosUtil.CadastrarCardapio(entityManager);
        CargaDeDadosUtil.CadastrarClientes(entityManager);
        CardapioDao CardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        entityManager.close();
    }
}
