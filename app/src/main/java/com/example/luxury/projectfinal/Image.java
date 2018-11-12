package com.example.luxury.projectfinal;

import android.graphics.drawable.Drawable;

public class Image {
    private int id;
    private int categoryId;
    private String imageUrl;
    private String hint;
    private String imageName;
    private String description;
    private Drawable drawable;

    public Image(){}

    public Image(int id, int categoryId, String imageUrl, String hint, String imageName, String description) {
        this.id = id;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
        this.hint = hint;
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

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
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

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
