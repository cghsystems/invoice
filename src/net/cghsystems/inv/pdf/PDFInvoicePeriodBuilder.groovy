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
	
	def _build(Invoice invoice) {
		
		PdfPTable leftColumn = buildLeftColumn(invoice)
		PdfPTable rightColumn = buildRightColumn(invoice)
		
		PdfPTable main = PdfComponenets.newEmptyTable(3)
		main.setWidthPercentage(PDFInvoiceFormatConstants.TABLE_WIDTH)
		
		PdfPTable p = PdfComponenets.newEmptyTable(2);
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
		
		addCells(main,2)
		
		main.addCell("Client:")
		main.addCell(invoice.client.name)
		
		addCells(main,2)
		
		main.addCell("Detail:")
		main.addCell(invoice.company.contractDetail.toString())
		
		addCells(main,5)
		
		NumberFormat fmt = new DecimalFormat("##.##")
		main.addCell("£ ${fmt.format(invoice.company.contractDetail.totalNoVat())}")
			
		addCells(main,2)
		main.addCell("Vat @ ${invoice.company.contractDetail.vat}%")
		main.addCell("£ ${fmt.format(invoice.company.contractDetail.vatOfTotal())}")
			
		addCells(main,2)
		main.addCell("Total:")
		main.addCell("£ ${fmt.format(invoice.company.contractDetail.total())}", Font.BOLD)
			
		println "return"
		return main
	}
	
	def addCells(table,number) {
		number.times { table.addCell("") }
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
