package com.example.luxury.projectfinal;

public class Learn {

    private String url, name, description;
    private int categoryId;

    public Learn(String url, String name, String description, int categoryId) {
        this.url = url;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
