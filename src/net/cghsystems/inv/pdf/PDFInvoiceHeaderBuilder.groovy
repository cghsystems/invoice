package net.cghsystems.inv.pdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;

import net.cghsystems.inv.Address;
import net.cghsystems.inv.Invoice;

class PDFInvoiceHeaderBuilder {
	
	def build(Invoice invoice) {
		
		PdfPTable nameCol = new PdfPTable(1)
		nameCol.addCell(invoice.company.name.toUpperCase(),Font.NORMAL, 14)
		
		PdfPTable addressCol = new PdfPTable(1)
		addressCol.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT)
		addAddressToColumn(invoice.company.registeredOffice, addressCol)
		
		PdfPTable header = new PdfPTable(2)
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
