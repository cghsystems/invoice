package net.cghsystems.inv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;



class CghsystemsInvoiceBuilder {
	
	Invoice build(days, fromDate, toDate, number, taxPointDate) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy")
		Company comp = buildCompany(days);
		Client client = buildClient();
		
		String description = "For professional services of Consultant, working for Data Inc Uk Ltd at your client UBS."
		
		Invoice inv = new Invoice(company:comp, 
				client:client, 
				description:description,
				fromDate:df.format(fromDate),
				number:number,
				taxPointDate:df.format(taxPointDate),
				toDate:df.format(toDate))
		
		return inv;
	}
	
	def buildClient() {
		Address add = new Address(line1:"200 Brook Drive", 
		line2:"Green Park", 
		town:"Reading",
		county:"Berkshire", 
		postcode:"RG2 6UB")
		
		Client client = new Client(address:add, name:"Data Inc UK Ltd")
	}
	
	def buildCompany(days) {
		
		Address registeredOffice = buildCompanyAddress()
		String name = "CGH Systems Ltd"
		String companyNumber = "7173828" 
		String vatNumber = "PENDING"
		
		ContractDetail contractDetail = new ContractDetail(days:days, rate:400, vat:0)
		BankDetails bankDetails = buildBankDetails()
		Date created = new Date();
		
		Company c = new Company(bankDetails:bankDetails, 
				companyNumber:companyNumber, 
				contractDetail:contractDetail, 
				created:created, 
				name:name, 
				registeredOffice:registeredOffice,
				vatNumber:vatNumber)
		
		return c;
	}
	
	def buildBankDetails() {
		def address = buildBankAddress();		
		return new BankDetails(accountNumber:"71432559", 
		name:"HSBC", 
		reference:"cgh-systems", 
		sortCode:"40-17-31",
		address:address,
		remittanceAdvice:"chris@cghsystems.net")
	}
	
	
	def buildBankAddress() {
		return new Address(line1:"The Helicon", 
		line2:"1 South Place",
		town:"The City",
		county:"London", 
		postcode:"EC2M 2UP")
	}
	
	def buildCompanyAddress() {
		return new Address(line1:"51 Brantwood", 
		line2:"Chester-le-Street", 
		county:"Co. Durham", 
		postcode:"DH2 2UJ")
	}
}
