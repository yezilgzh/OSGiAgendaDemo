package agenda.service.simple;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

import agenda.api.AgendaService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		
        Properties props = new Properties();
        props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, AgendaService.class.getName());

		manager.add(createComponent().setInterface(AgendaService.class.getName(), props).setImplementation(SimpleAgendaService.class)
				.add(createServiceDependency().setService(LogService.class)));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception {
		
		
	}

}
