package responsesp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Cookie : herhangi bir �nternet sitesi taraf�ndan bilgisayara b�rak�lan bir t�r tan�mlama dosyas�.
		 *  �erez dosyalar�nda oturum bilgileri ve benzeri veriler saklan�r. �erez kullanan bir site ziyaret 
		 *  edildi�inde bu site, eri�imin yap�ld��� taray�c�ya sabit diske bir ya da daha fazla �erez b�rakma 
		 *  konusunda talep g�nderebilir.
		 *  
		 *  Browser Request ile birlikte �nceden eklenen cookie'leri yollar.
		 *  Server, kendisine gelen req ile �nceden y�kledi�i cookie'leri al�r,
		 *  yeni cookileri resp ile yollar
		 */
		
		Cookie kullaniciAdiCookie = new Cookie("username", "hasan__cerit123");
		Cookie sifreCookie = new Cookie("password", "123987456");

		//Cookie ekleme yollar�. addHeader ile eklemek istiyorsak Set-Cookie standart.
		resp.addHeader("Set-Cookie","testName=test");//Taray�c�/Bilgisayara Cookileri b�rakt�k
		resp.addCookie(kullaniciAdiCookie);
		resp.addCookie(sifreCookie);
		
		Cookie tempCookie = new Cookie("geciciName","geciciCookie");
		tempCookie.setMaxAge(5); //Browser'a y�klendikten 5 saniye sonra silinecek.
		resp.addCookie(tempCookie);
		
		Cookie[] cookies = req.getCookies();/*Burada da b�rakt���m�z cookieleri �ektik. (Bir �nceki get iste�inde b�rakt���m�z 
		*cookieler �ekilir. ��nk� client url'i girip get reqi yollad���nda, req ile son y�klenen cookileri yollar.
		*Alaca�� resp ile de yeni cookileri al�r.)*/
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + " " + c.getValue());
			}
		}
	}
}
