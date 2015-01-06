package coreservlets.samples;

import coreservlets.integratable.MathUtils;

import javax.swing.JButton;
import java.awt.event.TextListener;
import java.io.Flushable;
import java.net.ContentHandler;
import java.net.ContentHandlerFactory;
import java.net.CookiePolicy;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LambdaSamples {
    private final String[] testStrings = {"one", "two", "three", "four"};
    private final Formatter fmt = new Formatter();
    private final JButton someButton = new JButton("Click Me");
    private final ExecutorService taskList = Executors.newFixedThreadPool(100);

    public void doSomeLambdas() {
        Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
        taskList.execute(() -> downloadSomeFile());
        someButton.addActionListener(event -> handleButtonClick());
        double d = MathUtils.integrate(x -> x * x, 0, 100, 1000);

        AutoCloseable c = () -> cleanupForTryWithResources();
        Thread.UncaughtExceptionHandler handler = (thread, exception) -> doSomethingAboutException();
        Formattable f = (formatter, flags, width, precision) -> makeFormattedString();
        ContentHandlerFactory fact = mimeType -> createContentHandlerForMimeType();
        CookiePolicy policy = (uri, cookie) -> decideIfCookieShouldBeAccepted();
        Flushable toilet = () -> writeBufferedOutputToStream();
        TextListener t = event -> respondToChangeInTextValue();
    }

    private void downloadSomeFile() {
    }

    private void handleButtonClick() {
    }

    private void cleanupForTryWithResources() {
    }

    private void doSomethingAboutException() {
    }

    private void makeFormattedString() {
    }

    private ContentHandler createContentHandlerForMimeType() {
        return (null);
    }

    private boolean decideIfCookieShouldBeAccepted() {
        return (false);
    }

    private void writeBufferedOutputToStream() {
    }

    private void respondToChangeInTextValue() {
    }
}
