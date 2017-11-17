package rogeriogentil.data.structures.chapter03.reinforcement;

/**
 *
 * @author Rogerio J. Gentil
 */
public class PseudoRandom {

    private double current;
    private final int a = 12;
    private final int b = 5;
    private final int n = 100;

    public PseudoRandom(long seed) {
        this.current = seed;
    }

    public double next() {
        double next = (a * current + b) % n;
        this.current = next;
        return next;
    }
}
