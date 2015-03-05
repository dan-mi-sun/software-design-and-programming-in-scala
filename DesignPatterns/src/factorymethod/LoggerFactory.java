package factorymethod;

public abstract class LoggerFactory {
    public abstract Logger getLogger();

    public static LoggerFactory getFactory(String f) throws Exception {
        return (LoggerFactory) Class.forName(f).newInstance();
    }
}
