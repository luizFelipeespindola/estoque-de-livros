package com.luiz.entities;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String codigo;
    private int quantidade;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitulo(String titulo){

        if (titulo == null || titulo.trim().length() < 2 || !titulo.matches("^[\\p{L}\\p{N} ,.:\\-?!@#]+$")){
            throw new IllegalArgumentException("Titulo invalido");
        }

        this.titulo = titulo.trim();
    }

    public String getTitulo(){
        return titulo;
    }

    public void setAutor(String autor) {

        if(autor == null || autor.trim().length() < 2 || !autor.matches("^[\\p{L} ]+$")) {
            throw new IllegalArgumentException("Nome do autor invalido");
        }

        this.autor = autor.trim();
    }

    public String getAutor() {
        return autor;
    }

    public void setCodigo(String codigo) {

        if(codigo == null || codigo.trim().length() <= 3 || !codigo.trim().matches("^[\\p{L}0-9]+$")){
            throw new IllegalArgumentException("Codigo do livro invalido");
        }

        this.codigo = codigo.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setQuantidade(int quantidade) {

        if(quantidade < 0){
            throw new IllegalArgumentException("A quantidade do livro nao pode ser menor que zero");
        }

        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
