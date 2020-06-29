package lab0;

/**
 * @author Evgeny Borisov
 */
public class PersonService {


    public void printMaturityStatus(Person person) {
        if (person.getAge() < 18) {
            System.out.println("not adult");
        } else {
            System.out.println("adult");
        }
    }
}
