package com.spring.apibancooriginal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "gênero")
    private Genero genero;

    @Column(name = "cpf")
    private String cpf;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private String nascimento;

    public Cliente() {

    }

    public Cliente(Integer id, String nome, Genero genero, String cpf, String nascimento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public Cliente(String nome, Genero genero, String cpf, String nascimento) {
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}
