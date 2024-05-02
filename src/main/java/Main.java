import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String htmlParse = parseSite("data/code.html");
        Document document = Jsoup.parse(htmlParse);
        Elements elements = document.select(".link");

        elements.forEach(element -> {
            //Все программы бакалавриата и магистратуры
            if (String.valueOf(element).contains("https://www.hse.ru/ma/") || String.valueOf(element).contains("https://www.hse.ru/ba/")) {
                System.out.println(element.text());
            }
        });
    }

    public static String parseSite(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            allLines.forEach(line -> builder.append(line).append("\n"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return builder.toString();
    }
}
