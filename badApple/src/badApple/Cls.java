package badApple;

public class Cls {
	public native void clear();
	static {System.loadLibrary("ClsCpp");}
}
