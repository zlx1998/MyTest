package com.example.test.util;

//import gui.ava.html.image.generator.HtmlImageGenerator;

import com.spire.pdf.PdfDocument;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PdfUtil {
	/**
	 * 多页pdf 转jpg
	 *
	 * @param pdfPath
	 */
	public static List<String> pdfCovertToJpg(String pdfPath, String pdfName) throws PDFException {
		String filePath = pdfPath + "/" + pdfName + ".pdf";
		Document document = new Document();
		List<String> jpgNamePath = new ArrayList<String>();
		try {
			document.setFile(filePath);
		} catch (PDFSecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//float scale = 4/3f;// 缩放比例（大图）  pdf以pt 为单位，图片以px为单位，1pt=4/3px
		float scale = 2.5f;// 缩放比例（小图）
		float rotation = 0f;// 旋转角度
		for (int i = 0; i < document.getNumberOfPages(); i++) {
			BufferedImage image = (BufferedImage) document.getPageImage(i, GraphicsRenderingHints.SCREEN, org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation, scale);
			RenderedImage rendImage = image;
			try {
				File file = new File(pdfPath + "/" + pdfName + "_" + i + ".jpg");
				// 这里png作用是：格式是jpg但有png清晰度
				//ImageIO.write(rendImage, "png", file);
				ImageIO.write(rendImage, "jpg", file);
				String name = pdfPath + "/" + pdfName + "_" + i + ".jpg";
				jpgNamePath.add(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.flush();
		}
		document.dispose();
		return jpgNamePath;
	}

	public static int DEFAULT_IMAGE_WIDTH = 1200;
	public static int DEFAULT_IMAGE_HEIGHT = 700;

	/**
	 * html转换为ｊｐｅｇ文件
	 *
	 * @param bgColor 图片的背景色
	 * @param html    html的文本信息
	 * @param width   显示图片的Ｔｅｘｔ容器的宽度
	 * @param height  显示图片的Ｔｅｘｔ容器的高度
	 * @param eb      設置容器的边框
	 * @return
	 * @throws Exception
	 */
	public static String html2jpeg(Color bgColor, String html, int width,
								   int height, EmptyBorder eb, String name) throws Exception {
		String imageName = name;
		JTextPane tp = new JTextPane();
		tp.setSize(width, height);
		if (eb == null) {
			eb = new EmptyBorder(0, 50, 0, 50);
		}
		if (bgColor != null) {
			tp.setBackground(bgColor);
		}
		if (width <= 0) {
			width = DEFAULT_IMAGE_WIDTH;
		}
		if (height <= 0) {
			height = DEFAULT_IMAGE_HEIGHT;
		}
		tp.setBorder(eb);
		tp.setContentType("text/html");
		tp.setText(html);

		int pageIndex = 1;
		boolean bcontinue = true;
		String resUrl = "";
		byte[] bytes = null;
		while (bcontinue) {
			BufferedImage image = new BufferedImage(width,
					height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.setClip(0, 0, width, height);
			bcontinue = paintPage(g, height, pageIndex, tp);
			g.dispose();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);

			baos.flush();
			bytes = baos.toByteArray();
			baos.close();
			//FileUtils.writeByteArrayToFile(new File(imageName), bytes);
			//写入阿里云
			pageIndex++;
			PdfUtil.bytesToFile(bytes, imageName);
		}
		return imageName;
	}

	public static boolean paintPage(Graphics g, int hPage, int pageIndex, JTextPane panel) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = ((BasicEditorPaneUI) panel.getUI()).getPreferredSize(panel);
		double panelHeight = d.height;
		double pageHeight = hPage;
		int totalNumPages = (int) Math.ceil(panelHeight / pageHeight);
		g2.translate(0f, -(pageIndex - 1) * pageHeight);
		panel.paint(g2);
		boolean ret = true;

		if (pageIndex >= totalNumPages) {
			ret = false;
			return ret;
		}
		return ret;
	}

	public static void bytesToFile(byte[] buffer, final String filePath) {

		File file = new File(filePath);

		OutputStream output = null;
		BufferedOutputStream bufferedOutput = null;

		try {
			output = new FileOutputStream(file);

			bufferedOutput = new BufferedOutputStream(output);

			bufferedOutput.write(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != bufferedOutput) {
				try {
					bufferedOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != output) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}

	/**
	 * 获得指定文件的byte数组
	 *
	 * @param filePath 文件绝对路径
	 * @return
	 */
	public static byte[] file2Byte(String filePath) {
		ByteArrayOutputStream bos = null;
		BufferedInputStream in = null;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("file not exists");
			}
			bos = new ByteArrayOutputStream((int) file.length());
			in = new BufferedInputStream(new FileInputStream(file));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * 根据byte数组，生成文件
	 *
	 * @param bfile    文件数组
	 * @param filePath 文件存放路径
	 * @param fileName 文件名称
	 */
	public static void byte2File(byte[] bfile, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && !dir.isDirectory()) {//判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bfile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * 去除转换成的pdf的多余页数
	 *
	 * @param path
	 * @param page
	 * @param size
	 */
	public static String RemovingPagesFromPdf(String path, int page, int size) {
		System.out.println("开始去除空白页面=========" + path);
		File file = new File(path);
		PDDocument doc = null;
		try {
			doc = PDDocument.load(file);
			for (int i = size; i < page; i++) {
				doc.removePage(i);
			}
			String pathNew = path.substring(0, path.indexOf(".")) + "_1.pdf";
			doc.save(pathNew);
			System.out.println("返回pathNew====================" + pathNew);
			return pathNew;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				doc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void pdf2png(String fileAddress, String filename, String type) {
		// 将pdf装图片 并且自定义图片得格式大小
		File file = new File(fileAddress + "\\" + filename + ".pdf");
		try {
			PDDocument doc = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(doc);
			int pageCount = doc.getNumberOfPages();
			for (int i = 0; i < pageCount; i++) {
				BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
//				 BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
				ImageIO.write(image, type, new File(fileAddress + "\\" + filename + "_" + (i + 1) + "." + type));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 自由确定起始页和终止页
	 *
	 * @param fileAddress  文件地址
	 * @param filename     pdf文件名
	 * @param indexOfStart 开始页  开始转换的页码，从0开始
	 * @param indexOfEnd   结束页  停止转换的页码，-1为全部
	 * @param type         图片类型
	 */
	public static void pdf2png(String fileAddress, String filename, int indexOfStart, int indexOfEnd, String type) {
		// 将pdf装图片 并且自定义图片得格式大小
		File file = new File(fileAddress + "\\" + filename + ".pdf");
		try {
			PDDocument doc = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(doc);
			int pageCount = doc.getNumberOfPages();
			for (int i = indexOfStart; i < indexOfEnd; i++) {
				BufferedImage image = renderer.renderImageWithDPI(i, 144); // Windows native DPI
				// BufferedImage srcImage = resize(image, 240, 240);//产生缩略图
				ImageIO.write(image, type, new File(fileAddress + "\\" + filename + "_" + (i + 1) + "." + type));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 截取pdf第一页为图片 返回流
	 * 使用 spire.pdf 处理小于100k的pdf
	 * @param pdfInputStream
	 * @throws IOException
	 */
	public static InputStream pdf2ImageForSpire(InputStream pdfInputStream) throws IOException {
		//加载 PDF 流
		PdfDocument document = new PdfDocument();
		document.loadFromStream(pdfInputStream);
		BufferedImage image;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			image = document.saveAsImage(0);
			//把第一张图片写到流里面
			ImageIO.write(image, "PNG", os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (IOException e) {
			throw e;
		} finally {
			//关闭 流
			document.close();
			os.close();
			IOUtils.closeQuietly(pdfInputStream);
		}
	}

	/**
	 * 截取pdf第一页为图片 返回流
	 * 使用Pdfbox插件
	 * @param pdfInputStream
	 * @throws IOException
	 */
	public static InputStream pdf2Image(InputStream pdfInputStream) throws IOException {
		//加载 PDF 流
		PDDocument document = PDDocument.load(pdfInputStream);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			//实例化PDFRenderer
			PDFRenderer renderer = new PDFRenderer(document);

			//从pdf文档中读取第一页为图片
			BufferedImage image = renderer.renderImage(0);

			//把第一张图片写到流里面
			ImageIO.write(image, "PNG", os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (IOException e) {
			throw e;
		} finally {
			//关闭 流
			document.close();
			os.close();
			IOUtils.closeQuietly(pdfInputStream);
		}
	}
}
