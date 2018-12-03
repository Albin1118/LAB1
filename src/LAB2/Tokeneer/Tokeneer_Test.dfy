class Tokeneer_Test {

    method open_success()
    {
        var enrollmentStn := new EnrollmentStn.Init();
        var IDStnLow := new IDStn.Init(1);
        var IDStnMedium := new IDStn.Init(2);
        var IDStnHigh := new IDStn.Init(3);

        var id := 114;
        var token := enrollmentStn.enroll(id, 2);
        assert token != null;
        assert !IDStnLow.doorOpen;
        assert IDStnLow.validToken(id, token);
        assert IDStnLow.validClearance(token);
        IDStnLow.open(id, token);
        assert IDStnLow.doorOpen;
    }

    method open_failure_LowClearance()
    {
        var enrollmentStn := new EnrollmentStn.Init();
        var IDStnLow := new IDStn.Init(1);
        var IDStnMedium := new IDStn.Init(2);
        var IDStnHigh := new IDStn.Init(3);

        var id := 114;
        var token := enrollmentStn.enroll(id, 1);
        assert token != null;
        assert !IDStnHigh.doorOpen;
        assert IDStnHigh.validToken(id, token);
        assert !IDStnHigh.validClearance(token);
        IDStnHigh.open(id, token);
        assert !IDStnHigh.doorOpen;
    }

    method open_failure_wrongToken()
    {
        var enrollmentStn := new EnrollmentStn.Init();
        var IDStnLow := new IDStn.Init(1);
        var IDStnMedium := new IDStn.Init(2);
        var IDStnHigh := new IDStn.Init(3);

        var id := 114;
        var id2 := 115;
        var token := enrollmentStn.enroll(id, 2);
        assert token != null;
        assert !IDStnLow.doorOpen;
        assert !IDStnLow.validToken(id2, token);
        assert IDStnLow.validClearance(token);
        IDStnLow.open(id2, token);
        assert !token.valid;
        assert IDStnLow.alarm;
        assert !IDStnLow.doorOpen;
    }

}
