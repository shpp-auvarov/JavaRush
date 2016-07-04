package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String REFERRER = "https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
    private static final int TIMEOUT = 5 * 1000;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int index = 0;
        try {
            while (true) {
                Document doc = getDocument(searchString, index++); // получили документ и увеличили счетчик
                Elements elements = (Elements) doc.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break; // если нет вакансий прекращаю
                for (Element element : elements) {
                    // title
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();
                    // salary
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }
                    // city
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();
                    // company
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();
                    // site
                    String siteName = "http://hh.ua/";
                    // url
                    String url = titleElement.attr("href");
                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    result.add(vacancy);
                }
            }
        } catch (IOException ignore) {
        }
        return result;
    }


    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(USER_AGENT).referrer(REFERRER).timeout(TIMEOUT).get();
    }
}