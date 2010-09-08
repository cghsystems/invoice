package net.cghsystems.pdf


import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory 
import com.itextpdf.text.Paragraph 
import com.itextpdf.text.Phrase 
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell 
import com.itextpdf.text.pdf.PdfPTable 
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.codehaus.groovy.runtime.InvokerHelper 

class PdfComponenets {
	
	static void setup() {
		println "Adding metaMethods to PdfPTable"
		InvokerHelper.metaRegistry.setMetaClass(PdfPTable, new Delegate())
		
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
	}
}

class Delegate extends DelegatingMetaClass {
	Delegate() {
		super(PdfPTable)
	}
	Object invokeConstructor(Object[] arguments) {
		PdfPTable p =  super.invokeConstructor(arguments)
		p.getDefaultCell().setBorder(Rectangle.NO_BORDER)
		p
	}
}