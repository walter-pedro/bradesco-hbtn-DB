package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Curso;

public class CursoModel {

    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Curso findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        Curso curso = new Curso();
        try {
            curso = em.find(Curso.class, id);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar curso!!!" + e.getMessage());
        } finally {
            em.close();
        }
        return curso;
    }

    public List<Curso> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos = em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
        } catch (Exception e) {

            em.close();
            System.err.println("Erro ao buscar a lista de cursos!!!" + e.getMessage());
        } finally {
            em.close();
        }

        return cursos;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.find(Curso.class, curso.getId());
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar um curso !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Curso cursoExcluir = em.find(Curso.class, curso.getId());
            em.remove(curso);
            em.getTransaction().commit();
            System.out.println("Curso excluido com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao exclur um curso !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }
}
