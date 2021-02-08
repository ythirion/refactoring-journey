package simplifying.method.calls;

import java.util.List;
import java.util.UUID;

public class Employee {
    private final String id;
    private final String name;
    private final String role;
    private final String currentProject;
    private final List<String> skills;

    public Employee(String name, String role, String currentProject, List<String> basicSkills) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.role = role;
        this.currentProject = currentProject;
        this.skills = basicSkills;
    }

    public String get() {
        return id;
    }

    public String getN() {
        return name;
    }

    public String getR() {
        return role;
    }

    public String getP() {
        return currentProject;
    }

    public boolean isProfessionalService() {
        return !getR().equals("Assoc");
    }

    public boolean isIdeal() {
        return getP().equals("Beach") || getP().isEmpty();
    }

    public boolean hasSomething(String skill) {
        return this.skills.contains(skill);
    }
}