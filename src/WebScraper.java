import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }public static void main(String[] unused) {
        String text = (urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int wordCount = 0;
        for (int count = 0; count < text.length(); count++) {
            if (text.charAt(count) == ' ') {
                wordCount++;
                System.out.println("a" + text.charAt(count) + "a");
                int extra = 1;
                while (text.charAt(count + extra) == ' ' || text.charAt(count + extra) == '\n' || text.charAt(count + extra) == '\t') {
                    count++;
                    extra++;
                }
            }
        }
        System.out.println("Word Count: " + wordCount);
        //it's too large

    }
}
