import lombok.ToString;

@ToString(callSuper=true,exclude="someExcludedField")
public class Foo extends Bar {
	private boolean someBoolean = true;
	private String someStringField;
	private float someExcludedField;
}
