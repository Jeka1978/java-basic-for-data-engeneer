package lab0;

/**
 * @author Evgeny Borisov
 */
public class HelloWorld {
    public static void main(String[] args) {


        int x = 0;

        for (String arg : args) {
            if (x == 10) {
                System.out.println(123);
                continue;
            }
            System.out.println(456);
        }

    }
}
