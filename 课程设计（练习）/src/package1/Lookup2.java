package package1;

import java.net.InetAddress;

public class Lookup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			if(args.length == 0){
				System.out.println("Call with one parameter that specifies the host" + "to lookup.");
			} else {
				InetAddress address = InetAddress.getByName(args[0]);
				System.out.println(address.getHostName());
			}
		} catch (Exception e) {
			System.out.println("Could not find" + args[0]);
		}

	}

}
