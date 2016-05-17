package org.jboss.amqconnector;

import java.awt.Rectangle;

import org.jboss.brmspojos.Department;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieProcessor {
	
	
	private static KieSession kSession;

	public static KieSession getKieSession() {
		KieServices ks = KieServices.Factory.get();

		KieContainer kieContainer = ks.getKieClasspathContainer();

		KieBaseConfiguration config = ks.newKieBaseConfiguration();
		config.setOption(EventProcessingOption.STREAM);
		KieBase kieBase = kieContainer.newKieBase(config);
		// KieSession kieSession = kieContainer.newKieSession();
		kSession = kieBase.newKieSession();
		kSession = insertDepartments();

		return kSession;
	}

	public static KieSession insertDepartments() {

		Rectangle deptLocationOne = new Rectangle(0, 0, 1, 2);
		Rectangle deptLocationTwo = new Rectangle(1, 2, 3, 5);
		Rectangle deptLocationThree = new Rectangle(2, 3, 2, 4);
		Rectangle deptLocationFour = new Rectangle(3, 4, 5, 4);
		Rectangle deptLocationFive = new Rectangle(4, 4, 3, 5);
		Rectangle deptLocationSix = new Rectangle(5, 4, 2, 4);
		
       
		 
		Department deptOne = new Department("PHARMACY", deptLocationOne,
				Department.SPECIAL);
		Department deptTwo = new Department("FOOD", deptLocationTwo,
				Department.SPECIAL);
		Department deptThree = new Department("CLOTHING", deptLocationThree,
				Department.REGULAR);
		Department deptFour = new Department("TOYS", deptLocationFour,
				Department.REGULAR);
		Department deptFive = new Department("STATIONARY", deptLocationFive,
				Department.REGULAR);
		Department deptSix = new Department("JEWELRY", deptLocationSix,
				Department.REGULAR);

		kSession.insert(deptOne);
		kSession.insert(deptTwo);
		kSession.insert(deptThree);
		kSession.insert(deptFour);
		kSession.insert(deptFive);
		kSession.insert(deptSix);

		return kSession;

	}
	


}
