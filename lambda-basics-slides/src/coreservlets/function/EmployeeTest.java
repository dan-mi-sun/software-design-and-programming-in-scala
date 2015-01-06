package coreservlets.function;

import static coreservlets.function.EmployeeUtils.*;
import static coreservlets.function.FunctionUtils.*;
import java.util.*;
import java.util.function.*;

public class EmployeeTest {
  private static final List<Employee> employees = EmployeeSamples.getSampleEmployees();
  private static final String[] firstNames = { "Archie", "Amy", "Andy" };
  private static final Integer[] salaryCutoffs = { 200000, 300000, 400000 };
  private static final Integer[] ids = { 20, 21, 22 };
  
  public static void main(String[] args) {
    functionExamples();
    /*
    predicateExamples();
    functionExamples();
    consumerExamples();
    supplierExamples();
    binaryOperatorExamples();
    methodReferenceExamples();
    higherOrderFunctionExamples();
       */
  }
    
  /** Illustrates use of Predicate<T>. */
  
  public static void predicateExamples() {
    System.out.printf("%nPredicate Examples%n");
    System.out.println("Testing first names (approach 1)");
    for(String firstName: firstNames) {
      printResult(firstName, findEmployeeByFirstName(employees, firstName));
    }
    System.out.println("Testing salaries (approach 1)");
    for(double cutoff: salaryCutoffs) {
      printResult(cutoff, findEmployeeBySalary(employees, cutoff));
    }
    System.out.println("Testing first names (approach 2)");
    for(String firstName: firstNames) {
      printResult(firstName, findEmployeeWithFirstName(employees, firstName));
    }
    System.out.println("Testing salaries (approach 2)");
    for(double cutoff: salaryCutoffs) {
      printResult(cutoff, findEmployeeWithSalary(employees, cutoff));
    }
    System.out.println("Testing employee IDs (direct lambdas)");
    for(double id: ids) {
      printResult(id, firstMatch(employees, e -> e.getEmployeeId() == id));
    }
    System.out.println("All employees with salaries above $100K");
    System.out.println(allMatches(employees, e -> e.getSalary() > 100000));
  }
  
  /** Illustrates use of Function<T,R> and BiFunction<T,U,R>. */
  
  public static void functionExamples() {
    System.out.printf("%nFunction and BiFunction Examples%n");
    System.out.println("All first names (explicit lambda):");
    System.out.println(transform(employees, e -> e.getFirstName()));
    System.out.println("All first names (method reference):");
    System.out.println(transform(employees, Employee::getFirstName));
    System.out.printf("Annual payroll: $%,d.%n", sum(transform(employees, Employee::getSalary)));
    System.out.println("Testing first names (both approaches)");
    doTests(employees, firstNames, EmployeeUtils::findEmployeeByFirstName, "First match for first name=%s: %s%n");
    doTests(employees, firstNames, EmployeeUtils::findEmployeeWithFirstName, "First match for first name=%s: %s%n");
    System.out.println("Testing salaries (both approaches)");
    doTests(employees, salaryCutoffs, EmployeeUtils::findEmployeeBySalary, "First match for salary=$%,d: %s%n");
    doTests(employees, salaryCutoffs, EmployeeUtils::findEmployeeWithSalary, "First match for salary=$%,d: %s%n");
    System.out.println("Testing employee IDs (direct lambdas)");
    doTests(employees, ids, (people, id) -> firstMatch(people, p -> p.getEmployeeId() == id), "First match for id=%s: %s%n");
    System.out.printf("Annual payroll [via salarySum]: $%,d.%n", salarySum(employees));
    System.out.printf("Annual payroll [via mapSum]   : $%,d.%n", mapSum(employees, Employee::getSalary));
    System.out.printf("Sum of employee IDs: %,d.%n", mapSum(employees, Employee::getEmployeeId));
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
    System.out.printf("Sum of nums 1-5: %,d.%n", mapSum(nums));
  }
  
  /** Illustrates use of Consumer<T>. */
  
  public static void consumerExamples() {
    System.out.printf("%nConsumer Examples%n");
    System.out.println("Printing all employees via processEntries:");
    processEntries(employees, System.out::println);
    System.out.println("Printing salaries via processEntries:");
    processEntries(employees, e -> System.out.printf("Salary of %s is $%,d%n", e.getFirstName(), e.getSalary()));
  }
  
  /** Illustrates use of Supplier<T>. */
  
  public static void supplierExamples() {
    System.out.printf("%nSupplier Examples%n");
    for(int i=0; i<10; i++) {
      System.out.printf("Random person: %s.%n", EmployeeUtils.randomPerson());
    }
  }
  
  /** Illustrates use of BinaryOperator<T>. */
  
  public static void binaryOperatorExamples() {
    System.out.printf("%nBinaryOperator Examples%n");
    List<Integer> nums = Arrays.asList(1, 2, 3, 4);
    int sum = collect(nums, Integer::sum, 0); // Also stored as "sum2" method
    System.out.printf("Sum of %s is %s.%n", nums, sum);
    List<String> letters = Arrays.asList("a", "b", "c", "d");
    String concatenation = collect(letters, String::concat, "");  // Also see new String.join method
    System.out.printf("Concatenation of %s is %s.%n", letters, concatenation);
    List<Double> moreNums = Arrays.asList(1.2, -2.3, 4.5, -5.6);
    double biggest = collect(moreNums, Double::max, Double.MIN_VALUE);
    System.out.printf("Max of %s is %s.%n", moreNums, biggest);
  }
  
  /** Illustrates the different types of method and constructor references. */
  
  public static void methodReferenceExamples() {
    List<Integer> mixedNums = Arrays.asList(1, -1, 2, -2);
    List<Integer> positiveNums = transform(mixedNums, Math::abs);
    System.out.println("Positive nums [via Class::staticMethod]: " + positiveNums);
    List<String> names = Arrays.asList("Joe", "John", "Jane");
    String test = "PREFIX:";
    List<String> mangledNames = transform(names, test::concat);
    System.out.println("Mangled names [via variable::instanceMethod]: " + mangledNames);
    List<String> upperCaseNames = transform(names, String::toUpperCase);
    System.out.println("Uppercase names [via Class::instanceMethod]: " + upperCaseNames);
    Supplier<Person> maker1 = () -> new Person("John", "Doe");
    Supplier<Person> maker2 = Person::new;
    System.out.printf("Person [via lambda for Supplier]: %s.%n", maker1.get());
    System.out.printf("Person [via constructor ref for Supplier]: %s.%n", maker2.get());
  }

  public static void higherOrderFunctionExamples() {
    // Predicate
    System.out.printf("%nExamples of composing functions and functions that return functions%n");
    Predicate<Employee> isRich = e -> e.getSalary() > 200000;
    Predicate<Employee> isEarly = e -> e.getEmployeeId() <= 10;
    System.out.printf("Rich employees: %s.%n", allMatches(employees, isRich));
    System.out.printf("Employees hired early: %s.%n", allMatches(employees, isEarly));
    System.out.printf("Employees that are rich AND hired early: %s.%n", allMatches(employees, isRich.and(isEarly)));
    System.out.printf("Employees that are rich OR hired early: %s.%n", allMatches(employees, isRich.or(isEarly)));
    System.out.printf("Employees that are NOT rich: %s.%n", allMatches(employees, isRich.negate()));
    Employee polly = employees.get(1);
    Predicate<Employee> isPolly = Predicate.isEqual(polly);
    System.out.printf("Employees in list that are 'equals' to Polly Programmer: %s.%n", allMatches(employees, isPolly));
    
    // Function
    List<Double> nums = Arrays.asList(2.0, 4.0, 6.0, 8.0);
    System.out.printf("Original nums:  %s.%n", nums);
    Function<Double,Double> square = x -> x * x;
    Function<Double,Double> half = x -> x / 2;
    System.out.printf("square.compose(half): %s.%n", transform(nums, square.compose(half)));
    System.out.printf("square.andThen(half): %s.%n", transform(nums, square.andThen(half)));
    System.out.printf("half.andThen(square): %s.%n", transform(nums, half.andThen(square)));
    System.out.printf("square.compose(half) by transform2: %s.%n", transform2(nums, square, half));
    System.out.printf("identity: %s.%n", transform(nums, Function.identity()));
    Function<Double,Double> round = Math::rint;
    System.out.printf("round of square roots: %s.%n", transform(nums, round.compose(Math::sqrt)));
    // BUT, illegal to do Math::rint.compose(Math::sqrt).
    
    
    // Consumer
          // Don't use "employees" array because the operations below modify the salaries
    List<Employee> myEmployees = Arrays.asList(new Employee("Bill", "Gates", 1, 200000),
                                               new Employee("Larry", "Ellison", 2, 100000)); 
    System.out.println("Original employees:");
    processEntries(myEmployees, System.out::println);
    Consumer<Employee> giveRaise = e -> e.setSalary(e.getSalary() * 11 / 10);
    System.out.println("Employees after raise:");
    processEntries(myEmployees, giveRaise.andThen(System.out::println));
    
    // Custom operations: method and Function that return Predicate
    List<Employee> mediumRichEmployees1 = allMatches(employees, buildIsRichPredicate(150000));
    System.out.printf("Medium rich employees [via method that returns Predicate]: %s.%n", mediumRichEmployees1);
    Function<Integer, Predicate<Employee>> makeIsRichPredicate = salaryLowerBound -> (e -> e.getSalary() > salaryLowerBound);
    List<Employee> mediumRichEmployees2 = allMatches(employees, makeIsRichPredicate.apply(150000));
    System.out.printf("Medium rich employees [via Function that returns Predicate]: %s.%n", mediumRichEmployees2);
  }

  private EmployeeTest() {} // Uninstantiatable class
}
