package never_use_switch;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class HospitalService {


    private Map<String, Doctor> doctorMap;


    public HospitalService() {
        this.doctorMap = Map.of(
                "covid-19", new Covid19Doctor(),
                "nozelet", new NozeletDoctor(),
                "shil-shul", new ShilShulDoctor(),
                "daleket enaim", new EyesDoctor()

        );

    }


    public void treat(String disease) {

        Doctor doctor = doctorMap.get(disease);
        if (doctor == null) {
            System.out.println("we don't have doctor for this disease, treat yourself please");
        } else {

            doctor.treat();
        }


    }

}







