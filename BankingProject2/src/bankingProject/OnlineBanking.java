package bankingProject;

import java.util.Scanner;

public class OnlineBanking extends BankingRules implements StandardProcess {
	Scanner sc = new Scanner(System.in);

	PersonalDetails details;//composition

	public void setOnlinebankingDetails(PersonalDetails details) {
		this.details = details;
	}

	@Override
	public boolean userIdentification() {
		System.out.println("Please enter the User Name");
		String userName = sc.next();
		System.out.println("Please enter the password");
		String password = sc.next();
		if (details.getUserName().equals(userName) && details.getPassword().equals(password)) {
			return true;
			
		}
		return false;
	}

	@Override
	public void deposit() {// Not a functionality of OB

	}

	@Override
	public void withdraw() {// Not a functionality of OB

	}

	@Override
	public void fundTransfer() {
		System.out.println(
				"Please select the account from which the fund needs to be transferred:\nChequing Account\nPlease select the account to which the fund needs to be transferred:\nCreditCard\nAdd a bill payee\nAdd an interac e-transfer recipient");
		System.out.println("Please Enter The Amount");
		int amount = sc.nextInt();
		if (amount <= PersonalDetails.getBalance()) {
			System.out.println("Fund transferred sucessfully for the amount of: " + amount);
			PersonalDetails.balance = PersonalDetails.balance - amount;
		} else
			System.out.println("Insufficient Balance.");
	}

	@Override
	public void investment() {// TFSA Savings Deposit
		System.out.println("Please Select \nContribute\nWithdraw");
		if (sc.next().equalsIgnoreCase("contribute")) {
			System.out.println("Enter Contribution Amount");
			int amount = sc.nextInt();
			System.out.println("Choose the account from which contribution need to be made\nChequing Account");
			if (amount <= PersonalDetails.getBalance()) {
				System.out.println("Contribution made sucessfully for the amount of: " + amount);
				PersonalDetails.balance = PersonalDetails.balance - amount;
				PersonalDetails.tFSASavingsDeposit = PersonalDetails.tFSASavingsDeposit + amount;
			} else
				System.out.println("Insufficient Balance.");

		} else {
			System.out.println("Enter Withdrawl Amount");
			int amount = sc.nextInt();
			System.out.println("Choose to which account\nChequing Account");
			if (amount <= PersonalDetails.tFSASavingsDeposit) {
				System.out.println("Withdrawl sucessfully for the amount of: " + amount);
				PersonalDetails.balance = PersonalDetails.balance + amount;
				PersonalDetails.tFSASavingsDeposit = PersonalDetails.tFSASavingsDeposit - amount;
			} else
				System.out.println("Insufficient Balance");

		}

	}

}
