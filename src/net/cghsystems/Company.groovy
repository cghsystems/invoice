package net.cghsystems


import net.cghsystems.inv.BankDetails 
import net.cghsystems.inv.ContractDetail 
import net.cghsystems.pdf.Address;

class Company {
	String name, companyNumber, vatNumber
	Address registeredOffice
	ContractDetail contractDetail;
	BankDetails bankDetails
	Date created
}
