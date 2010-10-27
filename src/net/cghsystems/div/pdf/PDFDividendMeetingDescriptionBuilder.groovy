package net.cghsystems.div.pdf

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory 
import com.itextpdf.text.Paragraph;

class PDFDividendMeetingDescriptionBuilder {
	
	private final String description = 
	"""
	At a meeting of the Directors of the Company held on the above date, it was proposed and resolved to confirm the payments to the shareholders of the Company Dividends in the proportion of their respective shareholdings in the amounts shown below.
	"""
	
	def build() {
		Font font = FontFactory.getFont(FontFactory.HELVETICA, 8)
		new Paragraph(description, font)
	}
}
