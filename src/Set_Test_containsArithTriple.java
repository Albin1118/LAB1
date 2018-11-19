import org.junit.*;

import static org.junit.Assert.*;

public class Set_Test_containsArithTriple {

    Set_Improved set = new Set_Improved();
    //Set set1 = new Set();


    /**
     * If the set is empty the method will return false
     */
    @Test
    public void set_test_containsArithTriple_part1(){
        int x = 1;
        int y = 2;
        int z = 3;

        assertFalse(set.containsArithTriple());
    }

    /**
     * If the set contains an arithTriple it returns true
     */
    @Test
    public void set_test_containsArithTriple_part2(){
        int x = 1;
        int y = 2;
        int z = 3;

        set.insert(x);set.insert(y);set.insert(z);

        assertTrue(set.containsArithTriple());
    }

    /**
     * If the set doesn't contain an arithTriple it returns false
     */
    @Test
    public void set_test_containsArithTriple_part3(){
        int x = 1;
        int y = 5;
        int z = 10;

        set.insert(x);set.insert(y);set.insert(z);

        assertFalse(set.containsArithTriple());
    }


}
