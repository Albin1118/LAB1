class Tokeneer_Test {
    method Main()
    {
        print "hello, Dafny\n";
        var id := 114;
        var enrollmentStn := new EnrollmentStn.Init();
        var token := enrollmentStn.enroll(id, 2);
        assert token != null;
        var IDStnLow := new IDStn.Init(1);
        var IDStnMedium := new IDStn.Init(2);
        var IDStnHigh := new IDStn.Init(3);
        assert !IDStnLow.doorOpen;
        assert IDStnLow.validToken(id, token);
        assert IDStnLow.validClearance(token);
        IDStnLow.open(id, token);
        assert IDStnLow.doorOpen;
    }
}
