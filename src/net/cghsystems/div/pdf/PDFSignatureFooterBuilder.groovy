package net.cghsystems.div.pdf

import net.cghsystems.inv.pdf.PDFInvoiceFormatConstants;

import com.itextpdf.text.pdf.PdfPTable;

class PDFSignatureFooterBuilder {
	
	def build() {
		
		PdfPTable table = new PdfPTable(false, 2)
		table.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		
		table.addCell("______________________________________")
		table.addCell("______________________________________")
		
		table.addCell("Director")
		table.addCell("Date")
		
		table
	}
}
