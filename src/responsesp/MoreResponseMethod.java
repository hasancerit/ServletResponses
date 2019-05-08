package responsesp;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoreResponseMethod extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// setHeader metodu ile response header ekliyoruz.
		// setHeader metodu, eger ilgili isme sahip(firstName) header yoksa
		// olusturur varsa uzerine yazar override eder.
		resp.setHeader("isim", "Hasan");
		resp.setHeader("isim", "Hasan-Override");

		// containsHeader metodu parametre olarak aldigi degerde response header olup olmadigini kontrol eder.
		// Eger ilgili response header varsa true yoksa false donecektir.
		boolean contains = resp.containsHeader("isim");
		System.out.println("contains:" + contains); //true

		// getHeader metodu ile fistName ismine sahip response header'a
		// ulasabiliriz.
		String isim = resp.getHeader("isim");
		System.out.println("isim:" + isim);
		
		// addHeader metodu override yapmaz! Bunun yerine ekleme yapacaktir.
		resp.addHeader("isim", "Deniz");
		resp.addHeader("isim", "Batu");
		// isim ismine sahip response header'inin art�k 3 tane degeri var.
		// Peki bu degerlere nasil ulasabiliriz ?
		
		String isim2 = resp.getHeader("isim");
		System.out.println("isim:" + isim2);
		// getHeader metodu yetersiz kalmaktadir.Eger ayni isme sahip header
		// varsa bu durumda ilk eklenen header'a ait degeri dondurmektedir.
		
		//Bir header�n birden fazla de�eri varsa getHeaders (ret Collection)
		Collection<String> isimHeaders = resp.getHeaders("isim");
		for (String isimHeader : isimHeaders) {
			System.out.println("isim:" + isimHeader);
		}

		
		// setIntHeader ve addIntHeader da value parametresi int tipindedir.
		// Bu sayede int tipindeki bir degiskeni String'e convert etmeden direkt
		// kullanabiliriz.
		resp.setIntHeader("y�l", 1998);
		resp.addIntHeader("y�l", 2009);

		// Benzer sekilde setDateHeader ve addDateHeader metodunun value kismi
		// long tipindedir.
		resp.setDateHeader("bug�n", System.currentTimeMillis());
		resp.addDateHeader("bug�n", 10000000L);

		// getHeaderNames metodu bize response header'larin ismini donecektir.
		Collection<String> headerNames = resp.getHeaderNames();
		for (String headerName : headerNames) {
			System.out.println(headerName);	
		}
	}

}
