import java.io.*;
import java.util.*;
public class InputInformation {
	static void Input(){
		System.out.println("输入文件的内容（输入#结束输入过程）");
		Scanner scanner=new Scanner(System.in);
		String content=scanner.nextLine();
		byte[] a=content.getBytes();
		File file=new File("a.txt");
		try{
			OutputStream out=new FileOutputStream(file,true);
			while(!content.equals("#")){
				out.write(a);
				content=scanner.nextLine();
				a=content.getBytes();
			}
			out.close();
		}
		catch(IOException e){
			System.out.println("Error"+e);
		}
		byte[] b=new byte[100];
		int n=-1;
		try{
			File f=new File("a.txt");
			InputStream in=new FileInputStream(f);
			while((n=in.read(b))!=-1){
				String s=new String(b,0,n);
				System.out.print(s);
			}
			in.close();
		}
		catch(IOException e){
			System.out.println("File read error"+e);
		}
	}
}
