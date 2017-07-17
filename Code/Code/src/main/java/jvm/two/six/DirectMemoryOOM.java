package jvm.two.six;

import java.lang.reflect.Field;

import sun.misc.Unsafe;
/**
 * 直接分配后eclipse卡死，没有办法看到控制台结果
 * @author zlb
 *
 */
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		//需要设置JRE System Library的Accessible Rules
		Field unsafeField=Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe=(Unsafe)unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}

}
