package impl;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import service1.Service1;
import service2.Service2;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {

		ServiceImpl serviceImpl = new ServiceImpl();
		
		manager.add(createComponent()
				.setInterface(Service1.class.getName(), null)
				.setImplementation(serviceImpl));
		
		manager.add(createComponent()
				.setInterface(Service2.class.getName(), null)
				.setImplementation(serviceImpl));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
