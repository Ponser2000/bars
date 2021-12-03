package com.ponser2000.appserver.to;


import java.time.LocalDateTime;

public record ContractTo(LocalDateTime createDate, Integer revision,
                         LocalDateTime updateDate, boolean actual) {

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public Integer getRevision() {
        return revision;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }


    public boolean actual() {
        return actual;
    }

    @Override
    public String toString() {
        return "ContractTo{" +
                "createDate=" + createDate +
                ", revision=" + revision +
                ", updateDate=" + updateDate +
                ", actual=" + actual +
                '}';
    }
}
