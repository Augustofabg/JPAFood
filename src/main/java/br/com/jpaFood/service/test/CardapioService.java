package br.com.jpaFood.service.test;

import br.com.jpaFood.dao.CardapioDao;
import br.com.jpaFood.util.CargaDeDados;
import br.com.jpaFood.util.JPAutil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Scanner;


public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAutil.getEntityManagerJPAFOOD();
        entityManager.getTransaction().begin();
        CargaDeDados.CadastrarCategoria(entityManager);
        CargaDeDados.CadastrarCardapio(entityManager);
        CardapioDao CardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de Valores" + CardapioDao.consultarValor(BigDecimal.valueOf(80.70)));
        System.out.println("Lista de Valores" + CardapioDao.consultarNome("risoto"));
        entityManager.close();
    }
}
