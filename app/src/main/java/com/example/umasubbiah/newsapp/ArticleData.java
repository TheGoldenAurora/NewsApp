package com.example.umasubbiah.newsapp;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;


public class ArticleData {

    private String mTitle;
    private String mSection;
    private Bitmap mThumbnail;
    private String mPublishTime;
    private String mURL;
    private String mAuthor;

    public ArticleData(String section, String articleTitle, String author, Bitmap articleThumbnail, String articlePublishTime, String articleURL) {
        mSection = section;
        mTitle = articleTitle;
        mAuthor = author;
        mThumbnail = articleThumbnail;
        mPublishTime = articlePublishTime;
        mURL = articleURL;
    }

    @Nullable
    public String getSection(){return mSection;}

    @Nullable
    public String getTitle() {
        return mTitle;
    }

    @Nullable
    public String getAuthor() {
        return mAuthor;
    }

    @Nullable
    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    @Nullable
    public String getPublishTime() {
        return mPublishTime;
    }

    @Nullable
    public String getURL() {
        return mURL;
    }
}
