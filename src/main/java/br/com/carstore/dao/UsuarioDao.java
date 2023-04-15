package br.com.carstore.dao;

import br.com.carstore.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioDao {
    public void createUser(Usuario user){
        String SQL = "INSERT INTO USUARIO (nome, cpf, email, senha, telefone, logradouro, numero_endereco) VALUES (?,?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getCpf());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.setString(5, user.getTelefone());
            preparedStatement.setString(6, user.getLogradouro());
            preparedStatement.setString(7, user.getNumero_endereco());

            preparedStatement.execute();
            connection.close();
            System.out.println("success in connection");

        }catch (Exception ex){
            System.out.println("fail in connection");
        }
    }
    public List<Usuario> findAllUsuario() {
        String SQL = "SELECT * FROM USUARIO";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in connection");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();
            while (resultSet.next()) {

                String userName = resultSet.getString("nome");

                Usuario usuario = new Usuario();
                usuario.setNome(userName);
                usuarios.add(usuario);

                System.out.println("Funfou");

            }
                 return  usuarios;


        }catch (Exception ex){
            System.out.println("fail in connection");
            return Collections.emptyList();
        }
    }
}
