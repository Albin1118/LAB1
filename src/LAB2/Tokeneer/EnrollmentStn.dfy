class EnrollmentStn {
    var users : array<int>;

    predicate usersFull()
        reads this`users, users;
    {
        forall i :: 0 <= i < users.Length ==> users[i] != 0
    }

    predicate method containsUser(id : int)
        reads this`users, users;
    {
        exists i :: 0 <= i < users.Length && users[i] == id
    }

    method Init()
        modifies this;
        ensures fresh(users);
        ensures forall i :: 0 <= i < users.Length ==> users[i] == 0;
    {
        users := new int[10];
        forall(i | 0 <= i < users.Length) {
            users[i] := 0;
        }
    }


    method InitWithUser(fingerprint : int, clearance : int) returns (token : Token)
        modifies this;
        requires fingerprint > 0;
        requires 1<=clearance<=3
        ensures fresh(users);
        ensures users.Length == 10;
        ensures users[0] == fingerprint;
        ensures forall i :: 1 <= i < users.Length ==> users[i] == 0;
        ensures fresh(token);
    {
        users := new int[10];
        users[0] := fingerprint;
        forall(i | 1 <= i < users.Length) {
            users[i] := 0;
        }
        token := new Token.Init(fingerprint, clearance);
    }

    method enroll(fingerprint : int, clearance : int) returns (token : Token?)
        modifies this`users, users;
        requires fingerprint != 0;
        requires 1 <= clearance <= 3;
        ensures users.Length > 0;
        ensures containsUser(fingerprint);
        ensures old(containsUser(fingerprint)) <==> token == null;
        ensures old(!containsUser(fingerprint)) ==>
            fresh(token) &&
            token.fingerprint == fingerprint && token.clearance == clearance && token.valid == true &&
            (old(usersFull()) ==> fresh(users));
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
