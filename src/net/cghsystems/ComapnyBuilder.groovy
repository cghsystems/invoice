package net.cghsystems

import net.cghsystems.inv.BankDetails 
import net.cghsystems.Company 
import net.cghsystems.inv.ContractDetail 
import net.cghsystems.pdf.Address;

class ComapnyBuilder {
	
	def buildCompany(days) {
		
		Address registeredOffice = buildCompanyAddress()
		String name = "CGH Systems Ltd"
		String companyNumber = "7173828"
		String vatNumber = "988 0979 40"
		
		ContractDetail contractDetail = new ContractDetail(days: days, rate: 400, vat: 20)
		BankDetails bankDetails = buildBankDetails()
		Date created = new Date();
		
		Company c = new Company(bankDetails: bankDetails,
				companyNumber: companyNumber,
				contractDetail: contractDetail,
				created: created,
				name: name,
				registeredOffice: registeredOffice,
				vatNumber: vatNumber)
		
		return c;
	}
	
	def buildCompanyAddress() {
		return new Address(line1: "51 Brantwood",
		line2: "Chester-le-Street",
		county: "Co. Durham",
		postcode: "DH2 2UJ")
	}
	
	def buildBankDetails() {
		def address = buildBankAddress();
		return new BankDetails(accountNumber: "71432559",
		name: "HSBC",
		reference: "cgh-systems",
		sortCode: "40-17-31",
		address: address,
		remittanceAdvice: "chris@cghsystems.net")
	}
	
	def buildBankAddress() {
		return new Address(line1: "The Helicon",
		line2: "1 South Place",
		town: "The City",
		county: "London",
		postcode: "EC2M 2UP")
	}
}
