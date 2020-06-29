package lab0;

/**
 * @author Evgeny Borisov
 */
public class Person {


    private final static int MAX_AGE=120;

    private String name;
    private int age;


    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > MAX_AGE) {
            throw new IllegalStateException("age is not in valid range. age =  " + age);

        } else {
            this.age = age;
        }
    }

    public void printMyAge() {
        System.out.println("age = " + age);
    }
}
