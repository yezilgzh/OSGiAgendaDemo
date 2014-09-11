package agenda.itest;

import java.util.List;

import agenda.api.Conference;

public class AgendaTest extends AgendaTestBase {

    public void testAgenda() throws Exception {
        List<Conference> conferences = m_agendaService.listConferences();
        assertEquals("Nr of initail conferences is not 2", 2,  conferences.size());
    }

}
