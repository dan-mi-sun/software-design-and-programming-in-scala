import lombok.Data;

import java.util.List;

@Data(staticConstructor="of")
public class Company {
	private final Person founder;
	private String name;
	private List<Person> employees;
}
