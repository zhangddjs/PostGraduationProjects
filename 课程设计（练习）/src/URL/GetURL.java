package URL;

import java.io.*;
import java.net.*;

public class GetURL {
	static protected void getURL(String u){
		URL url;
		InputStream is;
		InputStreamReader isr;
		BufferedReader r;
		String str;
		try{
			System.out.println("Reading URL:" + u);
			url = new URL(u);
			is = url.openStream();
			isr = new InputStreamReader(is);
			r = new BufferedReader(isr);
			do{
				str = r.readLine();
				if(str != null)
					System.out.println(str);
			} while (str!=null);
		} catch(MalformedURLException e){
			System.out.println("Must enter a valid URL");
		} catch(IOException e){
			System.out.println("Can't connection");
		}
	}
	
	static public void main(String args[]){
		if(args.length < 1)
			System.out.println("Usage:GetURL");
		else
			getURL(args[0]);
	}
}
