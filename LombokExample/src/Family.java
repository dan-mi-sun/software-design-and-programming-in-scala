import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
public class Family {
	@Getter @Setter @NonNull
    private List<Person> members;
}
