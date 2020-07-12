package home_work.lab5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class SoldierServiceImplTest {




    private SoldierService service;

    private List<Soldier> soldiers;


    public SoldierServiceImplTest() throws Exception {
        soldiers = List.of(new Soldier(22), new Soldier(28), new Soldier(25));
        service = new SoldierServiceImpl();

    }

    @Test
    public void maxAge() {


        int x = service.maxAge(soldiers);

        Assert.assertEquals(28, x);

    }

    @Test
    public void avgAge() {
        double x = service.avgAge(soldiers);
        Assert.assertEquals(25,x,0);

    }

    @Test
    public void sumAge() {
        int x = service.sumAge(soldiers);
        Assert.assertEquals(75,x);

    }


}




