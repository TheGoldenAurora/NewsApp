package com.example.umasubbiah.newsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


class ArticleAdapter extends ArrayAdapter<ArticleData> {

    public ArticleAdapter(Context context, List<ArticleData> articleList) {
        super(context, 0, articleList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item, parent, false);
        }

        ArticleData current = getItem(position);

        if (current != null) {
            ImageView articleThumbnail = listItemView.findViewById(R.id.thumbnail);
            articleThumbnail.setImageBitmap(getImage(current.getThumbnail()));

            TextView section = listItemView.findViewById(R.id.section);
            section.setText(current.getSection());

            TextView title = listItemView.findViewById(R.id.title);
            title.setText(current.getTitle());

            TextView author = listItemView.findViewById(R.id.author);
                if(current.getAuthor()!=null)
                    author.setText("Contributed by : " + current.getAuthor());

            TextView publishTime = listItemView.findViewById(R.id.timeStamp);
            publishTime.setText("Date : "+getTime(current.getPublishTime()));
        }
        return listItemView;
    }

    private String getTime(final String time) {
        String def = "--";
        if ((time != null) && (!time.isEmpty())) try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd / HH:mm");
            def = date.format(formatter.parse(time));
        } catch (ParseException e) {
            Log.e(ArticleAdapter.class.getName(), "Parsing error", e);
        }

        return def;
    }


    private Bitmap getImage(Bitmap articleThumbnail) {
        Bitmap thumbnail;
        if (articleThumbnail == null) {
            thumbnail = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.news);
        } else {
            thumbnail = articleThumbnail;
        }
        return thumbnail;
    }
}
