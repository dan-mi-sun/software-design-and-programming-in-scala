package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clientfactory.RealBillingService;
import factory.CreditCardProcessorFactory;
import specs.BillingService;

public class RealBillingServiceTest {
	private final PizzaOrder order = new PizzaOrder(100);
	  private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

	  private final InMemoryTransactionLog transactionLog = new InMemoryTransactionLog();
	  private final FakeCreditCardProcessor processor = new FakeCreditCardProcessor();

	  @Before
	  public void setUp() {
	    TransactionLogFactory.setInstance(transactionLog);
	    CreditCardProcessorFactory.setInstance(processor);
	  }

	  @After
	  public void tearDown() {
	    TransactionLogFactory.setInstance(null);
	    CreditCardProcessorFactory.setInstance(null);
	  }

	  @Test
	  public void testSuccessfulCharge() {
	    BillingService billingService = new RealBillingService();
	    Receipt receipt = billingService.chargeOrder(order, creditCard);

	    assertTrue(receipt.hasSuccessfulCharge());
	    assertEquals(100, receipt.getAmountOfCharge());
	    assertEquals(creditCard, processor.getCardOfOnlyCharge());
	    assertEquals(100, processor.getAmountOfOnlyCharge());
	    assertTrue(transactionLog.wasSuccessLogged());
	  }
}
