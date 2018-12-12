
    /* Question 1 Task 1:
     function fact(n : nat) : nat
     {
       if (n <= 1) then 1 else n * fact(n-1)
     }

     method ComputeFact(n : nat) returns (res : nat)
       requires n > 0;
       ensures res == fact(n);
      {
       res := 1;
       var i := 2;
       while (i <= n)
       decreases n - i + 1;
       invariant i <= n+1;
       invariant res == fact(i-1);
       {
         res := res * i;
         i := i + 1;
       }
      }
*/

     /* Question 1 Task 2:

//Total correctness:
wp(while B I D S, R) =
//1   I
//2   && (B && I ==> wp(S,I))
//3   && (!B && I ==> R)

//4   && (I ==> D >= 0)
//5   && (B && I ==>
       wp(tmp := D ; S, tmp > D))


//1	 (i <= n+1 ^ res == fact(i-1))
//2	^( (i <= n) ^ (i <= n+1 ^ res == fact(i-1)) ⇒
        wp(res := res * i; i := i + 1, (i <= n+1 ^ res == fact(i-1))) )
//3	^( (i > n) ^ (i <= n+1 ^ res == fact(i-1))==> res == fact(n)) )

//4	^( (i <= n+1 ^ res == fact(i-1)) ⇒ n-i+1 >= 0 )
//5	^( (i <= n) ^ (i <= n+1 ^ res == fact(i-1)) ⇒
        wp(tmp := n-i+1; res := res * i; i := i + 1, (tmp > n-i+1)) )

//Start by proving 2
(i <= n) ^ (i <= n+1 ^ res == fact(i-1)) ⇒
        wp(res := res * i; i := i + 1, (i <= n+1 ^ res == fact(i-1)))
//Solve the wp
//Sequential rule
wp(res := res * i, wp(i := i + 1, (i <= n+1 ^ res == fact(i-1))))
//Assignment rule
= wp(res := res * i, (i+1 <= n+1 ^ res == fact(i)))
//Assignment rule
= i+1 <= n+1 ^ res * i == fact(i)
//Simplify
= i <= n ^ res * i == fact(i)

(i <= n) ^ (i <= n+1 ^ res == fact(i-1)) ⇒
(i <= n) ^ (res * i == fact(i))
//Simplify
(res == fact(i-1)) ⇒
(res * i == fact(i))
//Simplify
fact(i-1)*i == fact(i) (true per definition of factorial)

//2 is true.

//Continue by proving 3
(i > n) ^ (i <= n+1 ^ res == fact(i-1))==> res == fact(n))
(i == (n+1)) ^ (res == fact(i-1))==> res == fact(n)
res == fact((n+1)-1) ⇒ res == fact(n)
res == fact(n) ⇒ res == fact(n) (trivially true)

//3 is true

//Continue by proving 4
(i <= n+1 ^ res == fact(i-1)) ⇒ n-i >= 0
i <= n+1 ⇒ n-i+1 >= 0
i <= n+1 ⇒ (n+1)-i >= 0 (if i==(n+1), (n+1)-i==0, else (n+1)-i>0
i <= n+1 ⇒ n-i+1 >= 0 (true)

//4 is true


//Continue by proving 5
(i <= n) ^ (i <= n+1 ^ res == fact(i-1)) ⇒
    wp(tmp := n-i+1; res := res * i; i := i + 1, (tmp > n-i+1))

//Solve the wp
//Sequential rule
wp(tmp := n-i+1; res := res * i, wp(i := i + 1, (tmp > n-i+1)))
//Assignment rule
wp(tmp := n-i+1; res := res * i, (tmp > n-(i + 1)+1))
//Sequential rule
wp(tmp := n-i+1, wp(res := res * i, (tmp > n-(i + 1)+1)))
//Assignment rule
wp(tmp := n-i+1,(tmp > n-(i + 1)+1))
//Assignment rule
n-i+1 > n-(i + 1)+1
//Simplify
n-i+1 > n-i (trivially true)

//5 is true

//All that is left is 1 which is the invariant
(i <= n+1 ^ res == fact(i-1))

//This means that if the invariant is true when entering the loop then the loop is correct. The loop is verified to be correct.



      */




