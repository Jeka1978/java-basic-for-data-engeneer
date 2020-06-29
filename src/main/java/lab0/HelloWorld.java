package lab0;

/**
 * @author Evgeny Borisov
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello Smadar!");
        Person person1 = new Person();
        Person person2 = new Person();


        int numberOfPeople;


        person1.setAge(12);
        person2.setAge(22);
        if (person1.getAge() < 1) {
            System.out.println();
            System.out.println();
            System.out.println();
        }


        PersonService personService = new PersonService();


        personService.printMaturityStatus(person1);
        personService.printMaturityStatus(person2);


    }
}
