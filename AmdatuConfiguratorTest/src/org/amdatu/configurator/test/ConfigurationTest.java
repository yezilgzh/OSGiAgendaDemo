package org.amdatu.configurator.test;

import java.io.IOException;

import org.amdatu.configurator.Configurator;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class ConfigurationTest {
	
	private volatile Configurator m_configurator;
	private volatile ConfigurationAdmin m_configAdmin;
	
	public void start() throws IOException, InvalidSyntaxException{
		System.out.println("test " + System.getProperty("user.dir"));
		
		String[] provisioned = m_configurator.listProvisioned();
		for (String p : provisioned) {
			System.out.println("file: " + p);
		}
		
		Configuration[] configurations = m_configAdmin.listConfigurations(null);
		for (Configuration configuration : configurations) {
			System.out.println(configuration.getProperties().get("testKey"));
		}
	}
	
}
