package com.luiz.dao;

import com.luiz.connection.*;
import com.luiz.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Livro> listar() throws SQLException{

        List<Livro> livros = new ArrayList<>();

        String sql = "SELECT titulo, autor, codigo, quantidade FROM livros";

        try(Connection conexao = Conexao.conectar()){

            try(PreparedStatement comando = conexao.prepareStatement(sql)){

                try(ResultSet resultado = comando.executeQuery()) {

                    while (resultado.next()) {

                        Livro livro = new Livro();

                        livro.setTitulo(resultado.getString("titulo"));
                        livro.setAutor(resultado.getString("autor"));
                        livro.setCodigo(resultado.getString("codigo"));
                        livro.setQuantidade(resultado.getInt("quantidade"));

                        livros.add(livro);
                    }

                }
            }
        }

        return livros;
    }



}