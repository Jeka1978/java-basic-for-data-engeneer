package contructors;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Soldier soldier = new Soldier("Vasya");


        Soldier soldier2 = new Soldier();

        Soldier sam = new Soldier("Sam", 130);


        System.out.println(soldier.getName());
        System.out.println(soldier.getPower());
        System.out.println(soldier2.getName());
        System.out.println(soldier2.getPower());

        System.out.println(sam.getName());
        System.out.println(sam.getPower());
    }
}
