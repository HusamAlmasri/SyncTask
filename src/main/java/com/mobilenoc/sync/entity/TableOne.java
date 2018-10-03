package com.mobilenoc.sync.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TableOne {
    @Id
    private Integer id;
    private String name;

    public TableOne() {
    }

    public TableOne(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableOne tableOne = (TableOne) o;
        return Objects.equals(id, tableOne.id) &&
                Objects.equals(name, tableOne.name);
    }

}
