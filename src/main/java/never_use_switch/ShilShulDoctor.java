package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class ShilShulDoctor implements Doctor {
    @Override
    public void treat() {
        System.out.println("++++++++++");
        System.out.println("go to toilet");
    }
}
