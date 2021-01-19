package Http;

import java.io.*;
import java.net.*;

public class WebServer {
	protected void start(){
		ServerSocket s;
		System.out.println("Webserver starting up on port 80");
		System.out.println("(press ctrl-c to exit)");
		try{
			s = new ServerSocket(8081);
		} catch (Exception e) {
			System.out.println("Error:" + e);
			return;
		}
		System.out.println("Waiting for connection");
		for(;;) {
			try{
				Socket remote = s.accept();
				System.out.println("Connection, sending data.");
				BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
				PrintWriter out = new PrintWriter(remote.getOutputStream());
				String str = ".";
				while(!str.equals(""))
					str = in.readLine();
				out.println("HTTP/1.0 200 OK");
				out.println("Content-Type: text/html");
				out.println("Server:Bot");
				out.println("");
				out.println("<H1>Welcome to the Ultra Mini-WebServer</H1>");
				out.flush();
				remote.close();
			} catch (Exception e) {
				System.out.println("Error:" + e);
			}
		}
	}
	
	public static void main(String args[]){
		WebServer ws = new WebServer();
		ws.start();
	}
}
