package com.luiz;

import com.luiz.dao.LivroDAO;
import com.luiz.entities.Livro;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            LivroDAO livroDAO = new LivroDAO();

            Livro livro = livroDAO.buscarPorCodigo("001L");

            if (livro != null) {
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Codigo: " + livro.getCodigo());
                System.out.println("Quantidade: " + livro.getQuantidade());
            } else {
                System.out.println("Livro nao encontrado.");
            }

        } catch (SQLException erroSQL) {
            System.out.println("Erro ao buscar livro: " + erroSQL.getMessage());
        }
    }
}