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
		/*Cookie : herhangi bir Ýnternet sitesi tarafýndan bilgisayara býrakýlan bir tür tanýmlama dosyasý.
		 *  Çerez dosyalarýnda oturum bilgileri ve benzeri veriler saklanýr. Çerez kullanan bir site ziyaret 
		 *  edildiðinde bu site, eriþimin yapýldýðý tarayýcýya sabit diske bir ya da daha fazla çerez býrakma 
		 *  konusunda talep gönderebilir.
		 *  
		 *  Browser Request ile birlikte önceden eklenen cookie'leri yollar.
		 *  Server, kendisine gelen req ile önceden yüklediði cookie'leri alýr,
		 *  yeni cookileri resp ile yollar
		 */
		
		Cookie kullaniciAdiCookie = new Cookie("username", "hasan__cerit123");
		Cookie sifreCookie = new Cookie("password", "123987456");

		//Cookie ekleme yollarý. addHeader ile eklemek istiyorsak Set-Cookie standart.
		resp.addHeader("Set-Cookie","testName=test");//Tarayýcý/Bilgisayara Cookileri býraktýk
		resp.addCookie(kullaniciAdiCookie);
		resp.addCookie(sifreCookie);
		
		Cookie tempCookie = new Cookie("geciciName","geciciCookie");
		tempCookie.setMaxAge(5); //Browser'a yüklendikten 5 saniye sonra silinecek.
		resp.addCookie(tempCookie);
		
		Cookie[] cookies = req.getCookies();/*Burada da býraktýðýmýz cookieleri çektik. (Bir önceki get isteðinde býraktýðýmýz 
		*cookieler çekilir. Çünkü client url'i girip get reqi yolladýðýnda, req ile son yüklenen cookileri yollar.
		*Alacaðý resp ile de yeni cookileri alýr.)*/
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + " " + c.getValue());
			}
		}
	}
}
