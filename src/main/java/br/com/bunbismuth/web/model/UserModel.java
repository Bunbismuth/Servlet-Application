package br.com.bunbismuth.web.model;

import br.com.bunbismuth.web.dto.UserDTO;

public class UserModel {
    private String name;
    private String email;

    public UserModel (UserDTO userDTO){
        this.name = userDTO.name();
        this.email = userDTO.email();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
