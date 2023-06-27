package com.example.questionnairesurvey.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreateWord {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // 获取输入文件和输出文件的路径
        String inputFilePath = System.getProperty("user.dir") + "/template.docx";
        String outputFilePath = System.getProperty("user.dir") + "/output.docx";

        // 使用try-with-resources确保流资源在使用完毕后自动关闭
        try (InputStream fis = new FileInputStream(inputFilePath);
             XWPFDocument document = new XWPFDocument(fis);) {

            // 获取文档中的段落
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (int x = 0; x < paragraphs.size(); x++) {
                XWPFParagraph paragraph = paragraphs.get(x);
                System.out.println(paragraph.getParagraphText());
            }

            // 获取文档中的表格
            List<XWPFTable> tables = document.getTables();
            for (int x = 0; x < tables.size(); x++) {
                XWPFTable table = tables.get(x);
                List<XWPFTableRow> tableRows = table.getRows();

                // 移除表格中的指定行
                tableRows.remove(x);

                // 遍历表格的行
                for (int r = 0; r < tableRows.size(); r++) {
                    System.out.println("Row " + (r + 1) + ":");
                    XWPFTableRow tableRow = tableRows.get(r);
                    List<XWPFTableCell> tableCells = tableRow.getTableCells();

                    // 遍历表格的列
                    for (int c = 0; c < tableCells.size(); c++) {
                        System.out.print("Column " + (c + 1) + ": ");
                        XWPFTableCell tableCell = tableCells.get(c);
                        String tableCellVal = tableCell.getText();

                        // 判断是否是第二列，并替换指定文本
                        if ((c + 1) == 2) {
                            if (tableCellVal != null) {
                                if (tableCellVal.length() > 0) {
                                    String replacedText = null;

                                    // 替换文本
                                    if (tableCellVal.contains("@@VER2@@")) {
                                        replacedText = tableCellVal.replace("@@VER2@@", "Hello World!");
                                    }

                                    // 如果有替换的文本，则清除原有段落并设置新文本
                                    if (replacedText != null) {
                                        removeParagraphs(tableCell);
                                        tableCell.setText(replacedText);
                                    }
                                } else {
                                    // 处理空文本的情况
                                }
                            }
                        }
                        System.out.println("tableCell.getText(" + (c) + "):" + tableCellVal);
                    }
                }
                System.out.println("\n");
            }

            // 将修改后的文档写入输出文件
            document.write(new FileOutputStream(outputFilePath));
        }

        System.out.println("Done. See " + outputFilePath);
    }

    // 移除表格单元格中的所有段落
    private static void removeParagraphs(XWPFTableCell tableCell) {
        for (int i = 0; i < tableCell.getParagraphs().size(); i++) {
            tableCell.removeParagraph(i);
        }
    }
}

