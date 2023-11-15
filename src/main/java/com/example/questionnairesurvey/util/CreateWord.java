package com.example.questionnairesurvey.util;

import com.example.questionnairesurvey.entity.Questionnaire;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateWord {
    public static  void createDocument(Questionnaire questionnaire) throws IOException {
        LocalDate currentDate =LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formattedDate = currentDate.format(formatter);

        Map<String ,String > map = new HashMap<>();

        map.put("${department}",questionnaire.getDepartment());
        map.put("${charge}",questionnaire.getCharge());
        map.put("${Q2_ANSWER_TEXT}", questionnaire.getQ2_ANSWER_TEXT());
        map.put("${Q3_ANSWER_TEXT}", questionnaire.getQ3_ANSWER_TEXT());
        map.put("${name}", questionnaire.getName());
        map.put("${date}",formattedDate);

        OPCPackage opcPackage = POIXMLDocument.openPackage("/Users/bigfish/Desktop/(サンクス)○○○支社（代理店名）.docx");

        XWPFDocument doc = new XWPFDocument(opcPackage);

        List<XWPFParagraph> paragraphs = doc.getParagraphs();
        for (XWPFParagraph par : paragraphs){
            List<XWPFRun> runs = par.getRuns();
            for (XWPFRun run : runs){
                String text = run.getText(0);

                for (Map.Entry<String,String> entry : map.entrySet()){
                    String key = entry.getKey();

                    if (text != null && text.indexOf(key) != -1){
                        Object value = entry.getValue();
                        text =text.replace(key, value.toString());

                        run.setText(text,0);
                    }
                }
            }
        }

        String outPath = "/Users/bigfish/Desktop/" + questionnaire.getDepartment() + "支社out.docx";
        File file = new File(outPath);
        FileOutputStream fileOutputStream =new FileOutputStream(file);
        doc.write(fileOutputStream);
    }



}

