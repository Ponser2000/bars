package com.ponser2000.appclient;


import java.time.LocalDateTime;

public class ContractJson {
    private LocalDateTime createDate;
    private int revision;
    private LocalDateTime updateDate;
    private boolean actual;

    public ContractJson() {
        super();
    }

    public ContractJson(LocalDateTime createDate, int revision, LocalDateTime updateDate, boolean actual) {
        super();
        this.createDate = createDate;
        this.revision = revision;
        this.updateDate = updateDate;
        this.actual = actual;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    @Override
    public String toString() {
        return "ContractJson{" +
                "createDate=" + createDate +
                ", revision=" + revision +
                ", updateDate=" + updateDate +
                ", actual=" + actual +
                '}';
    }
}
