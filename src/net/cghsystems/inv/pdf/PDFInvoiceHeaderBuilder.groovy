package net.cghsystems.inv.pdf;

import com.itextpdf.text.pdf.PdfPTable;

import net.cghsystems.inv.Address;
import net.cghsystems.inv.Invoice;
import net.cghsystems.pdf.PdfComponenets;

class PDFInvoiceHeaderBuilder {
	
	def build(Invoice invoice) {
		
		PdfPTable nameCol = PdfComponenets.newEmptyTable(1, 14)
		nameCol.addCell(invoice.company.name.toUpperCase())
		
		PdfPTable addressCol = PdfComponenets.newEmptyTable(1)
		addressCol.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT)
		addAddressToColumn(invoice.company.registeredOffice, addressCol)
		
		PdfPTable header = PdfComponenets.newEmptyTable(2)
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
