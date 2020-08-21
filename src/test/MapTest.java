package test;

import java.util.Hashtable;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,String> map = new Hashtable<>();
		map.put("이름", "송송");
		map.put("나이", "30");
		System.out.println(map);
	}
}
