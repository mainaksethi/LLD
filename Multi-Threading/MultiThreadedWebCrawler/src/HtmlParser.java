import java.util.ArrayList;
import java.util.List;

public class HtmlParser {

    public List<String> getUrls(String url) {
        List<String> ls = new ArrayList<>();
        if (url == "abc.com") {
            ls.add("def.com");
            ls.add("abc.pqr.com");
        }
        return ls;
    }
}
