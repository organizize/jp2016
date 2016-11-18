package jp2016.philatelist;

import static org.junit.Assert.*;

import org.junit.Test;

import philatelist.Philatelist;
import philatelist.PhilatelistBaseTest;
import philatelist.PostStamp;

public class PhilatelistTest extends PhilatelistBaseTest {
    
    public static final double DELTA = 0.00001;
    PostStamp stamp1 = new PostStamp("Stamp1", 2.50, 4.00);
    PostStamp stamp2 = new PostStamp("Stamp2", 3.00, 5.00);
    PostStamp stamp3 = new PostStamp("Stamp3", 5.00, 6.00);
    PostStamp stamp4 = new PostStamp("", 10.0, 10.0);
    
    @Override
    protected Philatelist getPhilatelist() {
        return new PhilatelistImpl();
    }

    @Test
    public void getAveragePostStampPriceEmptyListTest() {
        Philatelist philatelist = new PhilatelistImpl();
        assertEquals(0.0, philatelist.getAveragePostStampPrice(), DELTA);
    }
    
    @Test
    public void getAveragePostStampPriceTest() {
        Philatelist philatelist = new PhilatelistImpl();
        philatelist.addToCollection(stamp1);
        philatelist.addToCollection(stamp2);
        philatelist.addToCollection(stamp3);
        assertEquals(5.0, philatelist.getAveragePostStampPrice(), DELTA);
    }
    
    
    @Test
    public void getTheMostExpensivePostStamByMarketValueEmptyListTest() {
        Philatelist philatelist = new PhilatelistImpl();
        assertNull(philatelist.getTheMostExpensivePostStamByMarketValue());
    }
    
    @Test
    public void getTheMostExpensivePostStamByMarketValueTest() {
        Philatelist philatelist = new PhilatelistImpl();
        philatelist.addToCollection(stamp1);
        philatelist.addToCollection(stamp3);
        philatelist.addToCollection(stamp2);
        assertEquals(stamp3, philatelist.getTheMostExpensivePostStamByMarketValue());
    }
    
    
    @Test
    public void getNumberOfPostStampsInCollectionEmptyListTest() {
        Philatelist philatelist = new PhilatelistImpl();
        assertEquals(0, philatelist.getNumberOfPostStampsInCollection());
    }
    
    @Test
    public void getNumberOfPostStampsInCollectionTest() {
        Philatelist philatelist = new PhilatelistImpl();
        philatelist.addToCollection(stamp1);
        philatelist.addToCollection(stamp2);
        philatelist.addToCollection(stamp3);
        assertEquals(3, philatelist.getNumberOfPostStampsInCollection());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addToCollectionNullStampTest() {
        Philatelist philatelist = new PhilatelistImpl();
        philatelist.addToCollection(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void addToCollectionStampWithNullNameTest() {
        Philatelist philatelist = new PhilatelistImpl();
        philatelist.addToCollection(stamp4);
    }
    
    @Test
    public void addToCollectionRepeatingStampsTest() {
        Philatelist philatelist = new PhilatelistImpl();
        philatelist.addToCollection(stamp1);
        philatelist.addToCollection(stamp2);
        philatelist.addToCollection(stamp2);
        assertEquals(2, philatelist.getNumberOfPostStampsInCollection());
    }
    
    
    
}
