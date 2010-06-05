package net.cghsystems.inv.pdf;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import net.cghsystems.inv.Invoice 
import net.cghsystems.pdf.PdfComponenets;

import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

class PDFInvoicePeriodBuilder {
	
	def build(Invoice invoice) {
		PdfPTable main = PdfComponenets.newEmptyTable(4)
		main.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		main.addCell("Description:")
		
		PdfPTable desc = PdfComponenets.newEmptyTable(1)
		desc.addCell(invoice.description)
		PdfPCell cell = new PdfPCell(desc);
		cell.setBorder(Rectangle.NO_BORDER)
		cell.setColspan(3);
		main.addCell(cell)
		main.setHeaderRows(1);
		
		main.addCell("Period:")
		main.addCell("${invoice.fromDate} - ${invoice.toDate}")
		
		main.addEmptyCells(2)
		
		main.addCell("Client:")
		main.addCell(invoice.client.name)
		
		main.addEmptyCells(2)
		
		main.addCell("Detail:")
		main.addCell(invoice.company.contractDetail.toString())
		
		main.addEmptyCells(5)
		
		NumberFormat fmt = new DecimalFormat("##.##")
		main.addCell("£ ${fmt.format(invoice.company.contractDetail.totalNoVat())}")
			
		main.addEmptyCells(2)
		main.addCell("Vat @ ${invoice.company.contractDetail.vat}%")
		main.addCell("£ ${fmt.format(invoice.company.contractDetail.vatOfTotal())}")
			
		main.addEmptyCells(2)
		main.addCell("Total:")
		main.addCell("£ ${fmt.format(invoice.company.contractDetail.total())}", Font.BOLD)
			
		return main
	}
}
