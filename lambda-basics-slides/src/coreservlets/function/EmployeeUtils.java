package coreservlets.function;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static coreservlets.function.FunctionUtils.firstMatch;

public class EmployeeUtils {

    /**
     * Returns the first employee from the List that has the given first name. Returns null
     * if no matches are found. Note that if would be better to return Optional;
     * Optional will be discussed in later tutorial section.
     */
    public static Employee findEmployeeByFirstName(List<Employee> employees,
                                                   String firstName) {
        for (Employee e : employees) {
            if (e.getFirstName().equals(firstName)) {
                return (e);
            }
        }
        return (null);
    }

    /**
     * Returns the first employee from the list that has a salary greater than
     * or equal to the specified salary cutoff. Returns null
     * if no matches are found.
     */
    public static Employee findEmployeeBySalary(List<Employee> employees,
                                                double salaryCutoff) {
        for (Employee e : employees) {
            if (e.getSalary() >= salaryCutoff) {
                return (e);
            }
        }
        return (null);
    }

    /**
     * Returns first Employee from list that passes the match function.
     * See LambdaUtils.firstMatch for a generalized version of this method.
     */

    public static Employee firstMatchingEmployee(List<Employee> candidates,
                                                 Predicate<Employee> matchFunction) {
        for (Employee possibleMatch : candidates) {
            if (matchFunction.test(possibleMatch)) {
                return (possibleMatch);
            }
        }
        return (null);
    }

    /**
     * Variation of findEmployeeByFirstName that uses genericized version
     * (firstMatch) of matching method.
     */
    public static Employee findEmployeeWithFirstName(List<Employee> employees,
                                                     String firstName) {
        return (firstMatch(employees, e -> e.getFirstName().equals(firstName)));
    }

    /**
     * Variation of findEmployeeBySalary that uses genericized version
     * (firstMatch) of matching method.
     */
    public static Employee findEmployeeWithSalary(List<Employee> employees,
                                                  double salaryCutoff) {
        return (firstMatch(employees, e -> e.getSalary() > salaryCutoff));
    }

    public static Predicate<Employee> buildIsRichPredicate(double salaryLowerBound) {
        return (e -> e.getSalary() > salaryLowerBound);
    }


    private final static Supplier[] peopleGenerators =
            {Person::new, Writer::new, Artist::new, Consultant::new,
                    EmployeeSamples::randomEmployee,
                    () -> {
                        Writer w = new Writer();
                        w.setFirstName("Ernest");
                        w.setLastName("Hemingway");
                        w.setBookType(Writer.BookType.FICTION);
                        return (w);
                    }
            };

    public static Person randomPerson() {
        Supplier<Person> generator = RandomUtils.randomElement(peopleGenerators);
        return (generator.get());
    }

    /**
     * Computes the sum of the salary of the given employees.
     * See FunctionUtils.mapSum for a genericized version of this method.
     */

    public static int salarySum(List<Employee> employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return (sum);
    }

    private EmployeeUtils() {
    } // Uninstantiatable class; static methods only
}
