package jp2016.socialnet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class SocialNetworkImpl implements SocialNetwork {

    HashSet<Friend> friendSet = new HashSet<Friend>();

    public SocialNetworkImpl() {
    }

    @Override
    public void addFriend(Friend friend) {
        if (friend == null) {
            throw new IllegalArgumentException("null argument not accepted");
        }
        friendSet.add(friend);
    }

    @Override
    public Collection<Friend> findByCity(String city) {
        if (city == null) {
            throw new IllegalArgumentException("null argument not accepted");
        }
        List<Friend> resultList = new ArrayList<Friend>();
        for (Friend friend : friendSet) {
            if (friend.getCity().equals(city)) {
                resultList.add(friend);
            }
        }
        return resultList;
    }

    @Override
    public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("null argument not accepted");
        }
        for (Friend friend : friendSet) {
            if (friend.getFirstName().equals(firstName) && friend.getLastName().equals(lastName)) {
                return friend;
            }
        }
        throw new FriendNotFoundException(firstName, lastName);
    }

    @Override
    public int getNumberOfFriends() {
        return (friendSet == null) ? 0 : friendSet.size();
    }

    @Override
    public Collection<Friend> getOrderedFriends() {
        SortedSet<Friend> friendSetSorted = new TreeSet<Friend>(new FriendsComparator());
        friendSetSorted.addAll(friendSet);
        return friendSetSorted;
    }

}