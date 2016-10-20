package jp2016.dp.iterator;

import java.util.Iterator;

public class IteratorTester {

    public static void main(String[] args) {

        EvenNumberIterator evenNumIterator = new EvenNumberIterator(40);

        while (evenNumIterator.hasNext()) {
            System.out.println(evenNumIterator.next());
        }

        EvenNumberIterable evenNumIterable = new EvenNumberIterable(40);

        for (int x : evenNumIterable) {
            System.out.println(x);
        }
    }

}

class EvenNumberIterator implements Iterator<Integer> {

    private int currentNum;
    private int limit;

    public EvenNumberIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return (currentNum < limit);
    }

    @Override
    public Integer next() {
        int next = currentNum;
        currentNum += 2;
        return next;
    }

}

class EvenNumberIterable implements Iterable<Integer> {
    private int limit;

    public EvenNumberIterable(int limit) {
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new EvenNumberIterator(limit);
    }

}