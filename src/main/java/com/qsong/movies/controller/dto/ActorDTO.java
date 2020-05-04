package com.qsong.movies.controller.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ActorDTO {

    private String name;
    private int sex;
    private String born;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }
}
