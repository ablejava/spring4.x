import java.util.ArrayList;
import java.util.List;


public class Test extends Base<String> {
   
	public static void main(String[] args) {
//		Test t = new Test();
//		List<String> ls = t.getEntity(String.class, 1);
//		for (String string : ls) {
//			System.out.println("str:"+string);
//		}
//		List<String> ls = new ArrayList();
//		ls.add("d");
		List<Object> lo = new ArrayList<Object>();	
		List<String> ls = new ArrayList<String>();
//		lo = ls;//<---此外语法编译不过
		System.out.println(0.666*5); // 3.33
		System.out.println(2/3); // ==0
		System.out.println(2d/3); // 0.666666666666
		System.out.println((2*5)/3); // 3
		System.out.println((2*5)/3d); // 3.3333333333

	}
}
