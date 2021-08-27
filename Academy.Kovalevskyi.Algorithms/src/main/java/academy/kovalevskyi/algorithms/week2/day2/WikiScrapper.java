package academy.kovalevskyi.algorithms.week2.day2;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class WikiScrapper {
  private String url;
  private Document doc;

  private WikiScrapper() {
  }

  public String getUrl() {
    return url;
  }

  public static WikiScrapper generateScrapper(String page) throws IOException {
    var wikiScrapper = new WikiScrapper();
    wikiScrapper.url = page;
    wikiScrapper.doc = Jsoup.connect(wikiScrapper.url).get();
    return wikiScrapper;
  }

  public Date lastEditedOnDate() throws ParseException {
    String title = doc.title();
    Element element = doc.select("body").first();
    var str = element.text();
    var children = doc.children();


    Iterator<Element> ch = element.children().iterator();
    while (ch.hasNext()) {
      //var list = ch.next().attr("dateModified");
      var str2 = ch.next().text();

      var child = ch.next().children();
      var listCh = child.textNodes();


      var listch = child.eachAttr("dateModified");

      System.out.println(" ");
    }
    /*
    while (true){
      Elements child = doc.children();
      String str2 = element.text();
      //Elements child2 = child.next();
      //child = child.next();
      //String str = child2.text();
      //System.out.println(str);
    }

    //System.out.println(child.text());
    */
    return new Date();
  }
}
