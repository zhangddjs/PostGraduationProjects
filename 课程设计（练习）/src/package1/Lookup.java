package package1;

import java.net.InetAddress;

public class Lookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			if(args.length == 0){
				System.out.println("Call with one parameter that specifies the host" + "to lookup.");
			} else {
				InetAddress[] address = InetAddress.getAllByName(args[0]);
				for (int i = 0; i < address.length; i++) {
					System.out.println(address[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("Could not find" + args[0]);
		}

	}

}
