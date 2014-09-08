package agenda.client.rest;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import agenda.api.AgendaService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		
		manager.add(createComponent().setInterface(Object.class.getName(), null).setImplementation(AgendaResource.class)
				.add(createServiceDependency().setService(AgendaService.class).setRequired(true)));
		
	}
	
	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception {
	}

}
