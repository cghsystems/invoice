package net.cghsystems.inv;

import net.cghsystems.inv.pdf.PDFInvoiceGenerator;
import net.cghsystems.pdf.PdfComponenets;

import org.junit.Before;
import org.junit.Test;

public class Create {
	
	def invoiceNumber = 2
	def fileName = "/home/chris/test/cgh-systems-invoice-${invoiceNumber}.pdf"
	
	@Before
	void before() {
		PdfComponenets.setup()
	}
	
	@Test
	void build () {
		
		Calendar fromDate =  new GregorianCalendar(2010, 04, 1)
		Calendar toDate =  new GregorianCalendar(2010, 04, 30)		
		int days = 18;
		
		def output = new FileOutputStream(fileName)
		new PDFInvoiceGenerator().build(fromDate.getTime(),toDate.getTime(),days,invoiceNumber,output)
	}
	
}
