package com.mobilenoc.sync.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Sync {
    @Id
    private Integer id;
    private String name;

    public Sync() {
    }

    public Sync(Integer id, String name) {
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
        Sync sync = (Sync) o;
        return Objects.equals(id, sync.id) &&
                Objects.equals(name, sync.name);
    }

}
