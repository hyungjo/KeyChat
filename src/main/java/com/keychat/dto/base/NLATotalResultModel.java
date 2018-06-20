package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class NLATotalResultModel implements Serializable {
    private ArrayList<String> keyword;
    private ArrayList<String> entity;
    private ArrayList<String[]> category;

    public NLATotalResultModel(ArrayList<String> keyword, ArrayList<String> entity, ArrayList<String[]> category) {
        this.keyword = keyword;
        this.entity = entity;
        this.category = category;
    }

    public ArrayList<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(ArrayList<String> keyword) {
        this.keyword = keyword;
    }

    public ArrayList<String> getEntity() {
        return entity;
    }

    public void setEntity(ArrayList<String> entity) {
        this.entity = entity;
    }

    public ArrayList<String[]> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String[]> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NLATotalResultModel that = (NLATotalResultModel) o;

        return new EqualsBuilder()
                .append(keyword, that.keyword)
                .append(entity, that.entity)
                .append(category, that.category)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(keyword)
                .append(entity)
                .append(category)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "NLATotalResultModel{" +
                "keyword=" + keyword +
                ", entity=" + entity +
                ", category=" + category +
                '}';
    }
}
