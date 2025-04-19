package com.example.kori.ui.cities;

public class CityItem {
    private String title;
    private String description;
    private String longDescription;
    private int imageResId;
    private int soundResId;

    public CityItem(String title, String description, String longDescription, int imageResId, int soundResId) {
        this.title = title;
        this.description = description;
        this.longDescription = longDescription;
        this.imageResId = imageResId;
        this.soundResId = soundResId;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLongDescription() { return longDescription; }
    public int getImageResId() { return imageResId; }
    public int getSoundResId() { return soundResId; }
}
