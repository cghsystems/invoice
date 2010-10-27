package net.cghsystems.div


import java.math.RoundingMode;

import net.cghsystems.Company;
import net.cghsystems.inv.Contact;

class DividendDeclaration {
	String dateHeld
	Company company
	Contact director
	BigDecimal dividend
	
	BigDecimal taxCredit() {
		dividend.divide(9, RoundingMode.HALF_EVEN)
	}
	
	BigDecimal grossDividend() {
		dividend.add(taxCredit())
	}
}
