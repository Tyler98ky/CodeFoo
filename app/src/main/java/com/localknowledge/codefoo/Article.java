package com.localknowledge.codefoo;

public class Article {
    private String image;
    private String headline;
    private String subTitle;
    private String publishDate;
    private String slug;

    public Article(String image, String headline, String subTitle, String publishDate, String slug){
        this.image = image;
        this.headline = headline;
        this.subTitle = subTitle;
        this.publishDate = publishDate;
        this.slug = slug;
    }

    public Article(){
        this.image = "http://assets1.ignimgs.com/2017/02/16/thelastjedi-1280-1487278502126_large.jpg";
        this.headline = "This is a test default Article Object";
        this.subTitle = "The pic should be the last jedi";
        this.publishDate = "2017-02-16T15:16:29+0000";
    }

    public String getImage() {
        return image;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getSlug() {
        return slug;
    }



    @Override
    public String toString() {
        return headline;
    }
}
