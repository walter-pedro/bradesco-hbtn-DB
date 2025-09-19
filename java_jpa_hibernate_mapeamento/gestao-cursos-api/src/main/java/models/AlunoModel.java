package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Aluno;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno = new Aluno();
        try {
            aluno = em.find(Aluno.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            System.err.println("Erro ao buscar aluno!!!" + e.getMessage());
        } finally {
            em.close();
        }
        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        List<Aluno> alunos = new ArrayList<>();
        try {
            alunos = em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
            System.err.println("Erro ao buscar a lista de alunos!!!" + e.getMessage());
        } finally {
            em.close();
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.find(Aluno.class, aluno.getId());
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Aluno alunoExcluir = em.find(Aluno.class, aluno.getId());
            em.remove(alunoExcluir);
            em.getTransaction().commit();
            System.out.println("Aluno excluido com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao exclur um aluno !!!" + e.getMessage());
        } finally {
            em.close();
        }
    }
}
