package agenda.itest;

import static agenda.itest.util.Configs.configs;
import static agenda.itest.util.Configs.frameworkConfig;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

import agenda.api.AgendaService;
import agenda.itest.util.Config;
import agenda.itest.util.FrameworkConfig;
import agenda.itest.util.FrameworkContext;

public class AgendaTestBase extends IntegrationTestBase {

//    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

	protected volatile ServiceReference<AgendaService> m_agendaServiceReference;
	protected volatile AgendaService m_agendaService;
	
	@Override
	protected Config[] configureFramework(FrameworkContext parent)
			throws Exception {

		BundleContext parentBC = getParentContext().getBundleContext();
        String systemPackages = parentBC.getProperty("itest.systempackages");
        String defaultBundles = parentBC.getProperty("itest.bundles.default");
        String agendaBundles = parentBC.getProperty("itest.bundles.agenda");

        parent.setLogLevel(LogService.LOG_DEBUG);
        parent.setServiceTimout(30000);

        FrameworkConfig child1 = frameworkConfig("CHILD1")
            .logLevel(LogService.LOG_DEBUG)
            .serviceTimeout(10000)
            .frameworkProperty(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA, systemPackages)
            .bundlePaths(defaultBundles, agendaBundles);

        return configs(child1);
	}

	@Override
	protected void configureServices() throws Exception {
		m_agendaServiceReference = getChildContext("CHILD1").getBundleContext().getServiceReference(AgendaService.class);
        for (int i = 0; i < 1000 && m_agendaService == null; i++) {
            Thread.sleep(10);
            m_agendaServiceReference = getChildContext("CHILD1").getBundleContext().getServiceReference(AgendaService.class);
        }
        assertNotNull("Unable to locate AgendaService reference", m_agendaServiceReference);
        
        Object test = getChildContext("CHILD1").getBundleContext().getService(m_agendaServiceReference);
        m_agendaService = (AgendaService) test; 
        assertNotNull("Unable to locate AgendaService service", m_agendaService);
	}

	@Override
	protected void cleanupTest() throws Exception {
        if (m_agendaServiceReference != null) {
            getChildContext("CHILD1").getBundleContext().ungetService(m_agendaServiceReference);
            m_agendaServiceReference = null;
        }
        m_agendaService = null;
	}

	
}
