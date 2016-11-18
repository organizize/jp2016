package jp2016.news;

import lt.vtvpmc.Article;

public class MaskedArticle implements Article {

    private String heading;
    private String brief;
    
    public MaskedArticle(String heading, String brief) {
        this.heading = heading;
        this.brief = brief;
    }

    @Override
    public String getHeading() {
        return heading;
    }
    
    @Override
    public String getBrief() {
        return brief;
    }


}
