package net.cghsystems.inv.pdf;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

import net.cghsystems.inv.Invoice;
import net.cghsystems.pdf.PdfComponenets;

class PDFInvoicePaymentSummaryBuilder {
	
	def build(Invoice invoice) {
		Paragraph paragraph = new Paragraph()
		
		paragraph.add("Please make payment to:")
		addPaymentSummaryToParagraph(paragraph, invoice)
		return paragraph
	}
	
	void addPaymentSummaryToParagraph(Paragraph paragraph, Invoice invoice) {
		
		PdfPTable leftColumn = PdfComponenets.newEmptyTable(1)
		leftColumn.addCell("Company:")
		leftColumn.addCell("Registered Office:")
		leftColumn.addCell("Bank:")
		leftColumn.addCell("Address:")
		leftColumn.addCell("Sort Code:")
		leftColumn.addCell("Account Number:")
		leftColumn.addCell("Reference:")
		leftColumn.addCell("Remittance Advice:")
		
		PdfPTable rightColumn = PdfComponenets.newEmptyTable(1)
		rightColumn.addCell(invoice.company.name)
		rightColumn.addCell(invoice.company.registeredOffice.toString())
		rightColumn.addCell(invoice.company.bankDetails.name)
		rightColumn.addCell(invoice.company.bankDetails.address)
		rightColumn.addCell(invoice.company.bankDetails.sortCode)
		rightColumn.addCell(invoice.company.bankDetails.accountNumber)
		rightColumn.addCell(invoice.company.bankDetails.reference)
		rightColumn.addCell(invoice.company.bankDetails.remittanceAdvice)
		
		PdfPTable main = PdfComponenets.newEmptyTable(2)
		main.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		main.addCell(leftColumn)
		main.addCell(rightColumn)
		paragraph.add(main)
	}
}
