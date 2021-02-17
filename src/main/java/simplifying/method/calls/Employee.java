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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public boolean isProfessionalService() {
        return !getRole().equals("Assoc");
    }

    public boolean isIdeal() {
        return getCurrentProject().equals("Beach") || getCurrentProject().isEmpty();
    }

    public boolean hasSomething(String skill) {
        return this.skills.contains(skill);
    }
}