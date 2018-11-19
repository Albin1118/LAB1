import org.junit.*;

import static org.junit.Assert.*;

public class Set_Test_member {

    Set_Improved set = new Set_Improved();
    //Set set = new Set();

    /**
     * Checking if an empty set contains any int will return false
     */
    @Test
    public void set_test_member_part1(){
        int x = 5;

        assertFalse(set.member(x)); //if the set is empty the for-loop will be entered, returning false
    }

    /**
         * Checking if an int is a member of a set containing one larger int will return false
     */
    @Test
    public void set_test_member_part2(){
        int x = 10;
        int y = 5;

        set.insert(x);

        assertFalse(set.member(y)); //enters the for-loop, if (a.get(i) > x) returns false
    }

    /**
     * Checking if an int is a member of a set containing that int will return true
     */
    @Test
    public void set_test_member_part3(){
        int x = 5;
        set.insert(x);

        assertTrue(set.member(x)); //enters the for-loop, else (a.get(i)==x) returns true
    }

    /**
     * Checking if an int is a member of a set containing one smaller int returns false
     */
    @Test
    public void set_test_member_part4(){
        int x = 5;
        int y = 10;
        set.insert(x);

        assertFalse(set.member(y)); //enters the for-loop, then exits the loop and returns false
    }

    /**
     * Checks if a member can be found among other ints
     */
    @Test
    public void set_test_member_extraTest(){
        int x = 5;
        int y = 10;
        int z = 15;
        set.insert(x);
        set.insert(y);
        set.insert(z);

        assertTrue(set.member(y));
    }


    /**
     * Checks that an int that is not part of a set will make the method return false
     */
    @Test
    public void set_test_member_extraTest2(){
        int x = 5;
        int y = 10;
        int z = 15;
        set.insert(x);
        set.insert(y);
        set.insert(z);

        int isNotMember = 12;
        assertFalse(set.member(isNotMember));
    }




}
