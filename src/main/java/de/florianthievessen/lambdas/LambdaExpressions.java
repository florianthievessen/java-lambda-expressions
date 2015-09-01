package de.florianthievessen.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressions {

	public static void main(String[] args) {

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Hans Wurst", Person.Sex.MALE, 18, "hanswurst@test.de"));
		people.add(new Person("Bla Blubb", Person.Sex.MALE, 28, "blablubb@test.de"));

		printPeopleWithPredicate(people,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		processPeople(people, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.printPerson());

		processPeopleWithFunction(people,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25, p -> p.getEmailAddress(),
				email -> System.out.println(email));

		processElements(people, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(), email -> System.out.println(email));

		people.stream().filter(p -> p.getAge() >= 18).map(p -> p.getName()).forEach(name -> System.out.println(name));
	}

	public static void printPeopleWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPeople(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static void processPeopleWithFunction(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
			Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

}
