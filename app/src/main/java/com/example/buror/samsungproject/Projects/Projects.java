package com.example.buror.samsungproject.Projects;

import java.io.Serializable;

public class Projects implements Serializable {
    String namePro, timePro, key;

    public Projects(){}

    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public String getTimePro() {
        return timePro;
    }

    public void setTimePro(String timePro) {
        this.timePro = timePro;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Projects(String namePro, String timePro, String key) {
        this.namePro = namePro;
        this.timePro = timePro;
        this.key = key;
    }
}