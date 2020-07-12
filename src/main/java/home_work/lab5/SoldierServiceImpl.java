package home_work.lab5;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class SoldierServiceImpl implements SoldierService {
    @Override
    public int maxAge(List<Soldier> soldiers) {

        int max = 0;

        for (Soldier soldier : soldiers) {
            if (soldier.getAge() > max) {
                max = soldier.getAge();
            }
        }


        return max;
    }

    @Override
    public double avgAge(List<Soldier> soldiers) {


        return ((double) this.sumAge(soldiers)) / soldiers.size();
    }

    @Override
    public int sumAge(List<Soldier> soldiers) {
        int totalAge = 0;


        for (Soldier soldier : soldiers) {
            totalAge += soldier.getAge();
        }

        return totalAge;
    }
}












