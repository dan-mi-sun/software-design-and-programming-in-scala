package accountexamples

import accountexamples.AccountBalanceRetrieverFinal.AccountRetrievalTimeout
import akka.testkit.{TestProbe, ImplicitSender, TestKit}
import org.scalatest._
import akka.actor.{ActorSystem, Props}

import scala.concurrent.duration._

class Spec extends TestKit(ActorSystem("CameoTestAS")) with ImplicitSender with WordSpecLike with MustMatchers {
  val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "checkings")
  val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "money-markets")

  "An AccountBalanceRetriever" should {
    "return a list of account balances" in {
      val probe1 = TestProbe()
      val probe2 = TestProbe()
      val savingsAccountsProxy = system.actorOf(Props[SavingsAccountsProxyStub], "success-savings")
      val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "success-checkings")
      val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "success-money-markets")
      val accountBalanceRetriever = system.actorOf(Props(new AccountBalanceRetriever(savingsAccountsProxy, checkingAccountsProxy, moneyMarketAccountsProxy)), "retriever1")

      within(300 milliseconds) {
        probe1.send(accountBalanceRetriever, GetCustomerAccountBalances(1L))
        val result = probe1.expectMsgType[AccountBalances]
        result must equal(AccountBalances(Some(List((3, 15000.0))), Some(List((1, 150000.0), (2, 29000.0))), Some(List())))
      }
      within(300 milliseconds) {
        probe2.send(accountBalanceRetriever, GetCustomerAccountBalances(2L))
        val result = probe2.expectMsgType[AccountBalances]
        result must equal(AccountBalances(Some(List((6, 640000), (7, 1125000), (8, 40000))), Some(List((5, 80000))), Some(List((9, 640000), (10, 1125000), (11, 40000)))))
      }
    }

    "return a TimeoutException when timeout is exceeded" in {
      val savingsAccountsProxy = system.actorOf(Props[TimingOutSavingsAccountProxyStub], "timing-out-savings")
      val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "timing-out-checkings")
      val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "timing-out-money-markets")
      val accountBalanceRetriever = system.actorOf(Props(new AccountBalanceRetriever(savingsAccountsProxy, checkingAccountsProxy, moneyMarketAccountsProxy)), "timing-out-retriever")
      val probe = TestProbe()

      within(250 milliseconds, 500 milliseconds) {
        probe.send(accountBalanceRetriever, GetCustomerAccountBalances(1L))
        probe.expectMsg(AccountRetrievalTimeout)
      }
    }
  }
}
