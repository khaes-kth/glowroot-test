package explainer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SimpleClass sc = new SimpleClass();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            sc.isMoreThan(r.nextInt());
        }
    }
}
