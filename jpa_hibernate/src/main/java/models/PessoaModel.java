package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Pessoa;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
    
        try {
         System.out.println("Iniciando a transação");
         em.getTransaction().begin();
         em.persist(p);
         em.getTransaction().commit();
         System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
         em.close();
         System.err.println("Erro ao criar pessoa !!!" + e.getMessage());
        } finally {
         em.close();
         System.out.println("Finalizando a transação");
        }
    }
    
        public Pessoa update(Pessoa p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
        
            Pessoa pessoa = new Pessoa();
            try {
                em.getTransaction().begin();
                pessoa = p;
                pessoa = em.merge(pessoa);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao atualizar pessoa !!!" + e.getMessage());
            } finally {
                em.close();
            }    
            return pessoa;
        }
    
        public void delete(Pessoa p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();
        
            try {
                em.getTransaction().begin();
                Pessoa pessoa = em.find(Pessoa.class, p.getId());
                em.remove(pessoa);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao excluir pessoa !!!" + e.getMessage());
            } finally {
                em.close();
            }    
        }
    
        public Pessoa findById(Pessoa p) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();

            Pessoa pessoa = new Pessoa();
        
            try {
                pessoa = em.find(Pessoa.class, p.getId());
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao atualizar pessoa !!!" + e.getMessage());
            } finally {
                em.close();
            }

            return pessoa;
        }
    
    public List<Pessoa> findAll() {
    
            List<Pessoa> pessoa = new ArrayList<Pessoa>();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
            EntityManager em = emf.createEntityManager();

            try {
                pessoa = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList();
            } catch (Exception e) {
                em.close();
                System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
            } finally {
                em.close();
            }

            return pessoa;
    }

}
