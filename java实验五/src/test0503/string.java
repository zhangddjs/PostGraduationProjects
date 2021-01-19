package test0503;

public final class string {
	private final char[] arr;

	public string(char a[]) {
		arr = new char[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
	}
	void tostring(){
		System.out.println(arr);
	}

	int length() {
		return arr.length;
	}

	boolean compare(string c) {
		int i;
		if (arr.length != c.arr.length) {
			System.out.println("不相等！");
			return false;
		} else {
			for (i = 0; i < arr.length; i++) {
				if (arr[i] != c.arr[i]) {
					System.out.println("不相等！");
					return false;
				}
				System.out.println("相等!");
				return true;
			}
			return true;
		}
	}

	public int index(char b) {
		int c = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == b) {
				c = i+1;
				break;
			}
		}
		return c;
	}

	void change(string a) {
		char[] d = new char[a.arr.length];
	}
}
