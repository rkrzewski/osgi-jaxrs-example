package test.support;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.BundleTrackerCustomizer;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;

@Component
public class JaxRsConnectorStarterComponent {

	protected static final String NAME = "com.eclipsesource.jaxrs";
	
	private BundleTracker tracker;
	
	@Activate
	public void start(BundleContext context) {
		tracker = new BundleTracker(context, Bundle.STARTING, new BundleTrackerCustomizer() {
			@Override
			public Object addingBundle(Bundle bundle, BundleEvent event) {
				if(bundle.getSymbolicName().startsWith(NAME) && bundle.getState() < Bundle.ACTIVE) {
					try {
						bundle.start();
					} catch (BundleException e) {
						e.printStackTrace();
					}
					return bundle;
				}
				return null;
			}

			@Override
			public void modifiedBundle(Bundle bundle, BundleEvent event,
					Object object) {
			}

			@Override
			public void removedBundle(Bundle bundle, BundleEvent event,
					Object object) {
			}
		});
		tracker.open();
	}
	
	@Deactivate
	public void stop()
	{
		tracker.close();
	}
}
