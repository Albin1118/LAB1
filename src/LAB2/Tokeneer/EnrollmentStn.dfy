class EnrollmentStn {
    var users : array<int>;

    predicate method containsUser(id : int)
        reads this`users, users;
    {
        exists i :: 0 <= i < users.Length && users[i] == id
    }

    method Init()
        modifies this;
        ensures fresh(users);
    {
        users := new int[10];
    }

    method enroll(fingerprint : int, clearance : int) returns (token : Token?)
        modifies this`users, users;
        requires users != null;
        requires fingerprint != 0;
        requires 1 <= clearance <= 3;
        ensures users.Length > 0;
        ensures containsUser(fingerprint);
        ensures old(containsUser(fingerprint)) ==> token == null;
        ensures old(!containsUser(fingerprint)) ==> token != null;
    {
        if (containsUser(fingerprint)) {
            token := null;
        } else {
            token := new Token.Init(fingerprint, clearance);

            var i := 0;
            while (i < users.Length && users[i] != 0)
                invariant 0 <= i <= users.Length;
                invariant forall j :: 0 <= j < i ==> users[j] != 0;
            { i := i + 1; }

            if (i == users.Length) { // reallocate
                var temp := new int[2*users.Length + 1];
                forall(j | 0 <= j < users.Length){
                    temp[j] := users[j];
                }
                users := temp;
            }
            users[i] := fingerprint;
        }
    }
}
