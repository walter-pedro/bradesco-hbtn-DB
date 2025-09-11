package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Produto;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
    
        try {
         System.out.println("Iniciando a transação");
         em.getTransaction().begin();
         em.persist(p);
         em.getTransaction().commit();
         System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
         em.close();
         System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
         em.close();
         System.out.println("Finalizando a transação");
        }
    }
    
        public Produto update(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
            Produto produto = new Produto();
            try {
                em.getTransaction().begin();
                produto = p;
                em.merge(produto);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
            } finally {
                em.close();
            }    
            
            return produto;
        }
    
        public void delete(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
        
            try {
                em.getTransaction().begin();
                Produto produto = em.find(Produto.class, p.getId());
                em.remove(produto);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao remover o produto !!!" + e.getMessage());
            } finally {
                em.close();
            }    
        }
    
        public Produto findById(Produto p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();

            Produto produto = new Produto();
        
            try {
                produto = em.find(Produto.class, p.getId());
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
            } finally {
                em.close();
            }

            return produto;
        }
    
    public List<Produto> findAll() {
    
            List<Produto> produtos = new ArrayList<Produto>();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();

            try {
                produtos = em.createQuery("SELECT p FROM Produto p", Produto.class)
                .getResultList();
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
            } finally {
                em.close();
            }

            return produtos;
    }
}
