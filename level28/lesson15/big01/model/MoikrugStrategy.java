package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=%s";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static final String REFERRER = "http://javarush.ru/";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int index = 1;
        try {
            while (true) {
                Document doc = getDocument(searchString, index++); // получили документ и увеличили счетчик
                Elements elements = doc.getElementsByClass("job");
                if (elements.isEmpty()) break; // если нет вакансий прекращаю
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName(doc.title());
                    vacancy.setSalary(element.getElementsByClass("salary").first().getElementsByAttributeValue("title", "Зарплата").text());
                    vacancy.setTitle(element.getElementsByClass("info").first().getElementsByAttribute("title").text());
                    vacancy.setUrl("https://moikrug.ru" + element.getElementsByClass("title").first().getElementsByTag("a").attr("href"));
                    vacancy.setCity(element.getElementsByClass("location").text());
                    vacancy.setCompanyName(element.getElementsByClass("company_name").first().getElementsByTag("a").text());
                    result.add(vacancy);
                }
            }
        } catch (IOException ignore) {
        }
        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, page, searchString);
        return Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
