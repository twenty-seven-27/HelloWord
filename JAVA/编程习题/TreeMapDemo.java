

/*
 * 问题：现在有一串字母，要求对他进行排序，并统计每个字母的个数，
 * 让字母与字母个数相互映射； 如：“asdfdfghfglkjasdgffgdf”
 * 且，希望打印的结果是这样的：a(2)d(4)......
 * 思路：
 * 1，有映射关系，就要选择Map集合；
 * 2，将字符串转换成字符数组。
 * 3，因为打印的字符串有顺序，所以选择TreeMap集合。
 * 4，以字母作为键，每天加一个元素都让这个元素的键去遍历整个键值表；
 * 如果该键已经存在，就让与他映射的值+1（用新的值覆盖掉原来的值）；要不存 在就调用HashMap的put()方法添加键和1；
 * 将TreeMap中的集合转化为指定字符串类型返回。
 * */
import java.util.*;
public class TreeMapDemo {
	public  static void main(String[] args) {
		String str = countChar(";asda,fgd.sg/hgkk");
		System.out.println(str);
	}
	public static String countChar(String str) {
		char[] ch = str.toCharArray();
		//由于字母要排序，所以选用TreeSet集合
		//由于char类型是数据类型不是对象类型，所以要换用Characater
		TreeMap<Character, Integer> tm = new TreeMap<Character,Integer>();
//		for(int i=0; i<ch.length; i++) {
//			Integer vlue = tm.get(ch[i]);
//			if(!(ch[i]>'a'&&ch[i]<'z'||ch[i]>'A'&&ch[i]<'Z'))
//				continue;
//			if(vlue==null)
//				tm.put(ch[i], 1);
//			else {
//				vlue++;
//				tm.put(ch[i], vlue);
//			}
			int count = 0;
			for(int i=0; i<ch.length; i++) {
				Integer vlue = tm.get(ch[i]);
				if(!(ch[i]>'a'&&ch[i]<'z'||ch[i]>'A'&&ch[i]<'Z'))
					continue;
				if(vlue!=null) {
					count=vlue;
				}
				count++;
				tm.put(ch[i], count);
				count=0;
			}
		
		//System.out.println(tm);//打印TreeSet集合
		//因为返回的String类型的字符串，所以可以调用String的缓冲区！
		StringBuilder sb = new StringBuilder();
  		Set<Map.Entry<Character, Integer>> me = tm.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = me.iterator();
		while(it.hasNext()) {
			Map.Entry<Character, Integer> men = (Map.Entry<Character,Integer>)it.next();
			Character cha = men.getKey();
			Integer con = men.getValue();
			sb.append(cha+"("+con+")");
		}
		return sb.toString();
	}
}


interface Map{
	public static interface Entry{ //内部接口
		public abstract Object getKey();
		public abstract Object getVlue();
	}
}

//class HashMap implements Map{
//	//内部类实现内部接口；
//	class Hash implements Map.Entry{
//		public Object getKey() {...}
//		public Object getVlue() {...}
//	}
//}