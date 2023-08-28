package com.swietlik.swietlik.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Strimerki {

    private int id;
    private String username;
    public Strimerki(){
    }

    public Strimerki(int id, String username) {
        this.id = id;
        this.username = username;
    }
}
