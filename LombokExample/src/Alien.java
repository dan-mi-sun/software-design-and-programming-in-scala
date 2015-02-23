import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper=true)
public class Alien extends SentientBeing {
	public final String planetOfOrigin;
}
