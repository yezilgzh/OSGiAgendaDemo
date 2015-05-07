package test;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import service1.Service1;
import service2.Service2;

public class Activator extends DependencyActivatorBase {

	private volatile Service1 service1;
	private volatile Service2 service2;
	
	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {

		manager.add(createComponent()
				.setInterface(Object.class.getName(), null)
				.setImplementation(Test.class)
				.add(createServiceDependency()
						.setService(Service1.class).setRequired(true))
				.add(createServiceDependency()
						.setService(Service2.class).setRequired(true)));
		
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
