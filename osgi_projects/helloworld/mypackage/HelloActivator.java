package mypackage;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloActivator implements BundleActivator {

	// Start the bundle
	public void start(BundleContext context) {
		System.out.println("Hello OSGi!");
	}

	// Stop the bundle
	public void stop(BundleContext context) {
		System.out.println("Goodbye OSGi!");
	}

}