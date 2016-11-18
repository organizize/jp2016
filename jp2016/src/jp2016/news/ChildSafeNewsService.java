package jp2016.news;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

public class ChildSafeNewsService implements NewsService {

    private static final String[] COMMON_SWEARINGS = { "rupūs miltai", "velniai rautų", "velnias", "velniais" };

    private Set<String> swearings = new HashSet<String>(Arrays.asList(COMMON_SWEARINGS));
    private NewsService newsService = new NewsServiceImpl();

    
    public void addSwearing(String swearing) {
        if (swearing != null) {
            swearings.add(swearing.toLowerCase());
        }
    }

    
    @Override
    public List<Article> getArticles() {
        return getChildSafeArticles(newsService.getArticles());
    }
    

    private List<Article> getChildSafeArticles(List<Article> articles) {
        List<Article> childSafeArticles = new ArrayList<Article>();
        articles.stream()
                .filter(this::isChildSafeHeading)
                .map(article -> maskSwearings(article))
                .forEach(article -> childSafeArticles.add(article));
        return childSafeArticles;
    }

    
    boolean isChildSafeHeading(Article article) {
        if (swearings.isEmpty()) {
            return true;
        }
        return swearings.stream()
                        .noneMatch(swearing -> article.getHeading().toLowerCase().contains(swearing));
    }

    
    Article maskSwearings(Article article) {
        String maskedBrief = article.getBrief();

        for (String swearing : swearings) {
            maskedBrief = maskedBrief.replaceAll("(?i)" + swearing, "***");
        }
        return new MaskedArticle(article.getHeading(), maskedBrief);
    }

}
