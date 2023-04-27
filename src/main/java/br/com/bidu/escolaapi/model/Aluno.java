package br.com.bidu.escolaapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomealunos;

    @ManyToOne
    @JoinColumn(name= "curso_id")
    private Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //apagando o get and set anterior pq o nome ta errado

    public String getNomealunos() {
        return nomealunos;
    }

    public void setNomealunos(String nomealunos) {
        this.nomealunos = nomealunos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
