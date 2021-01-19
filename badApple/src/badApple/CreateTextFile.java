package badApple;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.imageio.ImageIO;

public class CreateTextFile {
	int i = 0;
	String imgPath = "D:\\badApple\\ba00";
	String textPath = "D:\\badAppleText\\badtext";
	int rgb[] = new int[3];
	int width;
	int height;
	int minx;
	int miny;
	
	void create(){
		try {
			for(i = 0; i < 10; i++){
				BufferedImage image = ImageIO.read(new FileInputStream(imgPath+"000"+i+".jpg"));
				File badtext = new File(textPath+i+".txt");
				writeInto(image, badtext);
			}
			for(i = 10; i < 100; i++){
				BufferedImage image = ImageIO.read(new FileInputStream(imgPath+"00"+i+".jpg"));
				File badtext = new File(textPath+i+".txt");
				writeInto(image, badtext);
			}
			for(i = 100; i < 1000; i++){
				BufferedImage image = ImageIO.read(new FileInputStream(imgPath+"0"+i+".jpg"));
				File badtext = new File(textPath+i+".txt");
				writeInto(image, badtext);
			}
			for(i = 1000; i < 5434; i++){
				BufferedImage image = ImageIO.read(new FileInputStream(imgPath+i+".jpg"));
				File badtext = new File(textPath+i+".txt");
				writeInto(image, badtext);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void writeInto(BufferedImage img, File f) throws IOException{
		width = img.getWidth();
		height = img.getHeight();
		minx = img.getMinX();
		miny = img.getMinY();
		Writer out = new FileWriter(f, true);
		BufferedWriter bf = new BufferedWriter(out);
		for (int y = miny; y < height; y++) {
			for (int x = minx; x < width; x++) {
				int picolor = img.getRGB(x, y);
				rgb[0] = (picolor & 0xff0000) >> 16;
				rgb[1] = (picolor & 0xff00) >> 8;
				rgb[2] = (picolor & 0xff);
				if (rgb[0] > 200 || rgb[1] > 200 || rgb[2] > 200)
					bf.write("M");
				else
					bf.write(" ");
			}
			//bf.newLine();
		}
		bf.close();
		out.close();
	}
	
}
