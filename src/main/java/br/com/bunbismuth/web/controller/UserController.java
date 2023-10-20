package br.com.bunbismuth.web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userRegister")
public class UserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cadastroSucesso.html");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Para armazenarmos as informações que são mandadas podemos utilizar o getParameter fazendo referência ao nome
        // utilizado no HTML.
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        System.out.println("Método = " + request.getMethod());
        System.out.println("Usuário " + name + " salvo com sucesso!");
        doGet(request, response);
    }
}
