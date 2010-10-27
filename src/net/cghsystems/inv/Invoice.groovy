package net.cghsystems.inv;

import net.cghsystems.Company;

class Invoice {
	int number
	String description
	String taxPointDate, fromDate, toDate
	Client client = new Client()
	Company company
	Date taxPointDate2
}
