class IDStn {
    var securityLevel : int;
    var doorOpen : bool;
    var alarm : bool;

    predicate method validToken(id : int, token : Token)
        reads token`fingerprint, token`valid;
    {
        id == token.fingerprint && token.valid
    }

    predicate method validClearance(token : Token)
        reads this`securityLevel, token`clearance;
    {
        this.securityLevel <= token.clearance
    }

    method Init(init_securityLevel : int)
        modifies this;
        requires 1 <= init_securityLevel <= 3;
        ensures securityLevel == init_securityLevel;
        ensures doorOpen == false;
        ensures alarm == false;
    {
        securityLevel := init_securityLevel;
        doorOpen := false;
        alarm := false;
    }

    method open(id : int, token : Token)
        modifies this`doorOpen, this`alarm, token`valid;
        requires !doorOpen;
        ensures !validToken(id, token) ==> !token.valid && alarm;
        ensures old(validToken(id, token)) ==> token.valid;
        ensures old(validToken(id, token)) && validClearance(token) <==> doorOpen;
    {
        if (!validToken(id, token)) {
            token.invalidate();
            alarm := true;
        } else if (validClearance(token)) {
            doorOpen := true;
        }
    }

    method close()
        modifies this`doorOpen;
        ensures !doorOpen;
    {
        doorOpen := false;
    }
}
