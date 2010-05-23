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
		
		PdfPTable leftColumn = buildLeftColumn(invoice)
		PdfPTable rightColumn = buildRightColumn(invoice)
		
		PdfPTable main = PdfComponenets.newEmptyTable(2)
		main.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		
		
		PdfPTable p = PdfComponenets.newEmptyTable(4);
		p.addCell("  Description:")
		p.addCell(invoice.description)
		
		PdfPCell cell = new PdfPCell(p);
		cell.setBorder(Rectangle.NO_BORDER)
		cell.setColspan(3);
		
		main.addCell(cell);
		main.setHeaderRows(1);
		
		
		main.addCell(leftColumn)
		main.addCell(rightColumn)
		return main
	}
	
	def buildRightColumn(Invoice invoice) {
		PdfPTable left = PdfComponenets.newEmptyTable(1)
		4.times { left.addCell(" ") }
		left.addCell("Vat @ ${invoice.company.contractDetail.vat}%")
		left.addCell("Total:")
		
		PdfPTable right = PdfComponenets.newEmptyTable(1)
		3.times { right.addCell(" ") }
		
		NumberFormat fmt = new DecimalFormat("##.##")
		right.addCell("£ ${fmt.format(invoice.company.contractDetail.totalNoVat())}")
			right.addCell("£ ${fmt.format(invoice.company.contractDetail.vatOfTotal())}")
			right.addCell("£ ${fmt.format(invoice.company.contractDetail.total())}", Font.BOLD)
			
		PdfPTable main = PdfComponenets.newEmptyTable(2)
		main.addCell(left)
		main.addCell(right)
		return main
	}
	
	def buildLeftColumn(Invoice invoice) {
		
		PdfPTable left = PdfComponenets.newEmptyTable(1)
		left.setWidthPercentage(100)
		left.addCell("Period:")
		left.addCell("Client:")
		left.addCell("Detail:")
		
		PdfPTable right = PdfComponenets.newEmptyTable(1)
		right.addCell("${invoice.fromDate} - ${invoice.toDate}")
		
		right.addCell(invoice.client.name)
		right.addCell(invoice.company.contractDetail.toString())
		
		PdfPTable main = PdfComponenets.newEmptyTable(2)
		
		main.addCell(left)
		main.addCell(right)
		return main
	}
}
