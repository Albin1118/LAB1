
    /* Question 1 Task 1:
     Because they are immutable variables.
    */

     /* Question 1 Task 2:
     The method does multiplication of two integers. It should ensure that the value returned is (n0 * m0).
     ensures res == (n0 * m0);
    */

     /* Question 1 Task 3:
     wp(res := 0, if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0}
       while (0 < n)
         decreases n;
         invariant n >= 0;
         invariant res == n0*m0-n*m
         {res := res + m; n := n - 1}
     , res == (n0 * m0))

    //Firstly, because there are several statements, sequential calculus //is used.

    wp( res := 0, if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0},
    wp( while B I D S, R));

    //Next, prove total correctness for the while loop using while loop
    //calculus rule

    //Total correctness:
    wp(while B I D S, R) =
    //1   I
    //2   && (B && I ==> wp(S,I))
    //3   && (!B && I ==> R)

    //4   && (I ==> D >= 0)
    //5   && (B && I ==>
       wp(tmp := D ; S, tmp > D))



    //1	 (n >= 0 ^ res == n0*m0-n*m)
    //2	^( (0 < n) ^ (n >= 0 ^ res == n0*m0-n*m) ⇒
        wp(res := res + m; n := n-1, (n >= 0 ^ res == n0*m0-n*m) )
    //3	^( (n <=0) ^ (n >= 0 ^ res == n0*m0-n*m)==> res == (n0 * m0))

    //4	^( (n >= 0 ^ res == n0*m0-n*m) ⇒ n >= 0 )
    //5	^( (0 < n) ^ (n >= 0 ^ res == n0*m0-n*m) ⇒
        wp(tmp := n; res := res + m; n := n-1, (tmp > n)) )

    //Start by proving 2
    ((0 < n) ^ (n >= 0 ^ res == n0*m0-n*m) ⇒
            wp(res := res + m; n := n-1, (n >= 0 ^ res == n0*m0-n*m) )
    //Solve the wp
    //Sequential rule
    wp(res := res + m, wp(n := n-1, (n >= 0 ^ res == n0*m0-n*m))
    //Assignment rule
    =wp(res := res + m,(n-1 >= 0 ^ res == n0*m0-(n-1)*m))
    //Assignment rule
    =(n-1 >= 0 ^ (res + m) == n0*m0-(n-1)*m )
    //Simplify
    =(n-1 >= 0 ^ (res + m) == n0*m0-n*m+m)

    ((0 < n) ^ (n >= 0 ^ res == n0*m0-n*m)) ⇒ ((n-1) >= 0 ^ ((res + m) == n0*m0-n*m+m))
    //Simplify
    ((0 < n)	^ (res == n0*m0-n*m)) ⇒
    ((n-1) >= 0	^ (res + m == n0*m0-n*m+m))

    0 < n ⇒ (n-1) >= 0 ⇔ 0 < n ⇒ n >= 1 ⇔ 0 < n ⇒ 0 < n (trivially true)
    (res == n0*m0-n*m) ⇒ (res + m) == n0*m0-n*m+m) ⇔ (n0*m0-n*m) + m == n0*m0-n*m+m (true)

    //2 is true.

    //Continue by proving 3
    (n <=0) ^ (n >= 0 ^ res == n0*m0-n*m) ==> res == (n0 * m0)
    (n = 0) ^ res == (n0*m0-n*m) ⇒ res == (n0 * m0)
    (n = 0) ^ res == (n0*m0-0*m) ⇒ res == (n0 * m0)
    (n = 0) ^ res == (n0*m0) ⇒ res == (n0 * m0) (trivially true)

    //3 is also true.

    //Continue by proving 4
    ( (n >= 0 ^ res == n0*m0-n*m) ⇒ n >= 0 )
    ( (n >= 0) ⇒ (n >= 0) )(trivially true)

    //4 is also true

    //Continue by proving 5
    (0 < n) ^ (n >= 0 ^ res == n0*m0-n*m) ⇒
        wp(tmp := n; res := res + m; n := n-1, (tmp > n))

    //Solve the wp
    //Sequential rule
    wp(tmp := n; res := res + m, wp(n := n-1, tmp > n))
    //Assignment rule
    wp(tmp := n; res := res + m, tmp > n-1)
    //Sequential rule
    wp(tmp := n, wp(res := res + m, tmp > n-1))
    //Assignment rule
    wp(tmp := n, tmp > n-1)
    //Assignment rule
    n > n-1 (trivially true)

    //5 is also true

    //All that is left is 1 which is the resulting wp
    n >= 0 ^ res == n0*m0-n*m

    //Back to the original
    wp( res := 0, if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0},
    wp( while B I D S, R));
    wp( res := 0, if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0},
        (n >= 0 ^ res == n0*m0-n*m));
	//Now use sequential rule
	wp( res := 0, wp(if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0},
      (n >= 0 ^ res == n0*m0-n*m) ) );
	//Now conditional rule - solve inner wp
	wp(if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0},
      (n >= 0 ^ res == n0*m0-n*m) )
	= (n0 >= 0) ⇒ wp(n := n0,m := m0,(n >= 0 ^ res == n0*m0-n*m))
	  ^ (n0 < 0) => wp(n := -n0,m := -m0,(n >= 0 ^ res == n0*m0-n*m)
	= (A ^ B)* (Using abbreviations for substatements to make it simpler)

	//First solve A
	A = (n0 >= 0) ⇒ wp(n := n0,m := m0,(n >= 0 ^ res == n0*m0-n*m))
	//Use sequential rule
	A = (n0 >= 0) ⇒ wp(n := n0, wp(m := m0,(n >= 0 ^ res == n0*m0-n*m)))
	//Assignment rule
	A = (n0 >= 0) ⇒ wp(n := n0, n >= 0 ^ res == n0*m0-n*m0)))
	//Assignment rule
	A = (n0 >= 0) ⇒ n0 >= 0 ^ res == n0*m0-n0*m0)))
	//Simplify
	A = (n0 >= 0) ⇒ res == 0

    //Then solve B
	B = (n0 < 0) ⇒ wp(n := -n0,m := -m0,(n >= 0 ^ res == n0*m0-n*m)
	//Use sequential rule
	B = (n0 < 0) ⇒ wp(n := -n0, wp(m := -m0,(n >= 0 ^ res== n0*m0-n*m)))
	//Assignment rule
	B = (n0 < 0) ⇒ wp(n := -n0, n >= 0 ^ res == n0*m0-n*(-m0) )))
	//Assignment rule
	B = (n0 < 0) ⇒ -n0 >= 0 ^ res == n0*m0-(-n0)*(-m0) )))
	//Simplify
	B = (n0 < 0) ⇒ res == 0

	A ^ B = res == 0

	//Back to previous expression
	wp(if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0},
      (n >= 0 ^ res == n0*m0-n*m) ) = A ^ B = res == 0

    wp( res := 0, res == 0)
    //Assignment rule
    0 == 0 (which is true)

    The weakest precondition is true.

	Q ⇒ wp(res := 0, if (n0 >= 0) {n,m := n0, m0} else {n,m := -n0, -m0}
  			while (0 < n)
    			decreases n;
    		invariant n >= 0;
    		invariant res == n0*m0-n*m
    		{res := res + m; n := n - 1}
    , res == (n0 * m0))
    Q ⇒ true (the weakest precondition is met, and the method is verified)
*/






