package com.keychat.dto.base;

import java.io.Serializable;
import java.util.Objects;

public class UsersModel implements Serializable {
    private String email;
    private String password;
    private String nickname;
    private String job;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getNickname(), that.getNickname()) &&
                Objects.equals(getJob(), that.getJob()) &&
                Objects.equals(getPhone(), that.getPhone());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmail(), getPassword(), getNickname(), getJob(), getPhone());
    }
}
