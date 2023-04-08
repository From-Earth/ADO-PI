package br.com.carstore.servlet;
import br.com.carstore.dao.UsuarioDao;
import br.com.carstore.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        String logradouro = request.getParameter("logradouro");
        String numero_endereco = request.getParameter("numero__logradouro");

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setTelefone(telefone);
        usuario.setLogradouro(logradouro);
        usuario.setNumero_endereco(numero_endereco);

        new UsuarioDao().createUser(usuario);
        request.getRequestDispatcher("index.html").forward(request, response);

    }
}
