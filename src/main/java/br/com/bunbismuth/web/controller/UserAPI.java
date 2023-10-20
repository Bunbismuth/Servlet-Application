package br.com.bunbismuth.web.controller;

import br.com.bunbismuth.web.dto.UserDTO;
import br.com.bunbismuth.web.model.UserModel;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userAPI")
public class UserAPI extends HttpServlet {
    List<UserModel> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        String usersConverted = gson.toJson(users);

        resp.getWriter().append(usersConverted);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while((line = br.readLine()) != null){
            stringBuilder.append(line);
        }

        Gson gson = new Gson();
        UserDTO userDTO = gson.fromJson(stringBuilder.toString(), UserDTO.class);
        UserModel user = new UserModel(userDTO);
        // Só para mostrar a lista com o novo usuário
        users.add(user);

        System.out.println("Informações do cadastro \n" + "Nome: " + user.getName() + "\n" + "Email: " + user.getEmail() + "\n");

    }
}
