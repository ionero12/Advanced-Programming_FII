package lab4.compulsory;

import lab4.homework.ProjectAllocation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

/**
 * In clasa Main se creeaza 3 obiecte de tip Student si 3 obiecte de tip Project. Obiectele Student sunt sortate
 * si apoi afisate, iar cele de tip Project sunt direct afisate (pentru ca TreeSet urile sunt deja sortate).
 */
public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        //creare studenti cu nume random
        var students = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);

        //sortare studenti in functie de nume
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.addAll(Arrays.asList(students));
        Collections.sort(listOfStudents,
                Comparator.comparing(Student::getName));
        System.out.println(listOfStudents);
        System.out.println();

        //creare proiecte cu nume random
        var projects = IntStream.rangeClosed(0, 100)
                .mapToObj(i -> new Project(faker.name().username()))
                .toArray(Project[]::new);
        List<Project> listOfProjects = new ArrayList<>();
        listOfProjects.addAll(Arrays.asList(projects));

        ProjectAllocation p1 = new ProjectAllocation(listOfStudents, listOfProjects);
        p1.setPreferences();

        //afisare studenti cu nr de preferinte mai mic decat media
        p1.getStudentsWithFewerPreferences();
        System.out.println();

        //afisare matching
        p1.findMatchGreedy();
    }
}