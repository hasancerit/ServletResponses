package responsesp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Turkce karakter kullan�lmak istendi�inde
		PrintWriter pw = resp.getWriter();
		pw.println("������"); b�yle bir g�nderimde, harfler sayfada g�r�nmeyecektir.
		*/
		
		String responseEncoding = resp.getCharacterEncoding();
		// Eger belirtilen bir encoding yoksa bu durumda varsayilan encoding
		// ISO-8859-1 olacaktir.
		System.out.println("responseEncoding:" + responseEncoding); //responseEncoding:ISO-8859-1
		
		//YAPILMASI GEREKEN;
		resp.setCharacterEncoding("ISO-8859-9");// bu method println metodundan once cagrilmaldir.
		PrintWriter pw = resp.getWriter();
		pw.println("������");

		String responseEncodingYeni = resp.getCharacterEncoding();
		System.out.println("responseEncoding:" + responseEncodingYeni); //responseEncoding:ISO-8859-9
	}

}
