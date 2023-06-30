package com.example.demo11;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="chat")

public class Chat{
    @Id
    @Column(name="code")
    private int code;
    
    @Column(name="users")
    private String users;

    @Column(name="room")
    private int room;

    @Column(name="messager")
    private String messager;

    public Chat(){
    }

    public Chat(
        int code,
        String users,
        int room,
        String messager
    ){
        this.code = code;
        this.users = users;
        this.room = room;
        this.messager = messager;

    }

    public int getCode(){
        return code;
    }

    public String getUsers(){
        return users;
    }

    public int getRoom(){
        return room;
    }
    public String getMessager(){
        return messager;
    }
}
