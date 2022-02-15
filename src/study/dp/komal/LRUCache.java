import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author kkadam
 *
 */
public class LRUCache {
	int size;
	List<String> cache;
	
	
	public LRUCache(int size) {
		super();
		this.size = size;
		this.cache = new ArrayList<>();
	}

	public void addElement(String data) {
		if (cache.size() == size) {
			cache.remove(size-1);
		}
		cache.add(0, data);
	}
	
	public void access(String data) throws Exception {
		if (cache.contains(data)) {
			int index = cache.indexOf(data);
			cache.remove(index);
			cache.add(0, data);
		} else {
			this.addElement(data);
		}
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Long sum = (long) ((Integer.MAX_VALUE * (Integer.MAX_VALUE + 1))/2);
		System.out.println(sum);
		
	}

}
