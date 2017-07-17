package jvm.two.five;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 由于option PermSize和MaxPermSize被忽略，所有运行很长时间都没有出现OOM异常
 * @author zlb
 *
 */
public class JavaMethodAreaOOM {
	static class OOMObject{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Enhancer> list=new ArrayList<Enhancer>(0);
		while(true){
			Enhancer enhancer=new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					// TODO Auto-generated method stub
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
			list.add(enhancer);
		}
	}

}
