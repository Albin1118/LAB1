class Token {
    var fingerprint : int;
    var clearance : int;
    var valid : bool;

    method Init(init_fingerprint : int, init_clearance : int)
        modifies this;
        requires init_fingerprint != 0;
        requires 1 <= init_clearance <=3;
        ensures fingerprint == init_fingerprint;
        ensures clearance == init_clearance;
        ensures valid == true;
    {
        fingerprint := init_fingerprint;
        clearance := init_clearance;
        valid := true;
    }

    method invalidate()
        modifies this`valid;
        ensures !valid;
    {
        valid := false;
    }
}
