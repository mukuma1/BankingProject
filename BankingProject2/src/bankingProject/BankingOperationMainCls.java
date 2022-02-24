package bankingProject;

import java.util.Scanner;

public class BankingOperationMainCls {
//Account Details- Name:Mamatha; DebitCard#:4111111111111111;Pin#:1234; Username:user1234;password:pass@1234; AccountType: Personal Banking; Balance: 4024.50CAD; TFSA SavingDeposit: 725.50
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonalDetails details = new PersonalDetails("user1234","4111111111111111", "Mamatha", "Personal Banking", 4024.50,
				1234, "pass@1234", 725.50);
		int j = 0;// counter for do-while loop
		System.out.println("Please enter 0 for ATM/ 1 for Online Banking Options");
		switch (sc.nextInt()) {
		case 0:
			Atm obj = new Atm();
			obj.setAtmDetails(details);// composition
			System.out.println("Please insert the card & enter the pin Number");
			for (int i = 3; i > 0; i--) {
				if (obj.userIdentification()) {
					i = 3;
					do {
						System.out.println("Please select \nDeposit\nWithdrawl");// Not considering invalid entry assuming that operations are being selected from the touch screen in actual UI
						if (sc.next().equalsIgnoreCase("deposit")) {
							obj.deposit();
							System.out.println("Deposit Sucessful. Current Balance on chequing account: " + PersonalDetails.getBalance());
							System.out.println("Select Y to continue with ATM Operation or N to exit application ");
							if (sc.next().equalsIgnoreCase("Y")) {
								j++;
							} else {
								i = 0;
								System.out.println("Thank You");
								break;
							}
						} else { 
							obj.withdraw();
							System.out.println("Current Balance on chequing account: " + PersonalDetails.getBalance());
							System.out.println("Select Y to continue with ATM Operation or N to exit application");
							if (sc.next().equalsIgnoreCase("Y")) {
								j++;
							} else {
								i = 0;
								System.out.println("Thank You");
								break;
							}
						} 
					} while (j > 0);
				} else if (i == 1) {
					System.out.println("Maximum attempts of incorrect pin number reached. Account locked");
					break;
				} else {
					System.out.println("pinNumber is incorrect. Enter correct pin number & try again");
				}
			} 
			break;
		case 1:
			OnlineBanking obj2 = new OnlineBanking();
			obj2.setOnlinebankingDetails(details);
			for (int i = 3; i > 0; i--) {
				if (obj2.userIdentification()) {
					i = 3;
					do {
						System.out.println("Please choose FundTransfer/Investment");// Not considering invalid entry assuming that operations are being selected from drop down in actual UI
						if (sc.next().equalsIgnoreCase("FundTransfer")) {
							obj2.fundTransfer();
							System.out.println("Current Balance on chequing account: " + PersonalDetails.getBalance());
							System.out.println("Select Y to continue with Online banking or N to exit application ");
							if (sc.next().equalsIgnoreCase("Y")) {
								j++;
							} else {
								i = 0;
								System.out.println("Thank You");
								break;
							}
						} else { 
							obj2.investment();
							System.out.println("Current Balance on chequing account: " + PersonalDetails.getBalance()+ "\nTFSA Savings Deposit: "+PersonalDetails.gettFSASavingsDeposit());
							System.out.println("Select Y to continue with Online Banking or N to exit application");
							if (sc.next().equalsIgnoreCase("Y")) {
								j++;
							} else {
								i = 0;
								System.out.println("Thank You");
								break;
							}
						} 
					} while (j > 0);
				} else if (i == 1) {
					System.out.println("Maximum attempts of incorrect username or password. Account locked");
					break;
				} else {
					System.out.println("Username or password is incorrect. Try again");
				}
			} 
			break;
		default:
			System.out.println("Invalid entry. Try again");

		}
		sc.close();
	}

}
