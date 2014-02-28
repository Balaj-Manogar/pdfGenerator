package cw.ksl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class CrosswordPDFGenerator
 */
public class CrosswordPDFGenerator extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrosswordPDFGenerator()
	{
		super();
		// TODO Auto-generated constructor stubpf
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "application/pdf");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// PrintWriter out = response.getWriter();
		// out.println("hi Balaji!!!..");
		ServletOutputStream out = response.getOutputStream();
		Document pdfDoc = new Document();
		try
		{
			PdfWriter.getInstance(pdfDoc, baos);
			pdfDoc.open();
			pdfDoc.addTitle("My first PDF");
			pdfDoc.addSubject("Using iText");
			pdfDoc.addKeywords("Java, PDF, iText");
			pdfDoc.addAuthor("Balaji Manogar");
			pdfDoc.addCreator("Balaji Manogar");
			pdfDoc.add(new Paragraph("Welcome Balaji!!!"));
			pdfDoc.close();
			
			response.setContentLength(baos.size());			
			baos.writeTo(out);

		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{		
			out.flush();			
		}
	}
	
	void createTable()
	{
		PdfPTable cwTable = new PdfPTable(4);
		cwTable.addCell("III");
	}
	
	

}
