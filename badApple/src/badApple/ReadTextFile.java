package badApple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
	String textPath = "D:\\badAppleText\\badtext";
	File f;
	int i = 0;
	final Cls clearScreen = new Cls();
	
	void open(){
		try {
			for (int i = 0; i < 5434; i++) {
				f = new File(textPath + i + ".txt");
				FileReader in = new FileReader(f);
				BufferedReader br = new BufferedReader(in);
				String str = null;
				while ((str = br.readLine()) != null) {
					System.out.print(str);
				}
				br.close();
				in.close();
				Thread.sleep(17);
				clearScreen.clear();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
