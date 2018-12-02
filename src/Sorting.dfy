
class Sorting{
      predicate sorted(s : seq<int>)
      {
        forall i,j :: 0 <= i < j < |s| ==> s[i] <= s[j]
      }

      predicate sorted2(s: seq<int>)
      {
        |s| > 1 ==> s[0] <= s[1] && sorted2(s[1..])
      }

      ghost method SortedShortSequences(s : seq<int>)
        requires |s| < 2;
        ensures sorted(s);
        ensures sorted2(s);
      {
      }

      ghost method SortedEquivalence(s : seq<int>)
        requires sorted(s);
        ensures sorted2(s);
      {
      }

      ghost method SortedEquivalence2(s : seq<int>)
        requires sorted2(s);
        ensures sorted(s);
      {
      }

      // a and b have the same elements (not considering order)
      predicate p(a : seq<int>, b : seq<int>)
      {
        multiset(a) == multiset(b)
      }

      // a and b have the same elements (not considering order)
      predicate p2(a : seq<int>, b : seq<int>)
      {
        forall i :: (i in a || i in b) ==> (occurrences(a, i) == occurrences(b, i))
      }

      // how many times x occurs in s
      function occurrences(s : seq<int>, x : int) : int
      {
        if |s| > 0 then occurrences(s[1..], x) + (if s[0] == x then 1 else 0) else 0
      }

      ghost method PEquivalence(a : seq<int>, b : seq<int>)
        requires p(a, b)
        ensures p2(a, b)
      {
      }

      ghost method PEquivalence2(a : seq<int>, b : seq<int>)
        requires p2(a, b)
        ensures p(a, b)
      {
      }
}
