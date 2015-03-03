import com.google.inject.AbstractModule;
import register.LenientRegistrar;
import spec.Registrar;
import spec.StudentStore;
import store.DummyStudentStore;

public class SimpleModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(StudentStore.class).to(DummyStudentStore.class);

        bind(Registrar.class).to(LenientRegistrar.class);
    }

}
