package never_use_switch;

/**
 * @author Evgeny Borisov
 */
public class NozeletDoctor implements Doctor {
    @Override
    public void treat() {
        System.out.println("******** apchi!");
        System.out.println("lets run algorithem which treats from noselet");
    }
}
