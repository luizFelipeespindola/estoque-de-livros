package com.luiz;

import com.luiz.dao.LivroDAO;
import com.luiz.entities.Livro;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try{

            Livro livro = new Livro();
            LivroDAO livroDAO = new LivroDAO();

            livro.setTitulo("Java para Iniciantes");
            livro.setAutor("Paulo Silva");
            livro.setCodigo("001L");
            livro.setQuantidade(1);

            livroDAO.cadastrar(livro);


            System.out.println("Livro Cadastrado");

        }catch (IllegalArgumentException erro){
            System.out.println("Erro de validacao " + erro.getMessage());

        }catch (SQLException erroSQL){
            System.out.println("Erro ao cadastrar o livro "+ erroSQL.getMessage());
        }

    }
}
