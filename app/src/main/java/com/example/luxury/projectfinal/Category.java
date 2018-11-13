package com.example.luxury.projectfinal;

public class Category {
    private String name;
    private String icon;

    public Category() {
    }

    public Category(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setColor(String color) {
        this.icon = color;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", color='" + icon + '\'' +
                '}';
    }
}
