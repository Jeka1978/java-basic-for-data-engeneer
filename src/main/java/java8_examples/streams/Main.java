package java8_examples.streams;

import lab0.Person;
import lombok_examples.Customer;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Main {

    public static void main(String[] args) {

        Stream.of(
                Customer.builder().age(15).name("Moshe").build(),
                Customer.builder().age(12).name("Shiasdasdasdma").build(),
                Customer.builder().age(12).name("Shima").build(),
                Customer.builder().age(12).name("Akinu").build())
                .map(Customer::getName)
                .sorted()
                .filter(s -> s.length()<10)
                .forEach(System.out::println);



    }

   static class PersonToNameMapper implements Function<Person,String> {

        @Override
        public String apply(Person person) {
            return person.getName();
        }
    }
}
