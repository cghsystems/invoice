package net.cghsystems.inv;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

class AddressTest {
	
	String line1 = "line1"
	String line2 = "line2"
	String town = "town"
	String county = "county"
	String postcode = "postcode"
	
	Address unit
	@Before
	void before() {
		unit = new Address(line1:line1, line2:line2, town:town, county:county, postcode:postcode)
	}
	
	@Test
	void shouldReturnExpectedToString() {
		String expected = "${line1}, ${line2}, ${town}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	
	@Test
	void shouldReturnExpectedToStringWithNoLine1Null() {
		unit.setLine1(null)
		String expected = "${line2}, ${town}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	
	@Test
	void shouldReturnExpectedToStringWithNoLine2Null() {
		unit.setLine2(null)
		String expected = "${line1}, ${town}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	
	@Test
	void shouldReturnExpectedToStringWithNoTownNull() {
		unit.setTown(null)
		String expected = "${line1}, ${line2}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	@Test
	void shouldReturnExpectedToStringWithNoCountyNull() {
		unit.setCounty(null)
		String expected = "${line1}, ${line2}, ${town}, ${postcode}"
		assertEquals(expected, unit.toString())
	}	
	
	@Test
	void shouldReturnExpectedToStringWithNoPostCodeNull() {
		unit.setPostcode(null)
		String expected = "${line1}, ${line2}, ${town}, ${county}"
		assertEquals(expected, unit.toString())
	}
	
	@Test
	void shouldReturnExpectedToStringWithNoLine1Zero() {
		unit.setLine1("")
		String expected = "${line2}, ${town}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	
	@Test
	void shouldReturnExpectedToStringWithNoLine2NullZero() {
		unit.setLine2("")
		String expected = "${line1}, ${town}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	
	@Test
	void shouldReturnExpectedToStringWithNoTown() {
		unit.setTown("")
		String expected = "${line1}, ${line2}, ${county}, ${postcode}"
		assertEquals(expected, unit.toString())
	}
	@Test
	void shouldReturnExpectedToStringWithNoCounty() {
		unit.setCounty("")
		String expected = "${line1}, ${line2}, ${town}, ${postcode}"
		assertEquals(expected, unit.toString())
	}	
	
	@Test
	void shouldReturnExpectedToStringWithNoPostCodeZero() {
		unit.setPostcode("")
		String expected = "${line1}, ${line2}, ${town}, ${county}"
		assertEquals(expected, unit.toString())
	}
}
