package net.cghsystems.div
;


import net.cghsystems.div.pdf.PDFDividendGenerator;
import net.cghsystems.pdf.PdfComponenets;

import org.junit.Before;
import org.junit.Test;

public class CreateDividend {
	
	def invoiceNumber = 2
	def fileName = "/home/chris/test/cgh-systems-dividend-${invoiceNumber}.pdf"
	
	@Before
	void before() {
		PdfComponenets.setup()
	}
	
	@Test
	void build() {
		
		Calendar date = new GregorianCalendar(2010, 04, 1)
		BigDecimal dividend = 6000.00
		
		def output = new FileOutputStream(fileName)
		new PDFDividendGenerator().build(date.getTime(), dividend, output)
	}
	
}
