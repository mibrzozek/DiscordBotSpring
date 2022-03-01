package com.DBSpring.DiscordBotSpring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User
{
    @Id
    @Column
    private String id;
    private String name;

    public User(String id, String name)
    {
        this.id =id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

}
