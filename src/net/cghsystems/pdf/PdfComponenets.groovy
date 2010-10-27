package net.cghsystems.pdf


import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory
import com.itextpdf.text.Paragraph
import com.itextpdf.text.Phrase
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.draw.LineSeparator;

class PdfComponenets {
	
	static void setup() {
		println "Adding metaMethods to PdfPTable"
		
		PdfPTable.metaClass.constructor= { boolean showBorder, int numberOfColumns ->
			PdfPTable p = new PdfPTable(numberOfColumns)
			if(!showBorder) {
				p.getDefaultCell().setBorder(Rectangle.NO_BORDER)
			}
			return p 
			
		}
		
		PdfPTable.metaClass.addEmptyCells = {
			it.times { addCell("") }
		}
		
		PdfPTable.metaClass.addCell = { String text ->
			addCell(text, Font.NORMAL, 8)
		}
		
		PdfPTable.metaClass.addCell = { String text, int fontStyle ->
			addCell(text, fontStyle, 8)
		}
		
		PdfPTable.metaClass.addCell = {String text, int fontStyle, int fontSize ->
			PdfPCell pCell = new PdfPCell()
			pCell.setBorder(Rectangle.NO_BORDER)
			Font font = FontFactory.getFont(FontFactory.HELVETICA, fontSize)
			font.setStyle(fontStyle)
			Phrase phrase = new Phrase(text, font)
			addCell(phrase)
		}
		
		println "Adding addLineBreak metaMethod to Document"
		Document.metaClass.addLineBreak = {
			add(new Paragraph(" "))
			add(new LineSeparator())
		}
		
		Document.metaClass.newLine = {
			add(new Paragraph(" "))
		}
	}
}