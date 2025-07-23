package fi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapMerge {
	public static void main(String[] args) {
		Map<String,Integer> hm = new LinkedHashMap<>();
		hm.put("Apple",10);
		hm.put("Goa",8);
		hm.put("Banana",12);
		hm.put("orage",14);
		
		hm.merge("Goa", 10, Integer::sum);
		hm.merge("Avacado", 10, Integer::sum);
		
		hm.forEach((key,value) ->System.out.println("key is : "+key+" value is : "+value));
		
		
	}

}
