/**
 * 
 */
package com.hitachivantara.multicloud.providercost.azure;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author kkadam
 *
 */
public class MarkAndSweep {
	List<Integer> memoryAddresses;
	Map <Integer, Object> heap;
	
	public void garbageCollection() {
		Iterator<Integer> iterator = memoryAddresses.iterator();
		while (iterator.hasNext()) {
			Integer address = iterator.next();
			if (heap.containsKey(address)) {
				if (heap.get(address) == null) {
					iterator.remove();
					//heap.remove(key);
				}
			} else {
				iterator.remove();
			}
		}
	}
	
	

}
