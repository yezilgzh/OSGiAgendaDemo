package agenda.service.simple;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import agenda.api.AgendaService;
import agenda.api.Conference;

@Component
public class SimpleAgendaService implements AgendaService {

	private List<Conference> conferences = new CopyOnWriteArrayList<Conference>();
	private volatile LogService logService;
	
	@Reference
	public void setLogService(LogService logService){
		this.logService = logService;
	}
	
	@Activate
	public void start() {
		addConference(new Conference("Java One", "San Francisco"));
		addConference(new Conference("Devoxx", "Antwerp"));
	}
	
	@Override
	public List<Conference> listConferences() {
		return conferences;
	}

	@Override
	public void addConference(Conference conference) {
		logService.log(LogService.LOG_INFO, "adding conference");
		conferences.add(conference);
	}

}

