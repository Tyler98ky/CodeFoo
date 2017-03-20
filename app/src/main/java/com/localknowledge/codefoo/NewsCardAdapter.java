package com.localknowledge.codefoo;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.ViewHolder>{
    public ArrayList<Article> articles = new ArrayList<>();
    ArrayList<JsonObject> test;

    public NewsCardAdapter(ArrayList<JsonObject> json){
        test = json;
        this.articles = makeArray();


    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
    @Override
    public NewsCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(NewsCardAdapter.ViewHolder holder, int position) {
        Article current = articles.get(position);

        URL url = null;
        try {
            url = new URL(current.getImage());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CardView cardView = holder.cardView;

        ImageView imgView = (ImageView) cardView.findViewById(R.id.imageView1);
        imgView.setImageURI(Uri.parse(current.getImage()));
        Picasso.with(cardView.getContext()).load(current.getImage()).into(imgView);
        imgView.setContentDescription(current.getSubTitle());

        TextView txtView = (TextView) cardView.findViewById(R.id.textView);
        txtView.setText(current.getHeadline());
        txtView.setContentDescription(current.getSlug());

        TextView txtView2 = (TextView) cardView.findViewById(R.id.textView2);
        txtView2.setText(current.getPublishDate());


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public ArrayList<Article> makeArray(){
        for (JsonObject x : test) {
            String image;
            String headline;
            String subTitle;
            String publishDate;
            String slug;
            int count = Integer.parseInt(x.get("count").toString());

            for(int i=0; i<count; i++){
                image = x.getAsJsonArray("data").get(i).getAsJsonObject().get("thumbnails").getAsJsonArray().get(2).getAsJsonObject().get("url").toString();
                image = image.replace("\"","");

                headline = x.getAsJsonArray("data").get(i).getAsJsonObject().get("metadata").getAsJsonObject().get("headline").toString();
                headline = headline.substring(1, headline.length()-1);
                headline = headline.replace("\\","");

                subTitle = x.getAsJsonArray("data").get(i).getAsJsonObject().get("metadata").getAsJsonObject().get("subHeadline").toString();
                subTitle = subTitle.substring(1, subTitle.length()-1);
                subTitle = subTitle.replace("\\","");

                publishDate = x.getAsJsonArray("data").get(i).getAsJsonObject().get("metadata").getAsJsonObject().get("publishDate").toString();
                publishDate = publishDate.substring(1, publishDate.length()-1);

                slug = x.getAsJsonArray("data").get(i).getAsJsonObject().get("metadata").getAsJsonObject().get("slug").toString();
                slug = slug.substring(1, slug.length()-1);
                slug = formatSlug(slug, publishDate);

                publishDate = getElapsedTime(publishDate);

                articles.add(new Article(image, headline, subTitle, publishDate, slug));
            }
        }
        return articles;
    }

    public String getElapsedTime(String publishDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

        Calendar published = Calendar.getInstance();

        try {
            Date pubDate = formatter.parse(publishDate);
            published.setTime(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return convertPublishDate(published);
    }

    public String convertPublishDate(Calendar published){
        String result = "";
        Calendar current = Calendar.getInstance();
        long compared = current.getTimeInMillis() - published.getTimeInMillis();
        compared /= 3600000; //turn milliseconds into hours

        long numOfHours = compared%24;
        long numOfDays = compared/24;


        if(numOfDays != 0){
            result = result.concat(numOfDays + " DAYS ");
        }
        if(numOfHours == 1){
            result = result.concat("1 HOUR AGO");
        }
        else if(numOfHours == 0){
            return result.concat(" AGO");
        }
        else{
            result = result.concat(numOfHours + " HOURS AGO");
        }


        return result;
    }

    public String formatSlug(String slug, String publishDate){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

        Calendar published = Calendar.getInstance();

        try {
            Date pubDate = formatter.parse(publishDate);
            published.setTime(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DecimalFormat decimalFormat = new DecimalFormat("00");

        slug = "http://www.ign.com/articles/" + published.get(Calendar.YEAR) + "/" + decimalFormat.format((published.get(Calendar.MONTH) + 1)) + "/" + decimalFormat.format(published.get(Calendar.DAY_OF_MONTH)) + "/" + slug;

        return slug;
    }
}
