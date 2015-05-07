package org.amdatu.configurator.test;

import org.amdatu.configurator.Configurator;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.log.LogService;

public class Activator extends DependencyActivatorBase {


	@Override
	public void init(BundleContext context, DependencyManager dm)
			throws Exception {
		
		dm.add(createComponent().setImplementation(ConfigurationTest.class)
				.add(createServiceDependency().setService(ConfigurationAdmin.class).setRequired(true))
				.add(createServiceDependency().setService(Configurator.class).setRequired(true)));
		
	}

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
	}
	
}
