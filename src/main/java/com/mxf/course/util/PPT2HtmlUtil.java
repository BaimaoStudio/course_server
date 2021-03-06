package com.mxf.course.util;

/**
 * Created by baimao
 * Time:2021/6/1
 */


import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.*;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * ppt 转 image
 *
 * @author TangFD@HF 2018/5/29
 */
public class PPT2HtmlUtil {

    @Value("${image.dirpath}")
    static String imgDir = "D://upload/";

    @Value("${image.webpath}")
    static String imgWebPath = "http://120.78.151.130:8383/upload/";

    public static String ppt2Html(File file) throws Exception {
        if (file.getName().endsWith("pptx")) {
            return pptx2Image(file);
        } else if (file.getName().endsWith("ppt")) {
           return ppt2Image(file);
        } else {
            throw new RuntimeException("file not ppt!");
        }
    }

    private static String ppt2Image(File pptFile) throws Exception {
        FileInputStream is = new FileInputStream(pptFile);
        SlideShow ppt = new SlideShow(is);
        is.close();
        Dimension pgsize = ppt.getPageSize();
        org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
        StringBuilder content = new StringBuilder();
        /*content.append("<input type=" + "button" + " value=" + "打印" + " href=" + "javascript:void(0);" +
                " onclick=" + "window.print();" + "  class=" + "noprint" + " style=" +
                "height:30px;width: 60px; padding-right:5px;align:right;float:left;FONT-WEIGHT: bold;" +
                "FONT-SIZE: 12pt;COLOR: #000000;FONT-FAMILY: Arial" + ">");*/
        for (int i = 0; i < slide.length; i++) {
            String image = UUID.randomUUID() + ".png";
            String webImagePath = imgWebPath + image;
            POIUtils.createDir(imgDir);
            try {
                TextRun[] textRuns = slide[i].getTextRuns();
                for (TextRun textRun : textRuns) {
                    RichTextRun[] richTextRuns = textRun.getRichTextRuns();
                    for (RichTextRun richTextRun : richTextRuns) {
                        richTextRun.setFontIndex(1);
                        richTextRun.setFontName("宋体");
                    }
                }

                BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
//                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                slide[i].draw(graphics);

                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(imgDir + image);
                ImageIO.write(img, "png", out);
                out.close();

                content.append("<br />");
                content.append("<p style=text-align:center;>");
                content.append("<img src=" + "\"").append(webImagePath).append("\"").append("/>");
                content.append("</p>");
                content.append("<br />");
            } catch (Exception e) {
                System.out.println("第" + i + "张ppt转换出错");
            }

        }
        return content.toString();
    }

    /**
     * 检查文件是否为PPT
     */
    private static boolean checkPPTFile(File file) {
        String fileName = file.getName();
        return fileName.endsWith(".ppt") || fileName.endsWith(".pptx");
    }

    private static String pptx2Image(File pptFile) throws Exception {
        FileInputStream is = new FileInputStream(pptFile);
        XMLSlideShow ppt = new XMLSlideShow(is);
        is.close();
        Dimension pgsize = ppt.getPageSize();
        StringBuilder content = new StringBuilder();
        /*content.append("<input type=" + "button" + " value=" + "打印" + " href=" + "javascript:void(0);" +
                " onclick=" + "window.print();" + "  class=" + "noprint" + " style=" +
                "height:30px;width: 60px; padding-right:5px;align:right;float:left;FONT-WEIGHT: bold;" +
                "FONT-SIZE: 12pt;COLOR: #000000;FONT-FAMILY: Arial" + ">");*/
        XSLFSlide[] slides = ppt.getSlides();
        for (int i = 0; i < slides.length; i++) {
            String image = UUID.randomUUID() + ".png";
            String webImagePath = imgWebPath + image;
            POIUtils.createDir(imgDir);
            try {
                // 防止中文乱码
                for (XSLFShape xslfShape : slides[i].getShapes()) {
                    if (!(xslfShape instanceof XSLFTextShape)) {
                        continue;
                    }
                    XSLFTextShape xslfTextShape = (XSLFTextShape) xslfShape;
                    for (XSLFTextParagraph xslfTextParagraph : xslfTextShape) {
                        for (XSLFTextRun xslfTextRun : xslfTextParagraph) {
                            xslfTextRun.setFontFamily("宋体");
                        }
                    }
                }
                BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                // clear the drawing area
//                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                // render
                slides[i].draw(graphics);
                // save the output
                FileOutputStream out = new FileOutputStream(imgDir + image);
                ImageIO.write(img, "png", out);
                out.close();
                content.append("<br />");
                content.append("<p style=text-align:center;>");
                content.append("<img src=" + "\"").append(webImagePath).append("\"").append("/>");
                content.append("</p>");
                content.append("<br />");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("第" + (i + 1) + "张ppt转换出错");
            }
        }
        return content.toString();
    }
}