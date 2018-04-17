package com.ipartek.formacion.nidea.ejemplos;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParserJsoup {

	public static void main(String[] args) throws IOException {
		/*
		 * Document doc = Jsoup.connect("http://example.com/").get(); String title =
		 * doc.title(); System.out.println("Titulo" + title);
		 * 
		 * Elements anclas = doc.getElementsByTag("a"); for (Element link : anclas) {
		 * String urlPagina2 = link.attr("href"); Document doc2 =
		 * Jsoup.connect(urlPagina2).get();
		 * 
		 * System.out.println("Titulo pagina" + doc2.title());
		 * 
		 * }
		 */
		String url = "http://localhost:8080/nidea/login";

		Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).data("usuario", "admin")
				.data("password", "admin").execute();

		Document doc = response.parse();
		System.out.println(doc.getElementsByTag("h1").get(0).text());

		String url2 = "http://localhost:8080/nidea/backoffice/materiales";
		Connection.Response response2;
		Elements links = doc.select("a[href=/backoffice/materiales]");
		System.out.println(links.get(0).text());

	}

}
