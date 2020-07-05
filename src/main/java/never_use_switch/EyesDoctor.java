package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class EyesDoctor implements Doctor {

    @Override
    public void treat() {
        System.out.println("AAAAAAAAAAAAAAAA");
        System.out.println("your eyes are fixed!");
    }
}
