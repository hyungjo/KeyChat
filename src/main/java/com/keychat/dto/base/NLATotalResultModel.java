package com.keychat.dto.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class NLATotalResultModel implements Serializable {
    private Map<String, Integer> keywordAndEntity;
    private Map<String, Integer> category;

    public NLATotalResultModel(Map<String, Integer> keywordAndEntity, Map<String, Integer> category) {
        this.keywordAndEntity = keywordAndEntity;
        this.category = category;
    }

    public Map<String, Integer> getKeywordAndEntity() {
        return keywordAndEntity;
    }

    public void setKeywordAndEntity(Map<String, Integer> keywordAndEntity) {
        this.keywordAndEntity = keywordAndEntity;
    }

    public Map<String, Integer> getCategory() {
        return category;
    }

    public void setCategory(Map<String, Integer> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NLATotalResultModel that = (NLATotalResultModel) o;

        return new EqualsBuilder()
                .append(keywordAndEntity, that.keywordAndEntity)
                .append(category, that.category)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(keywordAndEntity)
                .append(category)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "NLATotalResultModel{" +
                "keywordAndEntity=" + keywordAndEntity +
                ", category=" + category +
                '}';
    }
}
