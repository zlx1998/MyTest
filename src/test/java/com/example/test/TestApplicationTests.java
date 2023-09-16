package com.example.test;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.test.domain.Education;
import com.spire.pdf.PdfDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
        int[] nums = new int[]{2, 5, 5, 11};
        int target = 10;
        int[] result = twoSum(nums, target);
        System.out.println("twoSum(nums, target) = " + Arrays.toString(result));
    }
    
    @Test
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{ map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

//    }
//    @Test
//    public int[] twoSum1(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 1; j < nums.length; j++) {
//                if (j != i && nums[j] + nums[i] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }

    @Test
    public void pdf2Image() throws IOException, PDFException, PDFSecurityException {
        //Loading an existing PDF document
        File file = new File("C:\\Users\\zlx\\Downloads\\原文_163049591\\（已压缩）张锦.pdf");
        PDDocument document = PDDocument.load(file);

		//Instantiating the PDFRenderer class
        PDFRenderer renderer = new PDFRenderer(document);
		// 提取的页码
		int pageNumber = 0;
		// 以300 dpi 读取存入 BufferedImage 对象
		int dpi = 300;
		//Renderer类的renderImage()方法在特定页面中渲染图像
//		BufferedImage image = renderer.renderImageWithDPI(pageNumber, dpi, ImageType.RGB);
        //Rendering an image from the PDF document
        BufferedImage image = renderer.renderImage(0);

		//Writing the image to a file
        ImageIO.write(image, "PNG", new File("C:\\Users\\zlx\\Downloads\\张理想.png"));

        System.out.println("Image created");
		//Closing the document
        document.close();//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/pdfbox/pdfbox_extracting_image.html


    }

	/**
	 * 截取pdf第一页为图片 返回流
	 * @param pdfInputStream
	 * @throws IOException
	 */
	@Test
	private InputStream pdf2Image(InputStream pdfInputStream) throws IOException {
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
		}
	}


	@Test
	public void pdf2img() throws IOException {
		PdfDocument pdf = new PdfDocument("C:\\Users\\zlx\\Downloads\\原文_163049591\\（已压缩）施仁清.pdf");
//		InputStream in = new FileInputStream(file);
//		PdfDocument pdf = new PdfDocument();
//		pdf.loadFromStream(in);
		BufferedImage image;
//		for(int i = 0; i< pdf.getPages().getCount();i++){
			image = pdf.saveAsImage(0);
//			File file = new File( String.format("ToImage-img-%d.png", i));
			ImageIO.write(image, "PNG", new File("C:\\Users\\zlx\\Downloads\\施仁清.PNG"));
//		}
//		pdf.close();
	}

	@Test
	public Education ceshi(String s ,Integer ...opt) {
		Education education = new Education();

		try {
			System.out.println("opt = " + opt);
			if (opt.length == 0 || opt[1] != 1) {
				System.out.println("opt = " + opt);
			}
		}finally {
			System.out.println("education = " + education);
			return education;
		}
	}

	@Test
	void cesdasd() {
		Education ceshi = ceshi(null);
		System.out.println("ceshi = " + ceshi);
	}

	@Test
	void ce1() {
		String s = "1,2,3,4,5,6,7,8";
		String[] split = s.split(",");
		int length = split.length;
		System.out.println("length = " + length);
		for (String s1 : split) {
			System.out.println("s1 = " + s1);
		}
	}

	@Test
	void urlTest() throws ParseException {

		String url = "{\n" +
				"  \"body\": {\n" +
				"    \"data\": {\n" +
				"      \"addressDistin\": \"1\",\n" +
				"      \"codeUrl\": \"http://10.78.152.38:10012/interface/fileupload/doUpload\",\n" +
				"      \"content\": \"202391578264407106/64d37f1af3a545ce8ac24241ea974818/2\",\n" +
				"      \"token\": \"2391188d-3ae7-4588-a885-c7f1149411d6\"\n" +
				"    },\n" +
				"    \"message\": \"处理成功\"\n" +
				"  },\n" +
				"  \"header\": {\n" +
				"    \"apiCode\": \"391-0002\",\n" +
				"    \"errorcode\": \"\",\n" +
				"    \"errorinfo\": \"\",\n" +
				"    \"serviceCode\": \"32000061902\",\n" +
				"    \"sourceCode\": \"320000-9-2101\",\n" +
				"    \"status\": \"00\",\n" +
				"    \"version\": \"1.0\"\n" +
				"  }\n" +
				"}";
		JSONObject jsonObject = JSONObject.parseObject(url);
		Map body = (Map) jsonObject.get("body");
		Map data = (Map) body.get("data");
		String codeUrl = data.get("codeUrl").toString();
		System.out.println("codeUrl = " + codeUrl);
		System.out.println("data = " + data);
		String s = HttpUtil.get(codeUrl, 1);

		System.out.println("s = " + s);
	}
}
