class Tokeneer_Test {
    method Main() {
        var id := 114;
        var enrollmentStn := new EnrollmentStn.Init();
        var token := enrollmentStn.enroll(id, 2);
        var IDStnLow := new IDStn.Init(1);
        var IDStnMedium := new IDStn.Init(2);
        var IDStnHigh := new IDStn.Init(3);
        IDStnLow.open(id, token);
        assert IDStnLow.doorOpen;
    }
}
