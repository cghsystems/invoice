package net.cghsystems.div;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.cghsystems.inv.Contact

import net.cghsystems.ComapnyBuilder;
import net.cghsystems.Company 

class CghSystemsDividendDeclarationBuilder {
	
	DividendDeclaration build(date, dividend) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy")
		
		Company cgh = new ComapnyBuilder().buildCompany(0)
		Contact me = new Contact(name:"Christopher Hedley")
		
		return new DividendDeclaration(dateHeld:df.format(date), 
		company:cgh, 
		director:me, 
		dividend:dividend)
	}
}
