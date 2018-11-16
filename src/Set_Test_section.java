import org.junit.*;

import static org.junit.Assert.*;

public class Set_Test_section {

    Set_Improved set1 = new Set_Improved();
    Set_Improved set2 = new Set_Improved();
    //Set set1 = new Set();
    //Set set2 = new Set();

    /**
     *
     */
    @Test
    public void set_test_section_part1(){
        int x = 1;
        int y = 2;
        int z = 3;

        set1.insert(x);
        set2.insert(x); set2.insert(y); set2.insert(z);

        set1.section(set2);

        int[] expected = {};
        int[] result = set1.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     *
     */
    @Test
    public void set_test_section_part2(){
        int x = 1;
        int y = 2;
        int z = 3;

        set1.insert(x);set1.insert(y);
        set2.insert(x);set2.insert(z);

        set1.section(set2);

        int[] expected = {2};
        int[] result = set1.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     *
     */
    @Test
    public void set_test_section_part3(){
        int x = 1;
        int y = 2;
        int z = 3;

        set1.insert(x);set1.insert(z);
        set2.insert(x);set2.insert(y);

        set1.section(set2);

        int[] expected = {3};
        int[] result = set1.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     *
     */
    @Test
    public void set_test_section_part4(){
        int x = 1;
        int y = 2;
        int z = 3;

        set1.insert(x);set1.insert(y);set1.insert(z);
        set2.insert(x);set2.insert(y);set2.insert(z);

        set1.section(set2);

        int[] expected = {};
        int[] result = set1.toArray();

        assertArrayEquals(expected, result);
    }

    /**
     * Trying to remove ints from an empty set does nothing
     */
    @Test
    public void set_test_section_part5(){
        int x = 1;
        int y = 2;
        int z = 3;

        set2.insert(x);set2.insert(y);set2.insert(z);

        set1.section(set2);

        int[] expected = {};
        int[] result = set1.toArray();

        assertArrayEquals(expected, result);
    }




}
