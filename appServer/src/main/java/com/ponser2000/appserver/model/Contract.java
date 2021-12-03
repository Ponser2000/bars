package com.ponser2000.appserver.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "contracts")
public class Contract {

    public static final int START_SEQ = 100000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected Integer id;

    @Column(name = "DATE_CREATE", nullable = false)
    @NonNull
    private LocalDateTime dateCreate;

    @Column(name = "REVISION", nullable = false)
    @NonNull
    private int revision;

    @Column(name = "DATE_UPDATE", nullable = false)
    @NonNull
    private LocalDateTime dateUpdate;

    public Contract() {

    }

    public Contract(Integer id, LocalDateTime dateUpdate, int revision, LocalDateTime dateCreate) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.revision = revision;
        this.dateUpdate = dateUpdate;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", dateCreate=" + dateCreate +
                ", revision=" + revision +
                ", dateUpdate=" + dateUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return revision == contract.revision && Objects.equals(id, contract.id) && dateCreate.equals(contract.dateCreate) && dateUpdate.equals(contract.dateUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreate, revision, dateUpdate);
    }
}
