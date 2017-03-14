import java.util.HashMap;
import java.util.Map;

public class ParseHtml {
    public String symbolsReplacement(String htmlDocument) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("&quot;", "\"");
        map.put("&amp;", "&");
        map.put("&lt;", "<");
        map.put("&gt;", ">");
        map.put("&nbsp;", " ");
        map.put("&ndash;", "–");
        map.put("&mdash;", "—");
        map.put("&lsquo;", "‘");
        map.put("&rsquo;", "’");
        map.put("&sbquo;", "‚");
        map.put("&ldquo;", "“");
        map.put("&laquo;", "[");
        map.put("&raquo;", "]");
        map.put("&rdquo;", "”");
        map.put("&bdquo;", "„");
        map.put("&frac14;", "1/4");
        map.put("&frac12;", "1/2");
        map.put("&frac34;", "3/4");
        map.put("&copy;", "©");
        map.put("&bull;", ".");
        map.put("&#8209;", "-");

        for (Map.Entry<String, String> item : map.entrySet()) {
            htmlDocument = htmlDocument.replace(item.getKey(), item.getValue());
        }
        return htmlDocument;
    }

    public String parseHtmlDoc(String htmlDocument) {
        StringBuilder resultedDocument = new StringBuilder();
        char temp;
        boolean isTag;
        for (int i = 0; i < htmlDocument.length(); i++) {
            temp = htmlDocument.charAt(i);
            if (temp == '<' && htmlDocument.charAt(i + 1) == 's'
                    && htmlDocument.charAt(i + 2) == 'c'
                    && htmlDocument.charAt(i + 3) == 'r') {
                isTag = true;
                while (isTag) {
                    i++;
                    if (temp == '<' && htmlDocument.charAt(i + 1) == '/'
                            && htmlDocument.charAt(i + 2) == 's' &&
                            htmlDocument.charAt(i + 3) == 'c') {
                        isTag = false;
                        i = i + 8;
                    }
                }
            } else {
                if (temp == '<' && htmlDocument.charAt(i + 1) == 's'
                        && htmlDocument.charAt(i + 2) == 't'
                        && htmlDocument.charAt(i + 3) == 'y') {
                    isTag = true;
                    while (isTag) {
                        i++;
                        if (htmlDocument.charAt(i) == '<'
                                && htmlDocument.charAt(i + 1) == '/'
                                && htmlDocument.charAt(i + 2) == 's' &&
                                htmlDocument.charAt(i + 3) == 't') {
                            isTag = false;
                            i = i + 7;
                        }
                    }
                } else if (temp == '<') {
                    isTag = true;
                    while (isTag) {
                        i++;
                        if (htmlDocument.charAt(i) == '>') {
                            isTag = false;
                        }
                    }
                } else if (temp == 'd' && htmlDocument.charAt(i + 1) == 'a'
                        && htmlDocument.charAt(i + 2) == 't'
                        && htmlDocument.charAt(i + 3) == 'a') {
                    isTag = true;
                    while (isTag) {
                        i++;
                        if (htmlDocument.charAt(i) == '>') {
                            isTag = false;
                        }
                    }
                } else resultedDocument.append(htmlDocument.charAt(i));
            }
        }
        return resultedDocument.toString().replaceAll("[\\s]{2,}", " ");
    }
}
