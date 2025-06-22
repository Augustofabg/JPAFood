package br.com.jpaFood.util;

import br.com.jpaFood.dao.*;
import br.com.jpaFood.entity.*;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {
    public static void CadastrarCategoria(EntityManager entityManager) {
        Categoria pratoPrincipal = new Categoria("Prato Principal"); //0
        Categoria sobremesa = new Categoria("Sobremesa"); //1
        Categoria entrada = new Categoria("Entrada"); //2
        Categoria bebida = new Categoria("Bebida"); //3
        Categoria vegetariano = new Categoria("Vegetariano"); //4
        Categoria internacional = new Categoria("Internacional"); //5

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.flush();

        categoriaDao.cadastrar(sobremesa);
        entityManager.flush();

        categoriaDao.cadastrar(entrada);
        entityManager.flush();

        categoriaDao.cadastrar(bebida);
        entityManager.flush();

        categoriaDao.cadastrar(vegetariano);
        entityManager.flush();

        categoriaDao.cadastrar(internacional);
        entityManager.flush();

        entityManager.clear();

    }

    public static void CadastrarCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio prato1 = new Cardapio("Feijoada", "Feijoada completa com carnes e acompanhamentos", true, BigDecimal.valueOf(75.50), categorias.get(2));
        Cardapio prato2 = new Cardapio("Lasanha", "Lasanha de quatro queijos gratinada", true, BigDecimal.valueOf(68.90), categorias.get(0));
        Cardapio prato3 = new Cardapio("Moqueca", "Moqueca de peixe com arroz e pirão", true, BigDecimal.valueOf(82.00), categorias.get(0));
        Cardapio prato4 = new Cardapio("Strogonoff", "Strogonoff de frango com arroz e batata palha", true, BigDecimal.valueOf(59.99), categorias.get(2));
        Cardapio prato5 = new Cardapio("Pizza Margherita", "Pizza artesanal com molho de tomate e manjericão", true, BigDecimal.valueOf(49.00), categorias.get(5));
        Cardapio prato6 = new Cardapio("Sushi", "Combo com 20 peças variadas de sushi e sashimi", true, BigDecimal.valueOf(95.20), categorias.get(5));
        Cardapio prato7 = new Cardapio("Hambúrguer Artesanal", "Hambúrguer com cheddar, bacon e batata frita", true, BigDecimal.valueOf(42.75), categorias.get(2));
        Cardapio prato8 = new Cardapio("Salada Caesar", "Salada Caesar com frango grelhado", true, BigDecimal.valueOf(38.50), categorias.get(3));
        Cardapio prato9 = new Cardapio("Tacos Mexicanos", "Tacos recheados com carne, queijo e guacamole", true, BigDecimal.valueOf(54.90), categorias.get(5));
        Cardapio prato10 = new Cardapio("Espaguete à Bolonhesa", "Macarrão ao molho bolonhesa tradicional", true, BigDecimal.valueOf(61.30), categorias.get(0));


        cardapioDao.cadastrar(prato1);
        entityManager.flush();
        cardapioDao.cadastrar(prato2);
        entityManager.flush();
        cardapioDao.cadastrar(prato3);
        entityManager.flush();
        cardapioDao.cadastrar(prato4);
        entityManager.flush();
        cardapioDao.cadastrar(prato5);
        entityManager.flush();
        cardapioDao.cadastrar(prato6);
        entityManager.flush();
        cardapioDao.cadastrar(prato7);
        entityManager.flush();
        cardapioDao.cadastrar(prato8);
        entityManager.flush();
        cardapioDao.cadastrar(prato9);
        entityManager.flush();
        cardapioDao.cadastrar(prato10);
        entityManager.flush();
        entityManager.clear();
    }

    public static void CadastrarEndereco(EntityManager entityManager) {
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        Endereco endereco1 = new Endereco("01001-000", "Sé", "Apartamento", "São Paulo", "São Paulo");
        Endereco endereco2 = new Endereco("04094-050", "Moema", "Apartamento", "São Paulo", "São Paulo");
        Endereco endereco3 = new Endereco("04534-011", "Itaim Bibi", "Apartamento", "São Paulo", "São Paulo");
        Endereco endereco4 = new Endereco("05001-100", "Perdizes", "Casa", "São Paulo", "São Paulo");
        Endereco endereco5 = new Endereco("06020-000", "Centro", "Casa", "Osasco", "São Paulo");
        Endereco endereco6 = new Endereco("07020-000", "Centro", "Apartamento", "Guarulhos", "São Paulo");
        Endereco endereco7 = new Endereco("13010-001", "Centro", "Apartamento", "Campinas", "São Paulo");
        Endereco endereco8 = new Endereco("09510-001", "Centro", "Casa", "São Caetano do Sul", "São Paulo");
        Endereco endereco9 = new Endereco("09710-000", "Centro", "Apartamento", "São Bernardo do Campo", "São Paulo");
        Endereco endereco10 = new Endereco("09810-000", "Assunção", "Casa", "São Bernardo do Campo", "São Paulo");

        enderecoDao.cadastrar(endereco1);
        enderecoDao.cadastrar(endereco2);
        enderecoDao.cadastrar(endereco3);
        enderecoDao.cadastrar(endereco4);
        enderecoDao.cadastrar(endereco5);
        enderecoDao.cadastrar(endereco6);
        enderecoDao.cadastrar(endereco7);
        enderecoDao.cadastrar(endereco8);
        enderecoDao.cadastrar(endereco9);
        enderecoDao.cadastrar(endereco10);
        entityManager.flush();
        entityManager.clear();
    }


    public static void CadastrarClientes(EntityManager entityManager) {
        ClienteDao clienteDao = new ClienteDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        Cliente cliente1 = new Cliente("123456789", "Mariana Silva");
        Cliente cliente2 = new Cliente("987654321", "Carlos Oliveira");
        Cliente cliente3 = new Cliente("456789123", "Fernanda Costa");
        Cliente cliente4 = new Cliente("789123456", "Lucas Pereira");
        Cliente cliente5 = new Cliente("321654987", "Juliana Souza");
        Cliente cliente6 = new Cliente("654987321", "Marcelo Dias");
        Cliente cliente7 = new Cliente("159753486", "Patrícia Rocha");
        Cliente cliente8 = new Cliente("753159842", "André Lima");
        Cliente cliente9 = new Cliente("852963741", "Beatriz Mendes");
        Cliente cliente10 = new Cliente("741852963", "Renato Martins");
        cliente1.addEndereco(enderecoDao.consultarId(1));
        cliente2.addEndereco(enderecoDao.consultarId(2));
        cliente3.addEndereco(enderecoDao.consultarId(3));
        cliente4.addEndereco(enderecoDao.consultarId(4));
        cliente5.addEndereco(enderecoDao.consultarId(5));
        cliente6.addEndereco(enderecoDao.consultarId(6));
        cliente7.addEndereco(enderecoDao.consultarId(7));
        cliente8.addEndereco(enderecoDao.consultarId(8));
        cliente9.addEndereco(enderecoDao.consultarId(9));
        cliente10.addEndereco(enderecoDao.consultarId(10));

        clienteDao.cadastrar(cliente1);
        clienteDao.cadastrar(cliente2);
        clienteDao.cadastrar(cliente3);
        clienteDao.cadastrar(cliente4);
        clienteDao.cadastrar(cliente5);
        clienteDao.cadastrar(cliente6);
        clienteDao.cadastrar(cliente7);
        clienteDao.cadastrar(cliente8);
        clienteDao.cadastrar(cliente9);
        clienteDao.cadastrar(cliente10);
        entityManager.flush();
        entityManager.clear();
    }

    public static void CadastrarOrdens(EntityManager entityManager) {
        OrdemDao ordemDao = new OrdemDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        Ordem ordem1 = new Ordem(clienteDao.consultarCpf("123456789"));
        Ordem ordem2 = new Ordem(clienteDao.consultarCpf("987654321"));
        Ordem ordem3 = new Ordem(clienteDao.consultarCpf("456789123"));
        Ordem ordem4 = new Ordem(clienteDao.consultarCpf("789123456"));
        Ordem ordem5 = new Ordem(clienteDao.consultarCpf("321654987"));
        Ordem ordem6 = new Ordem(clienteDao.consultarCpf("654987321"));
        Ordem ordem7 = new Ordem(clienteDao.consultarCpf("159753486"));
        Ordem ordem8 = new Ordem(clienteDao.consultarCpf("753159842"));
        Ordem ordem9 = new Ordem(clienteDao.consultarCpf("852963741"));
        Ordem ordem10 = new Ordem(clienteDao.consultarCpf("741852963"));

        ordem1.addOrdensCardapio(new OrdensCardapio(ordem1, cardapioDao.consultarporID(3), 1));
        ordem2.addOrdensCardapio(new OrdensCardapio(ordem2, cardapioDao.consultarporID(7), 3));
        ordem3.addOrdensCardapio(new OrdensCardapio(ordem3, cardapioDao.consultarporID(1), 4));
        ordem4.addOrdensCardapio(new OrdensCardapio(ordem4, cardapioDao.consultarporID(2), 1));
        ordem5.addOrdensCardapio(new OrdensCardapio(ordem5, cardapioDao.consultarporID(3), 2));
        ordem6.addOrdensCardapio(new OrdensCardapio(ordem6, cardapioDao.consultarporID(9), 5));
        ordem7.addOrdensCardapio(new OrdensCardapio(ordem7, cardapioDao.consultarporID(1), 3));
        ordem8.addOrdensCardapio(new OrdensCardapio(ordem8, cardapioDao.consultarporID(4), 1));
        ordem9.addOrdensCardapio(new OrdensCardapio(ordem9, cardapioDao.consultarporID(4), 4));
        ordem10.addOrdensCardapio(new OrdensCardapio(ordem10, cardapioDao.consultarporID(6), 2));

        ordemDao.cadastrar(ordem1);
        ordemDao.cadastrar(ordem2);
        ordemDao.cadastrar(ordem3);
        ordemDao.cadastrar(ordem4);
        ordemDao.cadastrar(ordem5);
        ordemDao.cadastrar(ordem6);
        ordemDao.cadastrar(ordem7);
        ordemDao.cadastrar(ordem8);
        ordemDao.cadastrar(ordem9);
        ordemDao.cadastrar(ordem10);
        entityManager.flush();
        entityManager.clear();
    }

}
