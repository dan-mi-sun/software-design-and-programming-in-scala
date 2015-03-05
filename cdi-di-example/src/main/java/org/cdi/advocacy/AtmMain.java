package org.cdi.advocacy;

import org.jboss.weld.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.math.BigDecimal;

public class AtmMain {

	//static BeanContainer beanContainer =  BeanContainerManager.getInstance();

	public static void main(String[] args) throws Exception {
        Weld weld = new Weld();
        WeldContainer wc =weld.
        AutomatedTellerMachine atm = (AutomatedTellerMachine) beanContainer
				.getBeanByName("atm");

		//AutomatedTellerMachine atm = beanContainer.getBeanByType(AutomatedTellerMachine.class);
		atm.deposit(new BigDecimal("1.00"));

	}

}
