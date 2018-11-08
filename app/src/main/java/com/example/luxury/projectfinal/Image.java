package com.example.luxury.projectfinal;

public class Image {
    private int id;
    private int categoryId;
    private String imageUrl;
    private String imageSound;
    private String imageName;
    private String description;

    public Image(){}

    public Image(int id, int categoryId, String imageUrl, String imageSound, String imageName, String description) {
        this.id = id;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
        this.imageSound = imageSound;
        this.imageName = imageName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageSound() {
        return imageSound;
    }

    public void setImageSound(String imageSound) {
        this.imageSound = imageSound;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
