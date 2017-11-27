package com.example.umasubbiah.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of Article by using an AsyncTask to perform the
 * network request to the given URL.
 */

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class ArticleLoader extends AsyncTaskLoader<List<ArticleData>> {

    /** Tag for log messages */
    private static final String LOG_TAG = ArticleLoader.class.getName();

    /** Query URL */
    private String mURL;

    public ArticleLoader(Context context, String URL) {
        super(context);
        mURL = URL;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<ArticleData> loadInBackground() {
        if (mURL == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<ArticleData> articles = QueryUtils.fetchArticleData(mURL);
        return articles;
    }
}
