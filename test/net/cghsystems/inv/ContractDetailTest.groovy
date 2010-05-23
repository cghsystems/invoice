package net.cghsystems.inv;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

class ContractDetailTest {
	
	ContractDetail unit
	
	final int days = 20
	
	final int rate = 400
	
	final float vat = 17.5
	
	@Before
	void before() {
		unit = new ContractDetail(days:days, rate:rate, vat:vat)
	}
	
	@Test
	void shouldCalculateTotalNoVat() {
		assertEquals(8000.0, unit.totalNoVat(), 0)
	}
	
	@Test
	void shouldCalculateVatOfTotal() {
		assertEquals(1400.0, unit.vatOfTotal(), 0)
	}
	
	@Test
	void shouldCalculateTotal() {
		assertEquals(9400.0, unit.total(), 0)
	}
	
	
	@Test
	void shouldCalculateTotalNoVatOf9200() {
		unit.setDays(23)
		assertEquals(9200.0, unit.totalNoVat(), 0)
	}
	
	@Test
	void shouldCalculateVatOfTotalOf1610() {
		unit.setDays(23)
		assertEquals(1610.0, unit.vatOfTotal(), 0)
	}
	
	@Test
	void shouldCalculateTotalOf10810() {
		unit.setDays(23)
		assertEquals(10810.0, unit.total(), 0)
	}
}
