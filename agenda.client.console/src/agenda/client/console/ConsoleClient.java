package agenda.client.console;

import java.util.List;

import agenda.api.AgendaService;
import agenda.api.Conference;

public class ConsoleClient {

	private volatile AgendaService m_agendaService;
	
	public void start() {
		List<Conference> conferences = m_agendaService.listConferences();
		for (Conference conference : conferences) {
			System.out.println(conference);
		}
	}
	
}
