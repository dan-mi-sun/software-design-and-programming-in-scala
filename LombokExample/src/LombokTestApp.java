import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Synchronized;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class LombokTestApp {
    public static void main(String[] args) {
        LombokTestApp app = new LombokTestApp();

        //Test @ToString
        System.out.println("***Testing @ToString***");
        app.testToString();

        //Test @EqualsAndHashCode
        System.out.println("\n\n***Testing @EqualsAndHashCode***");
        app.testEqualsAndHashCode();

        //Test @Cleanup
        System.out.println("\n\n***Testing @Cleanup***");
        app.testCleanup();

        //Test @SneakyThrows
        System.out.println("\n\n***Testing @SneakyThrows***");
        try {
            app.testSneakyThrows();
        } catch (Exception e) {
            System.out.println("We got an exception of type: " + e.getClass().getSimpleName());
        }

        //Test NonNull
        System.out.println("\n\n***Testing @NonNull***");
        app.testNonNull();

        //Test @Synchronized
        System.out.println("\n\n***Testing @Synchronized***");
        app.testSynchronized();
    }

    public void testToString() {
        System.out.println(buildPerson());
    }

    public void testEqualsAndHashCode() {
        Person personOne = buildPerson();
        Person personTwo = buildPerson();

        System.out.println(personOne);
        System.out.println("PersonOne hashcode: " + personOne.hashCode());
        System.out.println(personTwo);
        System.out.println("PersonTwo hashcode: " + personTwo.hashCode());
        if (personOne.equals(personOne)) {
            System.out.println("Thank goodness the same is the same.");
        }

        System.out.println(personOne);
        System.out.println("PersonOne hashcode: " + personOne.hashCode());
        System.out.println(personTwo);
        System.out.println("PersonTwo hashcode: " + personTwo.hashCode());
        if (personOne.equals(personTwo)) {
            System.out.println("Built the same is also the same.");
        }

        personTwo.setAddress("123 Some Other St.");
        System.out.println(personOne);
        System.out.println("PersonOne hashcode: " + personOne.hashCode());
        System.out.println(personTwo);
        System.out.println("PersonTwo hashcode: " + personTwo.hashCode());
        if (personOne.equals(personTwo)) {
            System.out.println("Excluded fields are ignored in the equals. So these are also the same.");
        }

        personTwo.setName("Joe");
        personTwo.setSsn("987654321");
        System.out.println(personOne);
        System.out.println("PersonOne hashcode: " + personOne.hashCode());
        System.out.println(personTwo);
        System.out.println("PersonTwo hashcode: " + personTwo.hashCode());
        if (personOne.equals(personTwo)) {
            System.out.println("These should not have been the same.");
        } else {
            System.out.println("Joe and Michael are no longer the same.");
        }

    }

    public void testCleanup() {
        try {
            @Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream() {
                @Override
                public void close() throws IOException {
                    super.close();
                    System.out.println("I've been closed!");
                }
            };
            baos.write(new byte[]{'Y', 'e', 's'});
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSynchronized() {
        Runnable runner = new Runnable() {
            public void run() {
                synchronized (                        $lock) {
                    System.out.println("Thread locked on $lock and sleeping for 5 seconds.  You should see the date output after the wait.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Done sleeping.");
                }
            }
        };
        new Thread(runner).start();

        // Make sure we don't outrun the new thread.
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        Date today = new Date();
        System.out.println("Main thread attempting to lock on $lock.");
        System.out.println(synchronizedFormat(today));
    }

    private DateFormat format = new SimpleDateFormat("MM-dd-yyyy");

    @Synchronized
    public String synchronizedFormat(Date date) {
        return format.format(date);
    }

    @SneakyThrows
    public void testSneakyThrows() {
        throw new IllegalAccessException();
    }

    public void testNonNull() {
        try {
            Person person = buildPerson();
            person.setName(null);
        } catch (NullPointerException npe) {
            System.out.println("Got the expected NPE, looks like @NonNull is working...");
        }
    }

    private Person buildPerson() {
        Person person = new Person("Michael", Person.Gender.Male);
        person.setDateOfBirth(new GregorianCalendar(1978, 3, 8).getTime());
        person.setAddress("1 Nunya Biznis St.");
        person.setCity("St. Louis");
        person.setState("MO");
        person.setZip("12345");
        person.setSsn("123456789");
        return person;
    }
}
