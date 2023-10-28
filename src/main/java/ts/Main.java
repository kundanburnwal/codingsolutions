package ts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* package whatever; // don't place package name! */
/**
 * 
 *  Data-store:
 * 
 * MultiVersionV
 *  get(key)
 *  put(key, value)
 *  delete(key)
 *  Snapshot snapShot()
 *    - get(key)
 *
 * Snapshot
 *   get(key)
 *  
 * Efficiency
 *  - storage (space complexity)
 *  - time complexity
 * 
 * 
 * /
import java.io.*; 

/* Name of the class has to be "Main" only if the class is public. */ 
class Main
{ 
public static void main (String[] args)
   { 
       System.out.println("Hello World!"); 
   } 
}

class MultiVersionMapOld extends HashMap {
    
    Snapshot snapshot() {
        //create a copy of each key-value pair 
        Iterator iter = this.keySet().iterator();
        Snapshot snap = new Snapshot();
        while (iter.hasNext()) {
        	Object key = iter.next();
        	Object value = this.get(key);
        	snap.put(key, value);
        }
        return snap;
    }
}

class Snapshot {
	private Map map;
	public Snapshot() {
		this.map = new HashMap();
	}
	void put(Object key, Object value) {
		this.map.put(key, value);
	}
    public Object get(Object key) {
        return this.map.get(key);
    }
}





