package impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import service1.Service1;
import service2.Service2;

public class ServiceImpl implements ServiceFactory, Service2 {

	@Override
	public Object getService(Bundle bundle, ServiceRegistration registration) {
		
		String[] objectClasses = (String[]) registration.getReference().getProperty(Constants.OBJECTCLASS);
		String objectClass = objectClasses[0];
		
		if (objectClass.equals(Service1.class.getName())) {
			return new Service1Impl();
		}
		
		if (objectClass.equals(Service2.class.getName())) {
			return this;
		}

		return this;
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration registration,
			Object service) {
		// TODO Auto-generated method stub
		
	}

}
