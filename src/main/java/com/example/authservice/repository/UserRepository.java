package com.example.authservice.repository;

import com.example.authservice.model.Authorities;
import com.example.authservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private Set<User> users;

    public UserRepository() {
        this.users = new HashSet<>();

        users.add(new User(
                "admin",
                "1234",
                List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE))
        );

        users.add(new User(
                "localuser",
                "standardpwd",
                List.of(Authorities.READ, Authorities.WRITE))
        );
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (User person : users) {
            if (person.getUserName().equals(user) &&
            person.getUserPassword().equals(password)) {
                return person.getAuthoritiesList();
            }
        }
        return Collections.emptyList();
    }
}