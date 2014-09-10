package agenda.client.console;

import java.util.List;

import agenda.api.AgendaService;
import agenda.api.Conference;

public class ConsoleClient {

	private volatile AgendaService m_agendaService;
	
	public void start() {
		if (m_agendaService == null) {
			return;
		}
		
		List<Conference> conferences = m_agendaService.listConferences();
		
		if (conferences != null) {
			for (Conference conference : conferences) {
				System.out.println(conference);
			}
		}
	}
	
}
