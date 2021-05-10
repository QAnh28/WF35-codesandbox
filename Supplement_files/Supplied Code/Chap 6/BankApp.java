module BankApp
{
	interface Account
	{
		readonly attribute long acctNum;
		attribute string surname;
		readonly attribute string firstNames;
		attribute double balance;

		string getName();
		double withdraw(in double amount);
		void deposit(in double amount);
	};

	interface AccountFactory
	{
		Account createAccount(	in long newAcctNum,
								in string newSurname,
								in string newFirstNames,
								in double newBalance);
	};

	typedef sequence<Account> BankAccts;

	interface Bank
	{
		attribute BankAccts accounts;
	};

	interface BankFactory
	{
		Bank createBank(in BankAccts newAccounts);
	};
};
