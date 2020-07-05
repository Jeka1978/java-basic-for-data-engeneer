package never_use_switch;

import lab0.Person;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class TestHospital {
    public static void main(String[] args) {




        HospitalService hospitalService = new HospitalService();

        hospitalService.treat("daleket enaim");

        System.out.println("the end");


    }
}
