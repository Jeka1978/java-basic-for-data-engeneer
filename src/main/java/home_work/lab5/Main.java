package home_work.lab5;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {


        SoldierService service = new SoldierServiceImpl();

        List<Soldier> soldiers = List.of(new Soldier(22), new Soldier(28), new Soldier(25));

        System.out.println(service.avgAge(soldiers));
        System.out.println(service.sumAge(soldiers));
        System.out.println(service.maxAge(soldiers));

    }
}
