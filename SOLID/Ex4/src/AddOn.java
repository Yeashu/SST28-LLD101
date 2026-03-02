public enum AddOn {
    MESS(1000.0), LAUNDRY(500.0), GYM(300.0);

    public final double fee;
    AddOn(double fee) { this.fee = fee; }
}
