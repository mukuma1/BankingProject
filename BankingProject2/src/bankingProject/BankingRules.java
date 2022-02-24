package bankingProject;

public abstract class BankingRules {
	int amountWithdrawnPerday = 0;
	int dailyWithdrawlLimit=2000;

	public abstract boolean userIdentification();

	public boolean dailyWithdrawlLimit(int amount) {
		if (amount > dailyWithdrawlLimit || (amountWithdrawnPerday + amount) > dailyWithdrawlLimit) {
			return false;
		}
		return true;
	}

	public void dailyTransactionLimit() {
		// unlimited transcations
	}

	public void pinChangeProcess() {
		// pin must contain atleast 4 digit
	}

}
