package br.com.jpaFood.util;

import br.com.jpaFood.dao.CardapioDao;
import br.com.jpaFood.dao.CategoriaDao;
import br.com.jpaFood.entity.Cardapio;
import br.com.jpaFood.entity.Categoria;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CargaDeDados {
    public static void CadastrarCategoria(EntityManager entityManager) {
        Categoria PratoPrincipal = new Categoria("Prato Principal");
        Categoria Sobremesa = new Categoria("Sobremesa");
        Categoria Entrada = new Categoria("Entrada");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(PratoPrincipal);
        entityManager.flush();
        categoriaDao.cadastrar(Sobremesa);
        entityManager.flush();
        categoriaDao.cadastrar(Entrada);
        entityManager.flush();
        entityManager.clear();
    }

    public static void CadastrarCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();
        Cardapio Risoto = new Cardapio("Risoto", "Risoto de carne e verduras", true, BigDecimal.valueOf(90.80), categorias.get(1));
        Cardapio Hamburguer = new Cardapio("Hamburguer", "Hamburguer de Bacon com cheedar", false, BigDecimal.valueOf(20.80), categorias.get(2));
        Cardapio Sopa = new Cardapio("Sopa", "Sopa de tomate", true, BigDecimal.valueOf(80.70), categorias.get(2));

        cardapioDao.cadastrar(Risoto);
        cardapioDao.cadastrar(Hamburguer);
        cardapioDao.cadastrar(Sopa);
        entityManager.flush();
        entityManager.clear();
    }
}
