package agenda.service.simple;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

import agenda.api.AgendaService;
import agenda.api.Conference;


@Component(
		property = RemoteConstants.SERVICE_EXPORTED_INTERFACES + ":String=" + "agenda.api.AgendaService" // SimpleAgendaService.SERVICENAME;	
)
public class SimpleAgendaService implements AgendaService {

//	public static final String SERVICENAME = AgendaService.class.getName();
	
	private List<Conference> m_conferences = new CopyOnWriteArrayList<Conference>();
	private volatile LogService m_logService;
	
	@Reference
	public void setLogService(LogService logService){
		this.m_logService = logService;
	}
	
	@Activate
	public void start() {
		addConference(new Conference("Java One", "San Francisco"));
		addConference(new Conference("Devoxx", "Antwerp"));
	}
	
	@Override
	public List<Conference> listConferences() {
		return m_conferences;
	}

	@Override
	public void addConference(Conference conference) {
		m_logService.log(LogService.LOG_INFO, "adding conference");
		m_conferences.add(conference);
	}

}

