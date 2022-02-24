package bankingProject;

import java.util.Scanner;

public class Atm extends BankingRules implements StandardProcess {
	Scanner sc = new Scanner(System.in);

	PersonalDetails details;

	public void setAtmDetails(PersonalDetails details) {
		this.details = details;
	}

	@Override
	public boolean userIdentification() {
		int pinNumber = sc.nextInt();// prompt for pin#
		if (details.getPinNumber() == pinNumber) {
			return true;
		}
		return false;
	}

	@Override
	public void deposit() {
		System.out.println("Please Enter The Deposit Amount");
		PersonalDetails.balance = PersonalDetails.balance + sc.nextInt();

	}

	@Override
	public void withdraw() {
		System.out.println("Please Enter The Amount To be Withdrawn");
		int amount = sc.nextInt();
		if (amount <= PersonalDetails.balance) {
			if (dailyWithdrawlLimit(amount)) {
			System.out.println("Withdrawl Successful for the amount of: " + amount);
			PersonalDetails.balance = PersonalDetails.balance - amount;
			amountWithdrawnPerday=amountWithdrawnPerday+amount;
			}else System.out.println("Exceeds daily Withdrwal limit of 2000.00CAD");
		} else
			System.out.println("Insufficient Balance.");
	}

	@Override
	public void fundTransfer() {// Not a functionality of ATM

	}

	@Override
	public void investment() {// Not a functionality of ATM

	}

}
