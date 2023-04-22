package lab4.homework;

import lab4.compulsory.Project;
import lab4.compulsory.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProjectAllocation {
    List<Student> students;
    List<Project> projects;
    Map<Student, Set<Project>> preferences;

    public ProjectAllocation(List<Student> students, List<Project> projects) {
        this.students = new ArrayList<>(students);
        this.projects = new ArrayList<>(projects);
        this.preferences = new HashMap<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setPreferences() {
        for(Student student: students){
            Random random = new Random();
            int random_val = random.nextInt(students.size());
            Set<Project> uniquePreferences = IntStream.rangeClosed(1, random_val)
                    .mapToObj(i -> projects.get(random.nextInt(1,10)))
                    .collect(Collectors.toSet());
            student.setAdmissibleProjects(uniquePreferences);
            preferences.put(student,uniquePreferences);
        }
    }
    public void getStudentsWithFewerPreferences() {
        double averagePreferences = students.stream().mapToInt(s -> preferences.get(s).size()).average().orElse(0);
        List<Student> studentsWithFewerPreferences = students.stream()
                .filter(s -> preferences.get(s).size() < averagePreferences)
                .sorted()
                .toList();
        System.out.println("Students with fewer preferences than average (" + averagePreferences + "):");
        System.out.println(studentsWithFewerPreferences);
    }

    public void findMatchGreedy() {
        Map<Student, Project> matches = new HashMap<>();
        Set<Project> assignedProjects = new HashSet<>();
        for (Map.Entry<Student, Set<Project>> entry : preferences.entrySet()) {
            Student student = entry.getKey();
            for (Project project : entry.getValue()) {
                if (!assignedProjects.contains(project)) {
                    matches.put(student, project);
                    assignedProjects.add(project);
                    break;
                }
            }
        }
        System.out.println(matches);
    }
}
