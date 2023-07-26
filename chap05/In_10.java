package chap05;

abstract class PairMap {
	protected String keyArray [];
	protected String valueArray [];
	abstract String get(String key);
	abstract void put(String key, String value);
	abstract String delete(String key);
	abstract int length();
}

class Dictionary extends PairMap{
	private int item;
	
	public Dictionary(int n) {
		keyArray = new String[n];
		valueArray = new String[n];
		this.item = 0;
	}

	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		for(int i=0; i<keyArray.length; i++) {
			if(key.equals(keyArray[i]))
				return valueArray[i];
		}
		return null;
	}

	@Override
	void put(String key, String value) {
		// TODO Auto-generated method stub
		for(int i=0; i<keyArray.length; i++) {
			if(key.equals(keyArray[i])) {
				keyArray[i]=key;
				valueArray[i]=value;
				return;
			}
		}
		keyArray[item] = key;
		valueArray[item] = value;
		item++;
	}

	@Override
	String delete(String key) {
		// TODO Auto-generated method stub
		for(int i=0; i<keyArray.length; i++) {
			if(key.equals(keyArray[i])) {
				String val = keyArray[i];
				keyArray[i]=null;
				valueArray[i]=null;
				return val;
			}
		}
		return null;
	}

	@Override
	int length() {
		// TODO Auto-generated method stub
		return item;
	}
}

public class In_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문",  "C++");
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));	

	}

}
