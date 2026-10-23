package com.luiz.dao;

import com.luiz.connection.*;
import com.luiz.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    public void cadastrar(Livro livro) throws SQLException {

        String sql = "INSERT INTO livros (titulo, autor, codigo, quantidade) " +
                "VALUES (?, ?, ?, ?)";


        try(Connection conexao = Conexao.conectar()){

            try(PreparedStatement comando = conexao.prepareStatement(sql)){

                comando.setString(1, livro.getTitulo());
                comando.setString(2, livro.getAutor());
                comando.setString(3, livro.getCodigo());
                comando.setInt(4, livro.getQuantidade());

                comando.executeUpdate();

            }
        }

    }
}