package com.vkrasnovid.mvc.model;

public class Employee {
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

    public String getEdit()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"/edit/" + this.getId() + "\">Edit</a>");
        return  new String(stringBuilder);
    }

    public String getDelete()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a href=\"/remove/" + this.getId() + "\">Delete</a>");
        return  new String(stringBuilder);
    }
}
