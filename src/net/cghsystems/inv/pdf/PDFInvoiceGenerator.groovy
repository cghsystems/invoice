package net.cghsystems.inv.pdf



import net.cghsystems.inv.CghsystemsInvoiceBuilder;
import net.cghsystems.inv.Invoice;
import net.cghsystems.pdf.PDFHeaderBuilder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter;



class PDFInvoiceGenerator {
	
	private final Document doc = new Document();
	
	def build(fromDate, toDate, days, number, outputStream) {
		
		Invoice invoice = new CghsystemsInvoiceBuilder().build(days, fromDate, toDate, number, toDate)
		
		def output = PdfWriter.getInstance(doc, outputStream)
		doc.open();
		
		addMetaData();
		
		addHeader(invoice)
		doc.addLineBreak()
		addInvoiceSummary(invoice);
		doc.addLineBreak()
		addPeriodSummary(invoice)
		doc.addLineBreak()
		addPaymentSummary(invoice)
		doc.close();
	}
	
	void addPaymentSummary(Invoice invoice) {
		doc.add(new PDFInvoicePaymentSummaryBuilder().build(invoice))
	}
	
	void addPeriodSummary(Invoice invoice) {
		doc.add(new PDFInvoicePeriodBuilder().build(invoice))
	}
	
	void addHeader(invoice) {
		doc.add(new PDFHeaderBuilder().build(invoice.company))
	}
	
	void addMetaData() {
		doc.addTitle("Invoice")
		doc.addSubject("Invoice")
		doc.addKeywords("Invoice for Christopher Hedley")
		doc.addAuthor("cgh-systems")
		doc.addCreator("cgh-systems")
	}
	
	void addInvoiceSummary(invoice) {
		
		PdfPTable summaryTable = new PDFInvoiceSummaryBuilder().build(invoice)
		
		Paragraph section = new Paragraph();
		section.add(summaryTable)
		
		doc.add(section)
	}
}
