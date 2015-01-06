package coreservlets.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EmployeeSamples {
    private static Employee[] sampleEmployees = {
            new Employee("Harry", "Hacker", 1, 234567),
            new Employee("Polly", "Programmer", 2, 333333),
            new Employee("Cody", "Coder", 8, 199999),
            new Employee("Devan", "Developer", 11, 175000),
            new Employee("Desi", "Designer", 14, 212000),
            new Employee("Archie", "Architect", 16, 144444),
            new Employee("Tammy", "Tester", 19, 166777),
            new Employee("Sammy", "Sales", 21, 45000),
            new Employee("Larry", "Lawyer", 22, 33000),
            new Employee("Amy", "Accountant", 25, 85000)
    };

    public static List<Employee> getSampleEmployees() {
        return (Arrays.asList(sampleEmployees));
    }

    public static Employee randomEmployee() {
        return (RandomUtils.randomElement(sampleEmployees));
    }

    private static Employee[] googlers = {
            new Employee("Larry", "Page", 1, 9999999),
            new Employee("Sergey", "Brin", 2, 8888888),
            new Employee("Eric", "Schmidt", 3, 7777777),
            new Employee("Nikesh", "Arora", 4, 6666666),
            new Employee("David", "Drummond", 5, 5555555),
            new Employee("Patrick", "Pichette", 6, 4444444),
            new Employee("Susan", "Wojcicki", 7, 3333333),
            new Employee("Peter", "Norvig", 8, 900000),
            new Employee("Jeffrey", "Dean", 9, 800000),
            new Employee("Sanjay", "Ghemawat", 10, 700000),
            new Employee("Gilad", "Bracha", 11, 600000)
    };

    public static List<Employee> getGooglers() {
        return (Arrays.asList(googlers));
    }

    private static Map<Integer, Employee> googleMap = new HashMap<>();

    static {
        // Switch back with later Java version? Synchronize?
        //Stream.of(googlers).parallel().forEach(e -> googleMap.put(e.getEmployeeId(), e));
        Stream.of(googlers).forEach(e -> googleMap.put(e.getEmployeeId(), e));
    }

    public static Employee findGoogler(Integer employeeId) {
        // Turn on print statement to verify lazy evaluation in "combinedExamples" of StreamSamples
        //System.out.println("Called findGooglers with id=" + employeeId);
        return (googleMap.get(employeeId));
    }

    private EmployeeSamples() {
    } // Uninstantiatable class
}
