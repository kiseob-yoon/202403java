package anno2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import anno1.MyAnnotation;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Target ta = new Target();
//		ta.sub();
		
		//라이브러리 즉, 외부에서 가져올때 사용 가능, 여기서 클래스를 가져오고 인스턴스를 생성해서 내부에 메서드를 실행시킴
		String className = "anno2.Target"; 
		Class<?> cls = Class.forName(className);
		Target a = (Target)cls.getDeclaredConstructor().newInstance();
		a.sub();
		
		Method [] methods = cls.getDeclaredMethods(); //클래스의 모든 메서드 정보를 가져온다
		
		for(int i=0; i<methods.length; i++) {
			if(methods[i].isAnnotationPresent(MyAnno.class)) {
				MyAnno myAnno = methods[i].getAnnotation(MyAnno.class);
				System.out.println(myAnno.value());
			}
			if(methods[i].isAnnotationPresent(MyAnnotation.class)) {  //주어진 클래스의 어노테이션이 현재 요소(여기서는 메소드)에 적용되었는지 여부를 검사
				MyAnnotation annotation= 
						methods[i].getDeclaredAnnotation(MyAnnotation.class); //어노테이션이 적용되어 있다면 해당 어노테이션의 인스턴스를 생성하여 변수에 저장
																		  //getDeclaredAnnotation 메소드는 해당 요소에 직접 선언된 어노테이션을 반환
				String value=annotation.value(); //annotation의 밸류를 가져옴
				System.out.println(methods[i].getName() + ":" + value); //MyObject의 메서드값 + MyAnnotation의 값을 가져옴
				
				
			} 
		}
		
//		Method method = Target.class.getMethod("sub"); //sub라는 메서드를 가져옴
//		Annotation [] annotations = method.getDeclaredAnnotations();
//		
//		for(Annotation anno : annotations) {
//			MyAnno myAnno = (MyAnno) anno;
//			System.out.println(myAnno.value());
//		}
	}

}
