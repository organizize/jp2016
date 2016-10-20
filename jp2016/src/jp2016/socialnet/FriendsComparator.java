package jp2016.socialnet;

import java.util.Comparator;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;

public class FriendsComparator implements Comparator<Friend> {

    public FriendsComparator() {
    }

    @Override
    public int compare(Friend f1, Friend f2) {
        int cmp = f1.getCity().compareToIgnoreCase(f2.getCity());
        if (cmp != 0) {
            return cmp;
        }
        cmp = f1.getLastName().compareToIgnoreCase(f2.getLastName());
        if (cmp != 0) {
            return cmp;
        }
        cmp = f1.getFirstName().compareToIgnoreCase(f2.getFirstName());
        return cmp;
    }

}
