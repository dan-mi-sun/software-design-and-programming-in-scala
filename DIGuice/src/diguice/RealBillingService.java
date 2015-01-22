package diguice;

import specs.BillingService;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

public class RealBillingService implements BillingService {
	private final CreditCardProcessor processor;
	private final TransactionLog transactionLog;

	@Inject
	public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
		this.processor = processor;
		this.transactionLog = transactionLog;
	}

	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
		try {
			ChargeResult result = processor.charge(creditCard, order.getAmount());
			transactionLog.logChargeResult(result);

			return result.wasSuccessful() ? Receipt.forSuccessfulCharge(order.getAmount()) : Receipt
					.forDeclinedCharge(result.getDeclineMessage());
		} catch (UnreachableException e) {
			transactionLog.logConnectException(e);
			return Receipt.forSystemFailure(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		/*
	     * Guice.createInjector() takes your Modules, and returns a new Injector
	     * instance. Most applications will call this method exactly once, in their
	     * main() method.
	     */
	    Injector injector = Guice.createInjector(new BillingModule());
	    /*
	     * Now that we've got the injector, we can build objects.
	     */
	    BillingService billingService = injector.getInstance(BillingService.class);
	   // ...
	  }
}
