package app;

public class IdGenerator {
    private int incr = 10000;

    public IdGenerator() {};

    public int generateId() {
        incr += 1;
        return incr;
    }
}
