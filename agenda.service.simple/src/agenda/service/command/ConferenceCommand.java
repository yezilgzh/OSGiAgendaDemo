package agenda.service.command;

import org.apache.felix.service.command.CommandProcessor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import agenda.api.AgendaService;

@Component(property = {
		CommandProcessor.COMMAND_SCOPE + ":String=agenda",
		CommandProcessor.COMMAND_FUNCTION + ":String=listConf"
	},
	service=Object.class
)
public class ConferenceCommand {

	private volatile AgendaService m_agendaService;
	
	@Reference
	public void setAgendaService(AgendaService agendaService){
		this.m_agendaService = agendaService;
	}
		
	public String listConf(){
		return m_agendaService.listConferences().toString();
	}
	
}
