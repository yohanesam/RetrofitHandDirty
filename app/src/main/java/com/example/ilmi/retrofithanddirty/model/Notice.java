package com.example.ilmi.retrofithanddirty.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ILMI on 8/12/2018.
 */

public class Notice {

    @SerializedName("id_user")
        private String idUser;

    @SerializedName("username")
        private String username;

    @SerializedName("password")
        private String password;

    @SerializedName("status")
        private String status;


    public Notice(String idUser, String username, String password, String status) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
