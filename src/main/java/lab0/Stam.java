package lab0;

/**
 * @author Evgeny Borisov
 */
public class Stam {
    public static void main(String[] args) {


        int maxAge = Person.MAX_AGE;

        Person person1 = new Person();


        person1.setAge(20);
        person1.setName("Petrovich");


        int x= 10;
        int y = 10;

        System.out.println(y==x);


        Person person2 = new Person();
        person2.setAge(20);
        person2.setName("Petrovich");

        System.out.println(person1==person2);
        if (person1 == person2) {

        }

    }
}
