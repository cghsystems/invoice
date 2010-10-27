package net.cghsystems.div.pdf

import com.itextpdf.text.pdf.PdfPTable

import net.cghsystems.div.DividendDeclaration;
import net.cghsystems.inv.pdf.PDFInvoiceFormatConstants 

class PDFDividendSummaryBuilder {
	
	def build(DividendDeclaration dividend) {
		PdfPTable summary = buildSummaryColumn(dividend)
		return summary
	}
	
	
	def buildSummaryColumn(DividendDeclaration dividend) {
		
		PdfPTable summaryTable = new PdfPTable(false, 2)
		summaryTable.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		
		PdfPTable t = new PdfPTable(false, 1)
		t.addCell("Directors Meeting Date:")
		t.addCell("Directors Present:")
		t.addCell("Meeting Location:")
		
		PdfPTable d = new PdfPTable(false, 1)
		d.addCell("${dividend.dateHeld}")
		d.addCell("${dividend.director.name}")
		d.addCell("${dividend.company.registeredOffice}")
		
		summaryTable.addCell(t)
		summaryTable.addCell(d)
		
		return summaryTable;
	}
}
