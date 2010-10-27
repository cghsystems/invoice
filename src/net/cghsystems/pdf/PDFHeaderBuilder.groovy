package net.cghsystems.pdf
;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;

import net.cghsystems.Company;
import net.cghsystems.inv.pdf.PDFInvoiceFormatConstants;

class PDFHeaderBuilder {
	
	def build(Company company) {
		
		PdfPTable nameCol = new PdfPTable(false, 1)
		nameCol.addCell(company.name.toUpperCase(), Font.NORMAL, 14)
		
		PdfPTable addressCol = new PdfPTable(false, 1)
		addressCol.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT)
		addAddressToColumn(company.registeredOffice, addressCol)
		
		PdfPTable header = new PdfPTable(false, 2)
		header.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		
		header.addCell(nameCol)
		header.addCell(addressCol)
		return header
	}
	
	void addAddressToColumn(Address address, PdfPTable column) {
		def closure = { column.addCell(it) }
		address.buildAddress(closure, address)
	}
}
