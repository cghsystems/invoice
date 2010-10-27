package net.cghsystems.div;

import org.junit.Test;

import static org.junit.Assert.*;

class DividendDeclarationTest {
	
	@Test
	void givenaDividendOf6000ThenGrossDivdendAndTaxCreditShouldBeCalculated() {
		DividendDeclaration unit = new DividendDeclaration(dividend:6000.00)
		assert 666.67 == unit.taxCredit()
		assert 6666.67 == unit.grossDividend()
	}
}
