package jvm.two.four;

import java.util.ArrayList;
import java.util.List;

/**
 * java 8.0 移除了该内存区域
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M;support was removed in 8.0 
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
 * 
 * @author zlb
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i).intern());
		}
	}

}
