package br.com.jpaFood.service.test;

import br.com.jpaFood.dao.OrdemDao;
import br.com.jpaFood.entity.Ordem;
import br.com.jpaFood.util.CargaDeDadosUtil;
import br.com.jpaFood.util.JPAutil;
import jakarta.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAutil.getEntityManagerJPAFOOD();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.CadastrarCategoria(entityManager);
        CargaDeDadosUtil.CadastrarCardapio(entityManager);
        CargaDeDadosUtil.CadastrarEndereco(entityManager);
        CargaDeDadosUtil.CadastrarClientes(entityManager);
        CargaDeDadosUtil.CadastrarOrdens(entityManager);

        OrdemDao ordemDao = new OrdemDao(entityManager);

        Ordem ordem = ordemDao.joinFetchClient(2);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(ordem.getCliente().getName());

    }
}
