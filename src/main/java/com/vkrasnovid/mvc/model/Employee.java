package com.vkrasnovid.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEdit() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"/edit/").append(this.getId()).append("\">Edit</a>");
        return new String(stringBuilder);
    }

    public String getDelete() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"/remove/").append(this.getId()).append("\">Delete</a>");
        return new String(stringBuilder);
    }
}
