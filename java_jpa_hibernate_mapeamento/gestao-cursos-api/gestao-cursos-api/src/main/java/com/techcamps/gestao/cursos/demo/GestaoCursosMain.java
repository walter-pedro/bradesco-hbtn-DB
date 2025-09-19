package com.techcamps.gestao.cursos.demo;

import com.techcamps.gestao.cursos.entities.Aluno;
import com.techcamps.gestao.cursos.entities.Curso;
import com.techcamps.gestao.cursos.entities.Endereco;
import com.techcamps.gestao.cursos.entities.MaterialCurso;
import com.techcamps.gestao.cursos.entities.Professor;
import com.techcamps.gestao.cursos.entities.Telefone;
import com.techcamps.gestao.cursos.models.AlunoModel;
import com.techcamps.gestao.cursos.models.CursoModel;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class GestaoCursosMain {

    public static void main(String[] args) {

        Professor professor = new Professor();
        professor.setNomeCompleto("Professor 1");
        professor.setMatricula("00001");
        professor.setEmail("professor@escola.com");

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("http://material.escola.com/curso/1");

        Curso curso = new Curso();
        curso.setNome("Curso 1");
        curso.setSigla("C1");
        curso.setProfessor(professor);
        professor.setCursos(List.of(curso));
        curso.setMaterialCurso(materialCurso);
        materialCurso.setCurso(curso);

        Telefone telefone1 = new Telefone();
        telefone1.setDdd("11");
        telefone1.setNumero("12345678");
        Telefone telefone2 = new Telefone();
        telefone2.setDdd("11");
        telefone2.setNumero("87654321");
        Endereco endereco1 = new Endereco();
        endereco1.setLogradouro("Rua");
        endereco1.setEndereco("A");
        endereco1.setNumero("1");
        endereco1.setBairro("Bairro 1");
        endereco1.setCidade("Cidade 1");
        endereco1.setEstado("Estado 1");
        endereco1.setCep(12345678);

        Aluno aluno1 = new Aluno();
        aluno1.setNomeCompleto("Aluno 1");
        aluno1.setMatricula("00001");
        aluno1.setNascimento(new Date());
        aluno1.setEmail("aluno1@escola.com");
        aluno1.setEnderecos(Set.of(endereco1));
        aluno1.setTelefones(Set.of(telefone1, telefone2));
        aluno1.setCurso(curso);

        Telefone telefone3 = new Telefone();
        telefone3.setDdd("11");
        telefone3.setNumero("43215678");
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua");
        endereco2.setEndereco("B");
        endereco2.setNumero("2");
        endereco2.setBairro("Bairro 2");
        endereco2.setCidade("Cidade 2");
        endereco2.setEstado("Estado 2");
        endereco2.setCep(87654321);
        Endereco endereco3 = new Endereco();
        endereco3.setLogradouro("Rua");
        endereco3.setEndereco("C");
        endereco3.setNumero("3");
        endereco3.setBairro("Bairro 3");
        endereco3.setCidade("Cidade 3");
        endereco3.setEstado("Estado 3");
        endereco3.setCep(43215678);

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("Aluno 2");
        aluno2.setMatricula("00002");
        aluno2.setNascimento(new Date());
        aluno2.setEmail("aluno2@escola.com");
        aluno2.setEnderecos(Set.of(endereco2, endereco3));
        aluno2.setTelefones(Set.of(telefone3));
        aluno2.setCurso(curso);

        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();

        cursoModel.create(curso);

        Curso cursoBanco = cursoModel.findAll().get(0);
        System.out.println(cursoBanco);

        cursoBanco.setNome("Curso 001");
        cursoModel.update(cursoBanco);

        cursoBanco = cursoModel.findById(cursoBanco.getId());
        System.out.println(cursoBanco);

        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        List<Aluno> alunosBanco = alunoModel.findAll();
        alunosBanco.stream().forEach(System.out::println);

        Aluno alunoBanco = alunoModel.findById(alunosBanco.get(0).getId());
        System.out.println(alunoBanco);

        alunoBanco.setEnderecos(Set.of(endereco2));
        alunoModel.update(alunoBanco);

        alunoBanco = alunoModel.findById(alunoBanco.getId());
        System.out.println(alunoBanco);

        alunoModel.delete(alunoBanco);

        alunosBanco = alunoModel.findAll();
        alunosBanco.stream().forEach(System.out::println);

    }
}
