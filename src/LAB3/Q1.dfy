
    /* Question 1 Task 1:
     multi-line comment
     span accross multiple
     lines */

     /* Question 1 Task 2:
     multi-line comment
     span accross multiple
     lines */

     /* Question 1 Task 3:
     multi-line comment
     span accross multiple
     lines */

     method Abs(x : int) returns (y : int)
       // return value doesn't deviate from intended value
       ensures 0 <= x ==> y == x;
       ensures x < 0 ==> y == -x;
        // return value is greater or equal to zero
       ensures 0 <= y;
     {
       if (x < 0)
        { y := -x; }
       else
        { y := x; }
     }


