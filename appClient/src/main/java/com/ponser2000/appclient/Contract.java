package com.ponser2000.appclient;

import javafx.beans.property.*;

import java.time.LocalDateTime;


public class Contract {

    private final ObjectProperty<LocalDateTime> createDate;
    private final IntegerProperty revision;
    private final ObjectProperty<LocalDateTime> updateDate;
    private final BooleanProperty actual;


    public Contract(String createDate, int revision, String updateDate, boolean actual) {
        this.createDate = new SimpleObjectProperty<>(LocalDateTime.parse(createDate));
        this.revision = new SimpleIntegerProperty(revision);
        this.updateDate = new SimpleObjectProperty<>(LocalDateTime.parse(updateDate));
        this.actual = new SimpleBooleanProperty(actual);
    }

    public Contract(LocalDateTime createDate, int revision, LocalDateTime updateDate, boolean actual) {
        this.createDate = new SimpleObjectProperty<>(createDate);
        this.revision = new SimpleIntegerProperty(revision);
        this.updateDate = new SimpleObjectProperty<>(updateDate);
        this.actual = new SimpleBooleanProperty(actual);
    }

    public LocalDateTime getCreateDate() {
        return createDate.get();
    }

    public ObjectProperty<LocalDateTime> createDateProperty() {
        return createDate;
    }

    public int getRevision() {
        return revision.get();
    }

    public IntegerProperty revisionProperty() {
        return revision;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate.get();
    }

    public ObjectProperty<LocalDateTime> updateDateProperty() {
        return updateDate;
    }

    public boolean isActual() {
        return actual.get();
    }

    public BooleanProperty actualProperty() {
        return actual;
    }
}
