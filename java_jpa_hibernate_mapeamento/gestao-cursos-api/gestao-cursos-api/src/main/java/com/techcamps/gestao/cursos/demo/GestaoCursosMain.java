package com.techcamps.gestao.cursos.demo;

import com.techcamps.gestao.cursos.entities.Aluno;
import com.techcamps.gestao.cursos.entities.Curso;
import com.techcamps.gestao.cursos.entities.Endereco;
import com.techcamps.gestao.cursos.entities.MaterialCurso;
import com.techcamps.gestao.cursos.entities.Professor;
import com.techcamps.gestao.cursos.entities.Telefone;
import com.techcamps.gestao.cursos.models.AlunoModel;
import com.techcamps.gestao.cursos.models.CursoModel;

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
        curso.setMaterialCurso(materialCurso);

        Telefone telefone1 = new Telefone();
        Telefone telefone2 = new Telefone();
        Endereco endereco1 = new Endereco();
        Aluno aluno1 = new Aluno();

        Telefone telefone3 = new Telefone();
        Telefone telefone4 = new Telefone();
        Endereco endereco2 = new Endereco();
        Endereco endereco3 = new Endereco();
        Aluno aluno2 = new Aluno();

        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();

        cursoModel.create(curso);
    }
}
