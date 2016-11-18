package jp2016.news;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lt.vtvpmc.Article;
import lt.vtvpmc.BaseNewsServiceTest;
import lt.vtvpmc.NewsService;

public class ChildSafeNewsServiceTest extends BaseNewsServiceTest {

    String heading1 = "Laba diena";
    String heading2 = "Eikit po velniais";
    String heading3 = "Eikit po VELNiais";
    String brief1 = "Nieko idomaus";
    String brief2 = "Po velniais";
    String brief3 = "Rupūs miltai, po velniais";
    String brief4 = "RUPūs MILTai, po VELNiais";
    
    Article article1 = new MaskedArticle(heading1, brief1);
    Article article2 = new MaskedArticle(heading1, brief2);
    Article article3 = new MaskedArticle(heading1, brief3);
    Article article4 = new MaskedArticle(heading2, brief1);
    Article article5 = new MaskedArticle(heading2, brief3);
    Article article6 = new MaskedArticle(heading1, brief4);
    Article article7 = new MaskedArticle(heading3, brief4);
    
    ChildSafeNewsService news = new ChildSafeNewsService();
    
    
    @Override
    protected NewsService getNewsService() {
        return new ChildSafeNewsService(); 
    }

    @Test
    public void maskSwearingsNoSwearingsTest() {
        assertEquals(article1.getBrief(), news.maskSwearings(article1).getBrief());
    }
    
    @Test
    public void maskSwearingsSingleSwearingTest() {
        assertEquals("Po ***", (news.maskSwearings(article2)).getBrief());
    }
    
    @Test
    public void maskSwearingsMultipleSwearingsTest() {
        assertEquals("***, po ***", (news.maskSwearings(article3)).getBrief());
    }
    
    @Test
    public void maskSwearingsDifferentCaseTest() {
        assertEquals("***, po ***", (news.maskSwearings(article6)).getBrief());
    }
    
    @Test
    public void isChildSafeHeadingNoSwearingsTest() {
        assertTrue(news.isChildSafeHeading(article1));
    }
    
    @Test
    public void isChildSafeHeadingSingleSwearingTest() {
        assertFalse(news.isChildSafeHeading(article4));
    }
    
    @Test
    public void isChildSafeHeadingSingleSwearingDifferentCaseTest() {
        assertFalse(news.isChildSafeHeading(article7));
    }
    
    
}
