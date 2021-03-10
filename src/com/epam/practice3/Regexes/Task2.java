package com.epam.practice3.Regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piskunou Yury
 * @my.task 2. Дана строка, содержащая следующий текст (xml-документ):

<notes>
    <note id = "1">
        <to>Вася</to>
        <from>Света</from>
        <heading>Напоминание</heading>
        <body>Позвони мне завтра!</body>
    </note>
    <note id = "2">
        <to>Петя</to>
        <from>Маша</from>
        <heading>Важное напоминание</heading>
        <body/>
    </note>
</notes>

Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
нельзя.
 * @since 12.01.21
 */
public class Task2 {
    private static String xmlAnalyzer(String xml) {
        StringBuilder strBuilder = new StringBuilder();
        Pattern tagOpen = Pattern.compile("<\\w.+?>");
        Pattern tagClose = Pattern.compile("</\\w+>");
        Pattern tagBody = Pattern.compile(">.+?<");
        Pattern tagEmpty = Pattern.compile("<\\w.+?/>");

        String [] lines = xml.split("\n\\s*");

        for (String line : lines) {
            Matcher mOpening = tagOpen.matcher(line);
            Matcher mClosing = tagClose.matcher(line);
            Matcher mBody = tagBody.matcher(line);
            Matcher mEmpty = tagEmpty.matcher(line);
            if (mEmpty.find()) {
                strBuilder.append(mEmpty.group());
                strBuilder.append(" - tag without body\n");
            }
            else if (mOpening.find()) {
                strBuilder.append(mOpening.group());
                strBuilder.append(" - opening tag\n");
            }
            if (mBody.find()) {
                strBuilder.append(mBody.group().substring(1));
                strBuilder.append("\b - tag content\n");
            }
            if (mClosing.find()) {
                strBuilder.append(mClosing.group());
                strBuilder.append(" - closing tag\n");
            }

        }
        return strBuilder.toString();
    }
    public static void main(String[] args) {
        String xml = "<notes>\n" +
                "    <note id = \"1\">\n" +
                "        <to>Вася</to>\n" +
                "        <from>Света</from>\n" +
                "        <heading>Напоминание</heading>\n" +
                "        <body>Позвони мне завтра!</body>\n" +
                "    </note>\n" +
                "    <note id = \"2\">\n" +
                "        <to>Петя</to>\n" +
                "        <from>Маша</from>\n" +
                "        <heading>Важное напоминание</heading>\n" +
                "        <body/>\n" +
                "    </note>\n" +
                " </notes> \n";
        String xmlAnalysis = xmlAnalyzer(xml);
        System.out.println(xmlAnalysis);
    }
}
