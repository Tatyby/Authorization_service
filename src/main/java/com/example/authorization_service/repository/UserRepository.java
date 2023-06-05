package com.example.authorization_service.repository;

import com.example.authorization_service.Authorities;
import com.example.authorization_service.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class UserRepository {
    private String USER = "Tanya";
    private String PASSWORD = "123";

    public List<Authorities> getUserAuthorities(User user) {
        List<Authorities> list = new ArrayList<>();
        list.add(Authorities.DELETE);
        list.add(Authorities.READ);
        list.add(Authorities.WRITE);
        if (user.getUser().equals(USER) && user.getPassword().equals(PASSWORD)) return list;

        return new ArrayList<>();
    }
}
