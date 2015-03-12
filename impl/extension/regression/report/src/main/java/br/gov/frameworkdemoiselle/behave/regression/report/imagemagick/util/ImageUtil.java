package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static void imageConvert(String srcImage, String targetImage) throws Exception {
		BufferedImage src = readImage(srcImage);
		BufferedImage target = readImage(targetImage);

		if (src.getHeight() > target.getHeight()) {
			cropImage(srcImage, src, src.getWidth(), target.getHeight(), 0, 0);

		} else if (target.getHeight() > src.getHeight()) {
			cropImage(targetImage, target, target.getWidth(), src.getHeight(), 0, 0);
		}

		if (src.getWidth() > target.getWidth()) {
			cropImage(srcImage, src, target.getWidth(), src.getHeight(), 0, 0);
		} else if (target.getWidth() > src.getWidth()) {
			cropImage(targetImage, target, src.getWidth(), target.getHeight(), 0, 0);
		}
	}

	public static BufferedImage readImage(String fileLocation) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileLocation));
//			System.out.println("Image Read. Image Dimension: " + img.getWidth() + "w X " + img.getHeight() + "h");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public static void cropImage(String filepath, BufferedImage img, int cropWidth, int cropHeight, int cropStartX, int cropStartY) throws Exception {
		BufferedImage clipped = null;

//		System.out.println("Crop Width " + cropWidth);
//		System.out.println("Crop Height " + cropHeight);
//		System.out.println("Crop Location " + "(" + cropStartX + "," + cropStartY + ")");

		clipped = img.getSubimage(cropStartX, cropStartY, cropWidth, cropHeight);

		System.out.println("Image Cropped. New Image Dimension: " + clipped.getWidth() + "w X " + clipped.getHeight() + "h");

		File outputfile = new File(filepath);
		ImageIO.write(clipped, "png", outputfile);

	}

}
