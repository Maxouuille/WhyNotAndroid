package com.example.why_not_android.data.Models;

public class Match {
    public String name;
    public String imageURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Match{" +
                "name='" + name + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
