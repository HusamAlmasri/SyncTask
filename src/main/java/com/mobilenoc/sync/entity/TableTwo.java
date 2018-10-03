package com.mobilenoc.sync.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TableTwo {
    @Id
    private Integer id;
    private String name;

    public TableTwo() {
    }

    public TableTwo(Integer id, String name) {
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
        TableTwo tableTwo = (TableTwo) o;
        return Objects.equals(id, tableTwo.id) &&
                Objects.equals(name, tableTwo.name);
    }

}
