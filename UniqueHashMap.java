
import java.util.*;

public class UniqueHashMap extends HashMap {

	public UniqueHashMap() {
		// TODO Auto-generated constructor stub
	}
	
	public Object put(Object key, Object value) {
		//get the list of keys in the map
		Set<String> keySets = this.keySet();
		//create the iterator from Set
		Iterator <String> keySetiterator = keySets.iterator();
		
		//go through each key and for each key, get its corresponding value and compare with the value given in the parameter
		//if it matches, remove the current mapping and insert the new mapping with the new key  
		while (keySetiterator.hasNext()) {
			String keyLookup = keySetiterator.next();
			String valLookup = (String) super.get(keyLookup);
			if (valLookup == value) {
				this.remove(keyLookup);
				break;
			}
		
		}
			
		return super.put(key,value);
	}
	
	//per spec, no action should be taking place for UniqueHashMap.putAll method
	public void putAll(Map m) {
		System.out.println("no actions to be performed");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueHashMap uM = new UniqueHashMap();
		System.out.println("1st iteration");
		uM.put("blog", "glob");
		System.out.println(uM);
		System.out.println("2nd iteration");
		uM.put("blag", "glob");
		System.out.println(uM);
		System.out.println("3rd iteration");
		uM.put("canada", "ottawa");
		System.out.println(uM);
		uM.put("ontario", "ottawa");
		System.out.println(uM);
	}

}
