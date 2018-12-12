
   /* Question 2 Task 1:

    It is not verifiable because when the inputs x and y are equal,
    the outputs big and small will also be equal (i.e. !(big > small)).

    */

    /* Question 2 Task 2:

    Because there is an else if statement, conditional calculus is used.

    wp( if B then S1 else S2, R);
    wp( if(x > y) then (big := x; small := y) else (big := y; small := x), ( big > small ));

    (Using conditional rule)
    =(x > y) ⇒ wp(big := x; small := y, big > small)
    ^ (x <= y) ⇒ wp(big := y; small := x, big > small)
    = (A ^ B)* (Using abbreviations for substatements to make it simpler)

    Solve A first
    A = (x > y) ==> wp( big:= x; small := y, big > small);
    //Use sequential rule
    A = (x > y) ⇒ wp( big := x, wp( small := y, big > small) )
    //Use assignment rule
    A = (x > y) ⇒ wp( big := x, big > y)
    //Use assignment rule again
    A = (x > y) ⇒ x > y (trivially true)
    A is true for all input, does not require preconditions

    Then solve B
    B = (x <= y) ==> wp( big:= y; small := x, big > small);
    //Use sequential rule
    B = (x <= y) ⇒ wp( big := y, wp( small := x, big > small) )
    //Use assignment rule
    B = (x <= y) ⇒ wp( big := y, big > x)
    //Use assignment rule again
    B = (x <= y) ⇒ y > x
    //Simplify
    B = y == x ⇒ y > x (trivially false)

    (A ^ B) = T ^ F = F
    wp( if(x > y) then (big := x; small := y) else (big := y; small := x), ( big > small )) = F

    There was no previous precondition, it was always true.
    Q(nonexistent precondition) ⇒ wp,
    True ⇒ False(trivially false)
    The weakest precondition is not met, and therefore the method is not verified.


     */

     /* Question 2 Task 3:

     By adding "requires x != y" the method will be verifiable


     */

     /* Question 2 Task 4:
     By adding:

     ensures big >= small;
     or
     ensures x != y ⇒ big > small
     ensures x==y ⇒ big == small

     the method becomes verifiable.


     */





