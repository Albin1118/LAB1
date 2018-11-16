import org.junit.*;

import static org.junit.Assert.*;

public class Set_Test_insert {

    Set_Improved set = new Set_Improved();
    //Set set = new Set();

    /**
     * When adding an int to an empty set, the set will only contain the added int
     */
    @Test
    public void set_test_insert_part1(){
        int x = 5;
        int[]expected = {5};

        set.insert(x);
        int[]result = set.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     * If you try insert an int into a set containing a larger int, the result will be sorted
     */
    @Test
    public void set_test_insert_part2(){
        int x = 2;
        int y = 1;

        set.insert(x);
        set.insert(y);

        int[]expected = {1, 2};
        int[]result = set.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     * If you try insert an int into a set containing several other ints, the result will be sorted
     */
    @Test
    public void set_test_insert_part2_border1(){
        int x = 3;
        int y = 2;
        int z = 1;

        set.insert(x);
        set.insert(y);
        set.insert(z);

        int[]expected = {1, 2, 3};
        int[]result = set.toArray();

        assertArrayEquals(expected, result);
    }


    /**
     * If you try insert an int into a set containing several other ints, the result will be sorted
     */
    @Test
    public void set_test_insert_part2_border2(){
        int x = 4;
        int y = 3;
        int z = 2;
        int a = 1;


        set.insert(x);
        set.insert(y);
        set.insert(z);
        set.insert(a);

        int[]expected = {1, 2, 3, 4};
        int[]result = set.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     * If you try to insert a duplicate int, the set remains unchanged.
     */
    @Test
    public void set_test_insert_part3(){
        int x = 3;
        int y = 3;

        set.insert(x);
        set.insert(y);

        int[]expected = {3};
        int[]result = set.toArray();

        assertArrayEquals(expected, result);
    }

    @Test
    public void set_test_insert_part4(){
        int x = 5;
        int y = 10;

        set.insert(x);
        set.insert(y);

        int[]expected = {5, 10};
        int[]result = set.toArray();

        assertArrayEquals(expected, result);
    }
}
