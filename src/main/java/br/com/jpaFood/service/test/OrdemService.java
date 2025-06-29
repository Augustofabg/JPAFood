package br.com.jpaFood.service.test;

import br.com.jpaFood.dao.ClienteDao;
import br.com.jpaFood.dao.EnderecoDao;
import br.com.jpaFood.dao.OrdemDao;
import br.com.jpaFood.entity.Endereco;
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
        ClienteDao clienteDao = new ClienteDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);


        System.out.println(enderecoDao.consultarClientesCriteria("são Paulo", null, null));

         Ordem ordem = ordemDao.joinFetchClient(1);
         System.out.println(ordem.getCliente().getName());

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
