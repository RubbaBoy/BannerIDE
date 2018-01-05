package com.uddernetworks.banneride.highlighter;

import java.io.*;

public class CustomJavaRenderer {

    private String getCssClass(int style) {
        switch (style) {
            case 1:
                return "BLACK";
            case 2:
                return "BLACK";
            case 3:
                return "BLUE";
            case 4:
                return "GREEN";
            case 5:
                return "BLUE";
            case 6:
                return "RED";
            case 7:
                return "GRAY";
            case 8:
                return "GRAY";
            case 9:
                return "GRAY";
            default:
                return "BLACK";
        }
    }

    public String highlight(String text) throws IOException {
        JavaHighlighter highlighter = this.getHighlighter();

        InputStream is = new ByteArrayInputStream(text.getBytes());
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader r = new BufferedReader(isr);

        StringBuilder builder = new StringBuilder();

        String line;
        char[] token;
        int length;
        int style;
        String css_class;
        while ((line = r.readLine()) != null) {
            Reader lineReader = new StringReader(line);
            highlighter.setReader(lineReader);
            int index = 0;
            while (index < line.length()) {
                style = highlighter.getNextToken();
                length = highlighter.getTokenLength();
                token = line.substring(index, index + length).toCharArray();

                for (char ignored : token) {
                    css_class = getCssClass(style);

                    builder.append(css_class).append(" ");
                }

                index += length;
            }

            builder.append("\n");
        }

        return builder.toString();
    }

    private JavaHighlighter getHighlighter() {
        JavaHighlighter highlighter = new JavaHighlighter();
        JavaHighlighter.ASSERT_IS_KEYWORD = true;
        return highlighter;
    }
}
