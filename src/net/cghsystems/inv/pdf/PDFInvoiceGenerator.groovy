package net.cghsystems.inv.pdf



import net.cghsystems.inv.CghsystemsInvoiceBuilder;
import net.cghsystems.inv.Invoice;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph 
import com.itextpdf.text.pdf.PdfPTable 
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;



class PDFInvoiceGenerator {
	
	Document doc = new Document();
	
	def build(fromDate,toDate,days,number,outputStream) {
		
		Invoice invoice = new CghsystemsInvoiceBuilder().build(days,fromDate,toDate, number, toDate)
		
		def output = PdfWriter.getInstance(doc, outputStream)
		doc.open();
		
		addMetaData();
		
		addHeader(invoice)
		addLineBreak()
		addInvoiceSummary(invoice);
		addLineBreak()
		addPeriodSummary(invoice)
		addLineBreak()
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
		doc.add(new PDFInvoiceHeaderBuilder().build(invoice))
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
	
	
	void addLineBreak() {
		doc.add(new Paragraph(" "))
		doc.add(new LineSeparator())	
	}
}
