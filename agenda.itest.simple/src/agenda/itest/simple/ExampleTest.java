package agenda.itest.simple;

import java.util.List;

import junit.framework.TestCase;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import agenda.api.AgendaService;
import agenda.api.Conference;

public class ExampleTest extends TestCase {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    public void testExample() throws Exception {
        
    	ServiceReference agendaServiceReference = context.getServiceReference(AgendaService.class.getName());
    	AgendaService agendaService = (AgendaService) context.getService(agendaServiceReference);
    	List<Conference> conferences = agendaService.listConferences();
    	
    	assertEquals("wrong nr of conferences", 2, conferences.size());
    	    	
    }
}
