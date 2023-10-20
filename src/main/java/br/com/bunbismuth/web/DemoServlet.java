package br.com.bunbismuth.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demoServlet")
public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Método = " + request.getMethod());
        System.out.println("Primeiro servlet funcionando");
    }
}
