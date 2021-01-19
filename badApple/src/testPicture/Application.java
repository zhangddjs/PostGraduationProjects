package testPicture;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Application {
	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("cmd /k start cls");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String imgPath = "D:\\badApple\\ba000122.jpg";
		int rgb[] = new int[3];
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
			int width = image.getWidth();
			int height = image.getHeight();
			int minx = image.getMinX();
			int miny = image.getMinY();
			for (int y = miny; y < height; y++) {
				for (int x = minx; x < width; x++) {
					int picolor = image.getRGB(x, y);
					rgb[0] = (picolor & 0xff0000) >> 16;
					rgb[1] = (picolor & 0xff00) >> 8;
					rgb[2] = (picolor & 0xff);
					if (rgb[0] > 200 || rgb[1] > 200 || rgb[2] > 200)
						System.out.print("M");
					else
						System.out.print(" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
