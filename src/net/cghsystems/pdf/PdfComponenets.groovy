package net.cghsystems.pdf


import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory 
import com.itextpdf.text.Phrase 
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell 
import com.itextpdf.text.pdf.PdfPTable 



class PdfComponenets {
	
	static void setup() {
		PdfPTable.metaClass.addEmptyCells = {
			it.times { addCell("") }
		}
	}
	
	static PdfPTable newEmptyTable(int cols) {
		newEmptyTable(cols, 8)		
	}
	
	static PdfPTable newEmptyTable(int cols, int fontSize) {
		PdfPTable table = new PdfPTable(cols) {
			
			void addCell(String text) {
				addCell(text, Font.NORMAL)   		
			}
			
			@Override
			void addCell(String text, int fontStyle) {
				PdfPCell pCell = new PdfPCell()
				
				Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize)
				font.setStyle(fontStyle)
				Phrase phrase = new Phrase(text, font)
				addCell(phrase)
			}
		}
		
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER)
		return table
	}
}
