package prac2;
/*
  14) Сортировка по сумме веса и возраста, фильтрация по весу кратно 5,
  выбор первых четырёх элементов, конкатенация имён через пробел
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(54, "Ivan", "Ivanov", LocalDate.of(1969, 1, 2), 81);
        Human human2 = new Human(42, "Dmitry", "Idkov", LocalDate.of(1981, 2, 4), 122);
        Human human3 = new Human(47, "Alexandr", "Workin", LocalDate.of(1976, 2, 17), 75);
        Human human4 = new Human(17, "Petya", "Black", LocalDate.of(2006, 2, 17), 65);
        Human human5 = new Human(15, "Yumeko", "Hanami", LocalDate.of(2008, 3, 11), 53);
        List<Human> humans = new ArrayList<Human>();
        humans.add(human1);
        humans.add(human2);
        humans.add(human3);
        humans.add(human4);
        humans.add(human5);
        System.out.println("до сортировки:");
        for (Human el: humans)
            System.out.println(el);
        Stream<Human> stream = humans.stream();
        System.out.println("после сортировки по весу + возрасту:");
        stream.sorted(Comparator.comparingInt(x -> x.age + x.weight)).forEach(System.out::println);
        stream = humans.stream();
        System.out.println("после фильтрации по весу кратности 5:");
        stream.filter(x -> x.weight % 5 == 0).forEach(System.out::println);
        stream = humans.stream();
        System.out.println("первые 4 элемента:");
        stream.filter(x -> humans.indexOf(x) < 4).forEach(System.out::println);
        System.out.println("конкантенация имен через пробел:");
        Optional<String> sum = Stream.of(human1.firstName, human2.firstName, human3.firstName, human4.firstName, human5.firstName).reduce((a, b) -> a + " " + b);
        System.out.println(sum);
    }
}
