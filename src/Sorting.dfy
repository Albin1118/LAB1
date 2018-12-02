
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

      // Let s be a sequence such that sorted(s). Prove that sorted2(s) by induction:
      //   Base:
      //     |s| <= 1 ==> sorted2(s).
      //   Step:
      //     Assume that sorted2(s[1..]). Prove that sorted2(s[0] + s[1..]):
      //       By definition of sorted(s) we know that (i == 0 && j == 1) ==> s[0] <= s[1],
      //       and because sorted2(s[1..]), we know that s[0] <= s[1] && sorted2(s[1..]) which means that sorted2(s).
      //   The step case together with the base case proves that sorted(s) ==> sorted2(s) for every sequence s.
      ghost method SortedEquivalence(s : seq<int>)
        requires sorted(s);
        ensures sorted2(s);
      {
      }

      // Let s be a sequence such that sorted2(s). Prove that sorted(s):
      //   If (|s| <= 1):
      //     sorted(s) is true because 0 <= i < j < |s| is false
      //   Else:
      //     By definition of sorted2(s) we know that:
      //       sorted2(s)
      //       <==> s[0] <= s[1] && sorted2(s[1..])
      //       <==> s[0] <= s[1] && s[1] <= s[2] && ... && s[|s|-2] <= s[|s|-1]
      //       <==> s[0] <= s[1] <= ... <= s[|s|-1]
      //       <==> forall i,j :: 0 <= i < j < |s| ==> s[i] <= s[j]
      //       <==> sorted(s)
      ghost method SortedEquivalence2(s : seq<int>)
        requires sorted2(s);
        ensures sorted(s);
      {
      }

      // the sequences a and b have the same elements (not considering order)
      predicate p(a : seq<int>, b : seq<int>)
      {
        multiset(a) == multiset(b)
      }

      // for all elements e in the sequences a or b, e occurs the same amount of times in a and b
      predicate p2(a : seq<int>, b : seq<int>)
      {
        forall i :: (i in a || i in b) ==> (occurrences(a, i) == occurrences(b, i))
      }

      // how many times x occurs in s
      function occurrences(s : seq<int>, x : int) : int
      {
        if |s| > 0 then occurrences(s[1..], x) + (if s[0] == x then 1 else 0) else 0
      }

      /* Dafny cannot prove these
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
      */

      /* 4a
      method sort(arr : array<int>)
        modifies arr;
        requires arr != null;
        requires arr.Length > 0;
        ensures sorted(arr[..]);
        ensures p(arr[..], old(arr[..]))
      {
        /*...*/
      }
      */

      // 4b
      method clear(arr : array<int>)
        modifies arr;
        requires arr != null;
        requires arr.Length > 0;
        ensures sorted(arr[..]);
      {
        var i : int := 0;
        while (i < arr.Length)
        invariant 0 <= i <= arr.Length;
        invariant forall j :: 0 <= j < i ==> arr[j] == 0;
        {
          arr[i] := 0;
          i := i + 1;
        }
      }
}
