package jp2016.philatelist;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import philatelist.Philatelist;
import philatelist.PostStamp;

/**
 * PhilatelistImpl implements Philatelist inteface - a person who collects stamps.
 * @author domas
 *
 */

public class PhilatelistImpl implements Philatelist {

    public static final Logger logger = Logger.getLogger(PhilatelistImpl.class.getName());
    Set<PostStamp> collection = new HashSet<PostStamp>();

    public PhilatelistImpl() {
        initLogger();
    }


    /**
     * Adds given stamp to stamp collection. Does nothing if stamp is already in collection.
     * 
     * @param stamp - stamp to add to collection
     * @throws IllegalArgumentException if given stamp  is null or stamp name is null or "" 
     */
    @Override
    public void addToCollection(PostStamp stamp) {
        if ((stamp == null) || (stamp.getName() == null) || (stamp.getName().equals(""))) {
            IllegalArgumentException e = new IllegalArgumentException("null stamp or null/empty name");
            logger.log(Level.INFO, "illegal argument", e);
            throw e;
        }
        if (collection.add(stamp)) {
            logger.log(Level.FINE, "Added new stamp to collection - {0}", stamp.toString());
        } else {
            logger.log(Level.FINE, "Stamp already in collection - {0}", stamp.toString());
        }
    }
    
    /**
     * Counts average market price of stamps in philatelist's stamp collection
     * @return average price of stamps in collection 
     */
    @Override
    public double getAveragePostStampPrice() {
        if (collection.isEmpty()) {
            return 0.0;
        } else {
            return collection
                        .stream()
                        .mapToDouble(stamp -> stamp.getMarketPrice())
                        .average()
                        .getAsDouble();
        }
    }

    
    /**
     * Returns number of stamps in philatelist's collection.
     * @return number of stamps in philatelist's collection
     */
    @Override
    public int getNumberOfPostStampsInCollection() {
        return collection.size();
    }

    
    /**
     * Returns the most expensive stamp if collection.
     * @return the most expensive stamp if collection. Null if collection is empty 
     */
    @Override
    public PostStamp getTheMostExpensivePostStamByMarketValue() {
        Comparator<PostStamp> marketPriceComparator = 
                (s1, s2) -> ((s1.getMarketPrice() - s2.getMarketPrice()) > 0) 
                              ? 1
                              : ((s1.getMarketPrice() - s2.getMarketPrice()) < 0) 
                                  ? -1 
                                  : 0;
        if (collection.isEmpty()) {
            return null;
        } else {
            return collection.stream().max(marketPriceComparator).get();
        }
    }
    
    
    private void initLogger() {
        logger.setLevel(Level.FINEST);
        ConsoleHandler ch;
        FileHandler fh;
        ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        try {
            fh = new FileHandler("philatelist_log.log", false);
            fh.setLevel(Level.FINEST);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
