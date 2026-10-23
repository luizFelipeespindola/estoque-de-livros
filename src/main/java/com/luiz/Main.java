package com.luiz;

import com.luiz.dao.LivroDAO;
import com.luiz.entities.Livro;


import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            LivroDAO livroDAO = new LivroDAO();

            List<Livro> livros = livroDAO.listar();

            for (Livro livro : livros) {
                System.out.println("\nTítulo: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Codigo: " + livro.getCodigo());
                System.out.println("Quantidade: " + livro.getQuantidade());
                System.out.println("----------------------");
            }

        } catch (SQLException erroSQL) {
            System.out.println("Erro ao listar livros: " + erroSQL.getMessage());
        }

    }
}
