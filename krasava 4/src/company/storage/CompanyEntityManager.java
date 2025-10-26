package company.storage;

import company.empoloyees.Employee;
import company.projects.Project;
import java.util.*;

/**
 * Manages storage and retrieval of company entities.
 * Demonstrates package-private methods and encapsulation.
 */
class CompanyEntityManager {
    private final Map<String, Employee> employees = new HashMap<>();
    private final Map<String, Project> projects = new HashMap<>();
    
    // Package-private constructor - only classes in the same package can create instances
    CompanyEntityManager() {}
    
    // Package-private methods for employee management
    void addEmployee(Employee employee) {
        validateEmployee(employee);
        employees.put(employee.getEmployeeId(), employee);
    }
    
    Employee findEmployee(String employeeId) {
        return employees.get(employeeId);
    }
    
    Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
    
    // Package-private methods for project management
    void addProject(Project project) {
        validateProject(project);
        projects.put(project.getId(), project);
    }
    
    Project findProject(String projectId) {
        return projects.get(projectId);
    }
    
    Collection<Project> getAllProjects() {
        return Collections.unmodifiableCollection(projects.values());
    }
    
    // Private validation methods
    private void validateEmployee(Employee employee) {
        Objects.requireNonNull(employee, "Employee cannot be null");
        if (employees.containsKey(employee.getEmployeeId())) {
            throw new IllegalArgumentException("Employee with ID " + employee.getEmployeeId() + " already exists");
        }
    }
    
    private void validateProject(Project project) {
        Objects.requireNonNull(project, "Project cannot be null");
        if (projects.containsKey(project.getId())) {
            throw new IllegalArgumentException("Project with ID " + project.getId() + " already exists");
        }
    }
}