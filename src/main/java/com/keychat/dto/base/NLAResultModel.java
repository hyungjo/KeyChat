package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;

public class NLAResultModel {
    private ArrayList<String> keyword;
    private ArrayList<String> entity;
    private ArrayList<String> midCategory;

    public NLAResultModel(ArrayList<String> keyword, ArrayList<String> entity, ArrayList<String> midCategory) {
        this.keyword = keyword;
        this.entity = entity;
        this.midCategory = midCategory;
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

    public ArrayList<String> getMidCategory() {
        return midCategory;
    }

    public void setMidCategory(ArrayList<String> midCategory) {
        this.midCategory = midCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NLAResultModel that = (NLAResultModel) o;

        return new EqualsBuilder()
                .append(keyword, that.keyword)
                .append(entity, that.entity)
                .append(midCategory, that.midCategory)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(keyword)
                .append(entity)
                .append(midCategory)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "NLAResultModel{" +
                "keyword=" + keyword +
                ", entity=" + entity +
                ", midCategory=" + midCategory +
                '}';
    }
}
