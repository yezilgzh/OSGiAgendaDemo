package agenda.service.command;

import org.apache.felix.service.command.CommandProcessor;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import agenda.api.AgendaService;

@Component(properties =	{
		/* Felix GoGo Shell Commands */
		CommandProcessor.COMMAND_SCOPE + ":String=agenda",
		CommandProcessor.COMMAND_FUNCTION + ":String=listConf"
	},
	provide = Object.class
)
public class ConferenceCommand {

	private volatile AgendaService agendaService;
	
	@Reference
	public void setAgendaService(AgendaService agendaService){
		this.agendaService = agendaService;
	}
		
	public String listConf(){
		return agendaService.listConferences().toString();
	}
	
}
