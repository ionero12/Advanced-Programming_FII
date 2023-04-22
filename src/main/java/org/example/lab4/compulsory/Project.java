package lab4.compulsory;

/**
 * Clasa Project are un singur atribut: name.
 * Am implementat constructorii, getterele si setterele necesare si metoda compareTo.
 **/
public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Project other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}