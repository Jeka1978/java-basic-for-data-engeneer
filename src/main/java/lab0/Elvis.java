package lab0;

/**
 * @author Evgeny Borisov
 */
public class Elvis {
    private String name;


    public  void f(String[] args) {
        int x = args.length == 0 ? 0 : args.length * 2;

        System.out.println(x);
    }
}
