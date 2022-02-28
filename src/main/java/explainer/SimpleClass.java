package explainer;

import java.util.Random;

public class SimpleClass {
    private Random r = new Random();
    private int field = r.nextInt();

    public Boolean isMoreThan(Integer limit) {
        field = r.nextInt(Math.abs(field * field));
        return field > limit;
    }
}
