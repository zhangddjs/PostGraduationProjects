package Base64;

import java.io.*;

public class Base64OutputStream extends FilterOutputStream{
	private int _column = 0;
	private int _index = 0;
	private int _buffer[] = new int[3];
	private static char[] toBase64 = 
		{'A','B','C','D','E','F','G','H',
		 'I','J','K','L','M','N','O','P',
		 'Q','R','S','T','U','V','W','X',
		 'Y','Z','a','b','c','d','e','f',
		 'g','h','i','j','k','l','m','n',
		 'o','p','q','r','s','t','o','v',
		 'w','x','y','z','0','1','2','3',
		 '4','5','6','7','8','9','+','/'};
	
	public Base64OutputStream(OutputStream out){
		super(out);
	}
	
	public void write(int c) throws IOException{
		_buffer[_index] = c;
		_index++;
		if(_index == 3){
			super.write(toBase64[(_buffer[0]&0xfc)>>2]);
			super.write(toBase64[((_buffer[0]&0x03)<<4) |
					((_buffer[1]&0xf0)>>4)]);
			super.write(toBase64[((_buffer[1]&0x0f)<<2) |
			 		((_buffer[2]&0xc0)>>6)]);
			super.write(toBase64[_buffer[2]&0x3f]);
			_column += 4;
			_index = 0;
			if(_column >= 76){
				super.write('\n');
				_column = 0;
			}
		}
	}
	
	public void flush() throws IOException{
		if(_index == 1){
			super.write(toBase64[(_buffer[2]&0x3f)>>2]);
			super.write(toBase64[(_buffer[0]&0x03)<<4]);
			super.write('=');
			super.write('=');
		}
		
		else if(_index == 2){
			super.write(toBase64[(_buffer[0]&0xfc)>>2]);
			super.write(toBase64[((_buffer[0]&0x03)<<4) |
			 					((_buffer[1]&0xf0)>>4)]);
			super.write(toBase64[(_buffer[1]&0x0f)<<2]);
			super.write('=');
		}
		
	}
	
}
