package com.infinitefocus.edu1010.Models;
public class viewPagerModel {
    private  int mImage;
    private String mTitle;
    private String mDescription;

    public viewPagerModel(int mImage, String mTitle, String mDescription) {
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}