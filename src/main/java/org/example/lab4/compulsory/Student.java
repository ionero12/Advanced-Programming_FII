package lab4.compulsory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clasa Student are 2 atribute: name si admissibleProjects (care contine proiectele pe care le vrea)
 * Am implementat constructorii, getterele si setterele necesare si metoda compareTo.
 **/
public class Student implements Comparable<Student> {
    private String name;
    private Set<Project> admissibleProjects;

    public Student(String name) {
        this.name = name;
        this.admissibleProjects = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAdmissibleProjects(Set<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    public void addAdmissibleProjects(Project project) {
        this.admissibleProjects.add(project);
    }

    public int compareTo(Student other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
