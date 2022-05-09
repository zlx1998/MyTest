package com.example.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    public void pdf2Image() throws IOException {
        //Loading an existing PDF document
        File file = new File("/home/zlx/下载/document.pdf");
        PDDocument document = PDDocument.load(file);

        //Instantiating the PDFRenderer class
        PDFRenderer renderer = new PDFRenderer(document);

        //Rendering an image from the PDF document
        BufferedImage image = renderer.renderImage(1);

        //Writing the image to a file
        ImageIO.write(image, "JPEG", new File("/home/zlx/下载/myimage2.jpg"));

        System.out.println("Image created");

        //Closing the document
        document.close();//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/pdfbox/pdfbox_extracting_image.html


    }
}
