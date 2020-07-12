package home_work.lab5;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface SoldierService {
    int maxAge(List<Soldier> soldiers);

    double avgAge(List<Soldier> soldiers);

    int sumAge(List<Soldier> soldiers);
}
