package eic.ifpr.pgua.relatorios.models;

import java.time.LocalDateTime;

public class Pessoa {
    private int id;
    private String nome;
    private LocalDateTime nascimento;
    private double altura;
    
    
    public Pessoa(int id, String nome, LocalDateTime nascimento, double altura) {
        this.setId(id);
        this.setNome(nome);
        this.setNascimento(nascimento);
        this.setAltura(altura);
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDateTime getNascimento() {
        return nascimento;
    }


    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }


    public double getAltura() {
        return altura;
    }


    public void setAltura(double altura) {
        this.altura = altura;
    }

    


}
