package jp.blackawa.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;

/**
 * 日本語でこんにちは
 */
public class HelloWorldPage {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);

        PDFont font = PDType0Font.load(doc, new File("src/main/resources/font_1_honokamin.ttf"));
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.moveTextPositionByAmount(100, 700);
        contentStream.drawString("Hello world, こんにちは世界");
        contentStream.endText();
        contentStream.close();

        doc.save("HelloWorld.pdf");
        doc.close();
    }
}
