package contructors;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class Soldier {
    private String name = "John";
    private int power;


    {
        System.out.println("New soldier was created");
    }




    public Soldier() {
        initSoldierPower();
    }

    public Soldier(String name) {
        this.name = name;

        initSoldierPower();
    }


    public Soldier(String name, int power) {
        this.name = name;
        this.power = power;

    }

    private void initSoldierPower() {
        Random random = new Random();
        int randomPower = random.nextInt(100);
        this.power = randomPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
