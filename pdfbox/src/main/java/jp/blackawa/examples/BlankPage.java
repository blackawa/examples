package jp.blackawa.examples;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

/**
 * 空ページ
 */
public class BlankPage {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();

        PDPage firstPage = new PDPage();
        doc.addPage(firstPage);
        doc.save("Blank.pdf");
        doc.close();
    }
}
