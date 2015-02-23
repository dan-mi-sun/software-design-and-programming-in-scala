import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Data()
@EqualsAndHashCode(callSuper=true,exclude={"address","city","state","zip"})
@ToString(callSuper=true)
public class Person extends SentientBeing {
    enum Gender { Male, Female }

    @NonNull private String name;
    @NonNull private final Gender gender;
    
    private String ssn;
    private String address;
    private String city;
    private String state;
    private String zip;
}
