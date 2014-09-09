package agenda.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import agenda.api.AgendaService;
import agenda.api.Conference;

@Path("agenda")
public class AgendaResource {

	private volatile AgendaService m_agendaService;
	private ObjectMapper m_mapper;
	
	public AgendaResource() {
		m_mapper = new ObjectMapper();
	}
	
	@GET @Path("conference")
	@Produces(MediaType.APPLICATION_JSON)
	public String listConferences() throws Exception {
		
		List<Conference> conferences = m_agendaService.listConferences();
		String result = m_mapper.writeValueAsString(conferences);
		
		return result;
		
	}
	
}