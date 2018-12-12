
    /* Question 1 Task 1:
    Because there is an else if statement, conditional calculus is used.

    wp( if B then S1 else S2, R);

    wp( if(x >= 0) then (y := x) else (y := -x), ((0 <= x) ==> y == x) ^ ((x < 0) ==> y == -x) ^ ( y >= 0) );
    wp( if(x >= 0) then (y := x) else (y := -x), R );

     */

     /* Question 1 Task 2:

     wp( if(x >= 0) then (y := x) else (y := -x), (0 <= x ==> y == x) ^ (x < 0 ==> y == -x) ^ ( y >= 0);
     wp( if(x >= 0) then (y := x) else (y := -x), R;

     //Use conditional rule
     = ((x >= 0) ==> wp( y := x, R)) ^ ((x < 0) ==> wp( y := -x, R));
     = (A ^ B)* (Using abbreviations for substatements to make it simpler)

     Solve A first
     A = (x >= 0) ==> wp( y := x, R);
     A = (x >= 0) ==> wp( y := x, ((0 <= x) ==> y == x) ^ ((x < 0) ==> y == -x) ^ ( y >= 0 ));
     //Use Assignment rule
     A = (x >= 0) ==> ((0 <= x) ==> x == x) ^ ((x < 0) ==> x == -x) ^ ( x >= 0 );
     A = T ==>( ( T ==> T) ^ ( F == > F ) ^ ( T ), A = T ==> (T^T^T), A = T
     A is true for all input, does not require preconditions

     Then solve B
     B = (x < 0) ==> wp( y := -x, R);
     B = (x < 0) ==> wp( y := -x, ((0 <= x) ==> y == x) ^ ((x < 0) ==> y == -x) ^ ( y >= 0));
     //Use assignment rule
     B = (x < 0) ==> ((0 <= x) ==> -x == x) ^ ((x < 0) ==> -x == -x) ^ ( -x >= 0);
     B = T ==>( (F ==> F) ^ ( T ==> T) ^ ( T ) ), B = T ==> (T^T^T), B = T
     B is true for all inputs, does not require preconditions

     //Continue from A^B
     *(A ^ B) = T ^ T = T
     wp( if(x >= 0) then (y := x) else (y := -x), R) = T
     The weakest precondition is always met. It it true. Therefore there is no need for any preconditions in the method.

     */

     /* Question 1 Task 3:

     Firstly, as a function the code can be made simpler. But most importantly, methods cannot be used in
     other functions or in the specification of another method. Therefore, implementing it as a method makes it
     harder to reuse. If made into a function, or a function method, it would be possible to use it in
     other functions or in the specification of other methods.

     */

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

     function abs(x : int) : int
     {
       if x < 0 then -x else x
     }


