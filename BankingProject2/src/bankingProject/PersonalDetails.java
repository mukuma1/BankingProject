package bankingProject;

public class PersonalDetails {
	private String userName;
	private String debitCardNumber;
	String nameOfAccountHolder;
	String accountType;
	static double balance;// static variable
	private int pinNumber;
	private String password;
	static double tFSASavingsDeposit; // static variable

	public PersonalDetails(String userName, String debitCardNumber, String nameOfAccountHolder, String accountType,
			double balance, int pinNumber, String password, double tFSASavingsDeposit) {
		super();
		this.userName = userName;
		this.debitCardNumber = debitCardNumber;
		this.nameOfAccountHolder = nameOfAccountHolder;
		this.accountType = accountType;
		PersonalDetails.balance = balance;
		this.pinNumber = pinNumber;
		this.password = password;
		PersonalDetails.tFSASavingsDeposit = tFSASavingsDeposit;
	}

	public static double getBalance() {
		return balance;
	}

	public static double gettFSASavingsDeposit() {
		return tFSASavingsDeposit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		if (String.valueOf(pinNumber).length() >= 4) {
			this.pinNumber = pinNumber;
		} else
			System.out.println("Pin number must contain atleast 4 digits");

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() >= 8) {
			if (password.contains("&") || password.contains("@") || password.contains("$")) {
				this.password = password;
			} else
				System.out.println("Password must contain atleast one special character: &, $, @ ");
		} else
			System.out.println("Password must contain 8 characters");
	}

}
