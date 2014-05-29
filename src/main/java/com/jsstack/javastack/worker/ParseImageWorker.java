package com.jsstack.javastack.worker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.jsstack.javastack.constant.Global;
import com.jsstack.javastack.dao.Dao;
import com.jsstack.javastack.dao.IDao;
import com.jsstack.javastack.filestorage.FileStorageManager;
import com.jsstack.javastack.filestorage.IFileStorage;
import com.jsstack.javastack.model.FingerPrint1x1;
import com.jsstack.javastack.model.FingerPrint2x2;
import com.jsstack.javastack.model.FingerPrint3x3;
import com.jsstack.javastack.model.FingerPrint4x4;
import com.jsstack.javastack.model.FingerPrintGray1x1;
import com.jsstack.javastack.model.FingerPrintGray2x2;
import com.jsstack.javastack.model.FingerPrintGray3x3;
import com.jsstack.javastack.model.FingerPrintGray4x4;
import com.jsstack.javastack.model.Image;

public class ParseImageWorker implements IWorker {

	private IDao dao = new Dao();
	private IFileStorage fs = FileStorageManager.get();

	@Override
	public String getQueue() {
		return Global.ImageService.PARSE_IMAGE_MQ;
	}

	@Override
	public void process(String msg) {
		int id = Integer.parseInt(msg);
		Image img = dao.findById(Image.class, id);
		BufferedImage bImage = getScaledImage(img);
		String thumbnailPath = generateThumbnail(img.getImagePath(), bImage);
		img.setThumbnailPath(thumbnailPath);

		dao.insert(img);

		generateFingerPrints(img, bImage);
	}

	private String generateThumbnail(String imagePath, BufferedImage bImage) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(bImage, "png", baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream is = new ByteArrayInputStream(baos.toByteArray());

		try {
			fs.write("t" + imagePath, is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "t" + imagePath;
	}

	private void generateFingerPrints(Image img, BufferedImage bImage) {
		for (int i = 1; i < 5; i++) {
			float[][] hsvs = generateFingerPrint(bImage, i, false);
			addFingerPrint(i, img.getId(), hsvs, true);
			hsvs = generateFingerPrint(bImage, i, true);
			addFingerPrint(i, img.getId(), hsvs, true);
		}

	}

	private BufferedImage getScaledImage(Image img) {
		BufferedImage bImage = null;
		try {
			bImage = ImageIO.read(fs.read(img.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int w = bImage.getWidth();
		int h = bImage.getHeight();

		int x = w > h ? (w - h) / 2 : 0;
		int y = h > w ? (h - w) / 2 : 0;

		bImage = bImage.getSubimage(x, y, w, h);
		return bImage;
	}

	private void addFingerPrint(int size, int imageId, float[][] hsvs,
			boolean isGray) {
		if (isGray) {
			switch (size) {
			case 1:
				assert (hsvs.length == 1);
				FingerPrintGray1x1 fp = new FingerPrintGray1x1();
				fp.setImageId(imageId);
				fp.setV1(hsvs[0][2]);
				dao.insert(fp);
				break;
			case 2:
				assert (hsvs.length == 2 * 2);
				FingerPrintGray2x2 fp2x2 = new FingerPrintGray2x2();
				fp2x2.setImageId(imageId);
				fp2x2.setV1(hsvs[0][2]);
				fp2x2.setV2(hsvs[1][2]);
				fp2x2.setV3(hsvs[2][2]);
				fp2x2.setV4(hsvs[3][2]);
				dao.insert(fp2x2);
				break;
			case 3:
				assert (hsvs.length == 3 * 3);
				FingerPrintGray3x3 fp3x3 = new FingerPrintGray3x3();
				fp3x3.setImageId(imageId);
				fp3x3.setV1(hsvs[0][2]);
				fp3x3.setV2(hsvs[1][2]);
				fp3x3.setV3(hsvs[2][2]);
				fp3x3.setV4(hsvs[3][2]);
				fp3x3.setV5(hsvs[4][2]);
				fp3x3.setV6(hsvs[5][2]);
				fp3x3.setV7(hsvs[6][2]);
				fp3x3.setV8(hsvs[7][2]);
				fp3x3.setV9(hsvs[8][2]);
				dao.insert(fp3x3);
				break;
			case 4:
				assert (hsvs.length == 4 * 4);
				FingerPrintGray4x4 fp4x4 = new FingerPrintGray4x4();
				fp4x4.setImageId(imageId);
				fp4x4.setV1(hsvs[0][2]);
				fp4x4.setV2(hsvs[1][2]);
				fp4x4.setV3(hsvs[2][2]);
				fp4x4.setV4(hsvs[3][2]);
				fp4x4.setV5(hsvs[4][2]);
				fp4x4.setV6(hsvs[5][2]);
				fp4x4.setV7(hsvs[6][2]);
				fp4x4.setV8(hsvs[7][2]);
				fp4x4.setV9(hsvs[8][2]);
				fp4x4.setV10(hsvs[9][2]);
				fp4x4.setV11(hsvs[10][2]);
				fp4x4.setV12(hsvs[11][2]);
				fp4x4.setV13(hsvs[12][2]);
				fp4x4.setV14(hsvs[13][2]);
				fp4x4.setV15(hsvs[14][2]);
				fp4x4.setV16(hsvs[15][2]);
				dao.insert(fp4x4);
				break;
			default:
				System.out.println("No model for this size: " + size);
			}
		} else {
			switch (size) {
			case 1:
				assert (hsvs.length == 1);
				FingerPrint1x1 fp = new FingerPrint1x1();
				fp.setImageId(imageId);
				fp.setH1(hsvs[0][0]);
				fp.setS1(hsvs[0][1]);
				fp.setV1(hsvs[0][2]);

				dao.insert(fp);
				break;
			case 2:
				assert (hsvs.length == 2 * 2);
				FingerPrint2x2 fp2x2 = new FingerPrint2x2();
				fp2x2.setImageId(imageId);
				fp2x2.setH1(hsvs[0][0]);
				fp2x2.setS1(hsvs[0][1]);
				fp2x2.setV1(hsvs[0][2]);
				fp2x2.setH2(hsvs[1][0]);
				fp2x2.setS2(hsvs[1][1]);
				fp2x2.setV2(hsvs[1][2]);
				fp2x2.setH3(hsvs[2][0]);
				fp2x2.setS3(hsvs[2][1]);
				fp2x2.setV3(hsvs[2][2]);
				fp2x2.setH4(hsvs[3][0]);
				fp2x2.setS4(hsvs[3][1]);
				fp2x2.setV4(hsvs[3][2]);
				dao.insert(fp2x2);
				break;
			case 3:
				assert (hsvs.length == 3 * 3);
				FingerPrint3x3 fp3x3 = new FingerPrint3x3();
				fp3x3.setImageId(imageId);
				fp3x3.setH1(hsvs[0][0]);
				fp3x3.setS1(hsvs[0][1]);
				fp3x3.setV1(hsvs[0][2]);
				fp3x3.setH2(hsvs[1][0]);
				fp3x3.setS2(hsvs[1][1]);
				fp3x3.setV2(hsvs[1][2]);
				fp3x3.setH3(hsvs[2][0]);
				fp3x3.setS3(hsvs[2][1]);
				fp3x3.setV3(hsvs[2][2]);
				fp3x3.setH4(hsvs[3][0]);
				fp3x3.setS4(hsvs[3][1]);
				fp3x3.setV4(hsvs[3][2]);
				fp3x3.setH5(hsvs[4][0]);
				fp3x3.setS5(hsvs[4][1]);
				fp3x3.setV5(hsvs[4][2]);
				fp3x3.setH6(hsvs[5][0]);
				fp3x3.setS6(hsvs[5][1]);
				fp3x3.setV6(hsvs[5][2]);
				fp3x3.setH7(hsvs[6][0]);
				fp3x3.setS7(hsvs[6][1]);
				fp3x3.setV7(hsvs[6][2]);
				fp3x3.setH8(hsvs[7][0]);
				fp3x3.setS8(hsvs[7][1]);
				fp3x3.setV8(hsvs[7][2]);
				fp3x3.setH9(hsvs[8][0]);
				fp3x3.setS9(hsvs[8][1]);
				fp3x3.setV9(hsvs[8][2]);
				dao.insert(fp3x3);
				break;
			case 4:
				assert (hsvs.length == 4 * 4);
				FingerPrint4x4 fp4x4 = new FingerPrint4x4();
				fp4x4.setImageId(imageId);
				fp4x4.setH1(hsvs[0][0]);
				fp4x4.setS1(hsvs[0][1]);
				fp4x4.setV1(hsvs[0][2]);
				fp4x4.setH2(hsvs[1][0]);
				fp4x4.setS2(hsvs[1][1]);
				fp4x4.setV2(hsvs[1][2]);
				fp4x4.setH3(hsvs[2][0]);
				fp4x4.setS3(hsvs[2][1]);
				fp4x4.setV3(hsvs[2][2]);
				fp4x4.setH4(hsvs[3][0]);
				fp4x4.setS4(hsvs[3][1]);
				fp4x4.setV4(hsvs[3][2]);
				fp4x4.setH5(hsvs[4][0]);
				fp4x4.setS5(hsvs[4][1]);
				fp4x4.setV5(hsvs[4][2]);
				fp4x4.setH6(hsvs[5][0]);
				fp4x4.setS6(hsvs[5][1]);
				fp4x4.setV6(hsvs[5][2]);
				fp4x4.setH7(hsvs[6][0]);
				fp4x4.setS7(hsvs[6][1]);
				fp4x4.setV7(hsvs[6][2]);
				fp4x4.setH8(hsvs[7][0]);
				fp4x4.setS8(hsvs[7][1]);
				fp4x4.setV8(hsvs[7][2]);
				fp4x4.setH9(hsvs[8][0]);
				fp4x4.setS9(hsvs[8][1]);
				fp4x4.setV9(hsvs[8][2]);
				fp4x4.setH10(hsvs[9][0]);
				fp4x4.setS10(hsvs[9][1]);
				fp4x4.setV10(hsvs[9][2]);
				fp4x4.setH11(hsvs[10][0]);
				fp4x4.setS11(hsvs[10][1]);
				fp4x4.setV11(hsvs[10][2]);
				fp4x4.setH12(hsvs[11][0]);
				fp4x4.setS12(hsvs[11][1]);
				fp4x4.setV12(hsvs[11][2]);
				fp4x4.setH13(hsvs[12][0]);
				fp4x4.setS13(hsvs[12][1]);
				fp4x4.setV13(hsvs[12][2]);
				fp4x4.setH14(hsvs[13][0]);
				fp4x4.setS14(hsvs[13][1]);
				fp4x4.setV14(hsvs[13][2]);
				fp4x4.setH15(hsvs[14][0]);
				fp4x4.setS15(hsvs[14][1]);
				fp4x4.setV15(hsvs[14][2]);
				fp4x4.setH16(hsvs[15][0]);
				fp4x4.setS16(hsvs[15][1]);
				fp4x4.setV16(hsvs[15][2]);
				dao.insert(fp4x4);
				break;
			default:
				System.out.println("No model for this size: " + size);
			}
		}
	}

	private float[][] generateFingerPrint(java.awt.Image img, int pixels,
			boolean isGray) {
		java.awt.Image imgScaled = img.getScaledInstance(pixels, pixels,
				java.awt.Image.SCALE_REPLICATE);
		BufferedImage bImage = new BufferedImage(pixels, pixels,
				isGray ? BufferedImage.TYPE_BYTE_GRAY
						: BufferedImage.TYPE_BYTE_BINARY);

		Graphics g = bImage.getGraphics();

		g.drawImage(imgScaled, 0, 0, null);

		g.dispose();

		float[][] result = new float[pixels * pixels][3];
		for (int y = 0; y < pixels; y++) {
			for (int x = 0; x < pixels; x++) {
				Color c = new Color(bImage.getRGB(x, y));
				result[y * pixels + x] = Color.RGBtoHSB(c.getRed(),
						c.getGreen(), c.getBlue(), null);
			}
		}

		return result;
	}

}
