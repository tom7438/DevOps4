package datastruct;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class MyUnsortedListTest {

    @Test
    public void testIsEmpty() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertTrue(list.isEmpty());
        list = MyUnsortedList.of(1, 5, 8, 5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals(0, list.size());
        list = MyUnsortedList.of(1, 5, 8, 5);
        assertEquals(4, list.size());
        list = MyUnsortedList.of(1, 5);
        assertEquals(2, list.size());
    }

    @Test
    public void testPreprend() {
        int expected = 10;
        int first = 1;
        MyUnsortedList<Integer> list = MyUnsortedList.of(first, 2, 3);
        list.prepend(expected);
        int value = list.pop();
        assertEquals(expected, value);
    }

    @Test
    public void testAppend() {
        int expected = 10;
        int last = 3;
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, last);
        list.append(expected);
        int value = list.popLast();
        assertEquals(expected, value);
    }

    @Test
    public void testPop() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        int value = list.pop();
        assertEquals(1, value);
        assertEquals(2, list.size());
    }

    @Test(expected = EmptyListException.class)
    public void testPopEmpty() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.pop();
    }

    @Test
    public void testPopLast() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3);
        int value = list.popLast();
        assertEquals(3, value);
        assertEquals(2, list.size());
    }

    @Test(expected = EmptyListException.class)
    public void testPopLastEmpty() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.popLast();
    }

    @Test
    public void testInsert() {
        int expected = 10;
        int index = 2;
        MyUnsortedList<Integer> list = MyUnsortedList.of(1, 2, 15);
        list.insert(expected, index);
        int value = list.remove(index);
        assertEquals(expected, value);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertEmpty() {
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        list.insert(15, 10);
    }

    @Test
    public void testInsertRandom() {
        Random rand = new Random();
        MyUnsortedList<Integer> list = MyUnsortedList.of();
        for(int i = 0; i < 100; i++) {
            list.prepend(rand.nextInt(-1000, 1000));
        }

        for(int i = 0; i < 100; i++) {
            int index = rand.nextInt(list.size());
            int expected = rand.nextInt(-1000, 1000);

            list.insert(expected, index);
            int value = list.remove(index);

            assertEquals(expected, value);
        }

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNotExisting() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(5, 2, 6, 8, 7);
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNotExisting2() {
        MyUnsortedList<Integer> list = MyUnsortedList.of(5, 2, 6, 8, 7);
        list.remove(100);
    }

    @Test
    public void testListsEquals() {
        MyUnsortedList<String> l1 = MyUnsortedList.of("2");
        MyUnsortedList<String> l2 = MyUnsortedList.of("2");

        assertEquals(l1, l2);
    }

    @Test
    public void testListsNotEquals() {
        MyUnsortedList<Integer> l1 = MyUnsortedList.of(5, 2);
        MyUnsortedList<Integer> l2 = MyUnsortedList.of(5, 3);
        assertNotEquals(l1, l2);
    }
}
