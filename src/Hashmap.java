import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmap {

	public static void main(String[] args) {
		HashMap<String,Integer> map=new HashMap<>();
		
		map.put("USA", 1000);
		map.put("RSA", 800);
		map.put("China", 900);
		map.put("India", 700);
		map.put("France", 750);
		System.out.println(map);
		System.out.println(".................");
//		gets datatype of the variable
//		System.out.println(s.getClass().getName());
//		System.out.println(".................");
//		System.out.println(map.get("USA"));
//		System.out.println(".................");
//		System.out.println(map.remove("USA"));
//		System.out.println(map);
//		System.out.println(".................");
//		map.put("USA", 1200);
//		System.out.println(".................");
//		System.out.println(map);
//		map.put("USA", 1500);
//		System.out.println(".................");
//		System.out.println(map);
//		System.out.println(".................");
//		System.out.println(map.containsKey("Pakistan"));
//		System.out.println(map.containsValue(1500));
//		System.out.println(".................");		
//		
//		
////		gives  a set of keys in a HM
////		all keys are UNIQUE in a COLLECTION
//		Set<String> keys=map.keySet();
//		for(String key:keys)
//			System.out.print(key+" ");
//			System.out.println();
//		
//		System.out.println(".................");
//		
//		
////	gives a collection of the values of respective keys
//		Collection<Integer> values=map.values();
//		for(Integer value:values)
//			System.out.print(value+" ");
//		System.out.println("");
//		
//		System.out.println(".................");
//		
//		Set<Map.Entry<String, Integer>> entries=map.entrySet();
//		
//		for(Map.Entry<String, Integer> entry:entries)
//			System.out.println(entry.getKey()+"=>"+ entry.getValue());
		String str="aabbaaacdda";
		System.out.println(getMaxFreq(str));
	}
	
	public static char getMaxFreq(String str) {
		HashMap<Character,Integer> map=new HashMap<>();
		
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(map.containsKey(c)){
				int oldval=map.get(c);
				int newval=oldval+1;
				map.put(c, newval);
			}
			else {
				map.put(c, 1);
			}
		}
		char maxchar='\0';
		int max=0;
		
		Set<Map.Entry<Character,Integer>> entries=map.entrySet();
		
		for(Map.Entry<Character,Integer> entry:entries)
		{
			if(entry.getValue()>max)
			{
				max=entry.getValue();
				maxchar=entry.getKey();
			}
		}
		return maxchar;
	}

}
