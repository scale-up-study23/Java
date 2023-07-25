abstract class PairMap {
	protected String keyArray [];
	protected String valueArray [];
	abstract String get(String key);
	abstract void put(String key,String value);	
	abstract String delete(String key);
	abstract int length();
	
}
class Dictionary extends PairMap{
	int count;
	Dictionary(int n){
		keyArray = new String[n];
        valueArray = new String[n];
        count = 0;
	}
	@Override
	String get(String key) {
		// TODO Auto-generated method stub
		for(int i=0; i<count; i++) {
			if(keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return null;
	}
	@Override
	void put(String key, String value) {
		// TODO Auto-generated method stub
		for(int i=0; i<count; i++) {
			if(keyArray[i].equals(key)) {
				valueArray[i] = value;
				return;
			}
		}
		keyArray[count] = key;
		valueArray[count] = value;
		count++;		
	}

	@Override
	String delete(String key) {
		// TODO Auto-generated method stub
		for(int i=0; i<count; i++) {
			if(keyArray[i].equals(key)) {
				String deletedvalue = valueArray[i];
				keyArray[i] = keyArray[count-1];
				valueArray[i] = valueArray[count-1];
				keyArray[count-1] = null;
				valueArray[count-1] = null;
				count--;
				return deletedvalue;
			}
		}
		return null;		
	}
	@Override
	int length() {
		// TODO Auto-generated method stub
		return count;
	}
}

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "c++");
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+ dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 "+dic.get("황기태"));
	}
}
