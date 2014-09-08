package agenda.client.console;

import java.util.List;

import agenda.api.AgendaService;
import agenda.api.Conference;

public class ConsoleClient {

	private volatile AgendaService agendaService;
	
	public void start() {
		List<Conference> conferences = agendaService.listConferences();
		for (Conference conference : conferences) {
			System.out.println(conference);
		}
	}
	
}
