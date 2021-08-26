package com.personal_log.database.entities;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String userName;

    public User() {
    }

    public User(String username) {
        this.userName = username;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, username='%s']",
                id, userName);
    }

}
