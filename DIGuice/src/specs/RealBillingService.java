package specs;

public class RealBillingService implements BillingService {
	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
		CreditCardProcessor processor = new PaypalCreditCardProcessor();
		TransactionLog transactionLog = new DatabaseTransactionLog();

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
}