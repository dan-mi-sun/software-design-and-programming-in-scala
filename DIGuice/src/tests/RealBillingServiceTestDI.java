package tests;

import org.junit.Test;

import specs.BillingService;
import di.RealBillingService;

public class RealBillingServiceTestDI {
	private final PizzaOrder order = new PizzaOrder(100);
	  private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

	  private final InMemoryTransactionLog transactionLog = new InMemoryTransactionLog();
	  private final FakeCreditCardProcessor processor = new FakeCreditCardProcessor();

	  @Test
	  public void testSuccessfulCharge() {
	    BillingService billingService
	        = new RealBillingService(processor, transactionLog);
	    Receipt receipt = billingService.chargeOrder(order, creditCard);

	    assertTrue(receipt.hasSuccessfulCharge());
	    assertEquals(100, receipt.getAmountOfCharge());
	    assertEquals(creditCard, processor.getCardOfOnlyCharge());
	    assertEquals(100, processor.getAmountOfOnlyCharge());
	    assertTrue(transactionLog.wasSuccessLogged());
	  }
}