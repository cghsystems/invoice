package net.cghsystems.inv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.cghsystems.ComapnyBuilder;
import net.cghsystems.Company;
import net.cghsystems.pdf.Address;



class CghsystemsInvoiceBuilder {
	
	Invoice build(days, fromDate, toDate, number, taxPointDate) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy")
		Company comp = buildCompany(days);
		Client client = buildClient();
		
		String description = "For professional services of consultant, working for Data Inc UK Ltd at your client UBS."
		
		Invoice inv = new Invoice(company: comp,
				client: client,
				description: description,
				fromDate: df.format(fromDate),
				number: number,
				taxPointDate: df.format(taxPointDate),
				toDate: df.format(toDate))
		
		return inv;
	}
	
	def buildClient() {
		Address add = new Address(line1: "200 Brook Drive",
		line2: "Green Park",
		town: "Reading",
		county: "Berkshire",
		postcode: "RG2 6UB")
		
		Client client = new Client(address: add, name: "Data Inc UK Ltd")
	}
	
	def buildCompany(days) {
		new ComapnyBuilder().buildCompany(days)
	}
}
