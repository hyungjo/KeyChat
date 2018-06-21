package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UserRepNameModel {
    private  String userRepName;

    public UserRepNameModel(String userRepName) {
        this.userRepName = userRepName;
    }

    public String getUserRepName() {
        return userRepName;
    }

    public void setUserRepName(String userRepName) {
        this.userRepName = userRepName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserRepNameModel that = (UserRepNameModel) o;

        return new EqualsBuilder()
                .append(userRepName, that.userRepName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userRepName)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "UserRepNameModel{" +
                "userRepName='" + userRepName + '\'' +
                '}';
    }
}
