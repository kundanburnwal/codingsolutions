package ts;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
class Round2 
{ 
	public static void main (String[] args) { 
       System.out.println("Hello World!"); 
   } 
}

class MultiVersionMap extends HashMap<Object, Object> {
    
	private static final long serialVersionUID = 1L;
	int[] versions;
	static int latestVersion =0;
	
	public MultiVersionMap() {
		versions = new int[Integer.MAX_VALUE];
	}
	//v0: 1, kundan ; v1: 1, Mitesh
	@Override
	public Object put(Object key, Object value) {
		Map<Integer, Object> versionedValues = new TreeMap<>();
		versionedValues.put(latestVersion, value);
        return super.put(key, versionedValues);
    }
	
	@Override
	public Object get(Object key) {
		return getForVersion(key, latestVersion);
	}
	
	public Object getForVersion(Object key, int version) {
		Map<Integer, Object> versionedValues = (Map<Integer, Object>)super.get(key);
		return versionedValues.get(version);
	}
	
    Snapshot2 snapshot() {
        versions[latestVersion] = latestVersion;
        Snapshot2 snap = new Snapshot2(latestVersion, this);
        latestVersion++;
        return snap;
    }
    
    public static class Snapshot2 {
    	private int version;
    	MultiVersionMap map;
    	
    	public Snapshot2(int version, MultiVersionMap map) {
    		this.version = version;
    		this.map = map;
    	}
    	public Object get(Object key) {
    		Map<Integer, Object> versionedValues = (Map<Integer, Object>)map.get(key);
    		return versionedValues.get(version); 
        }
    }
}

