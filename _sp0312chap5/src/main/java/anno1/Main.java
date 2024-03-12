package anno1;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Method [] methodList = MyObject.class.getMethods(); //MyObject 클래스의 메서드의 값을 변수에 담음
		
		for(Method method : methodList) {
			if(method.isAnnotationPresent(MyAnnotation.class)) {  //주어진 클래스의 어노테이션이 현재 요소(여기서는 메소드)에 적용되었는지 여부를 검사
				MyAnnotation annotation= 
						method.getDeclaredAnnotation(MyAnnotation.class); //어노테이션이 적용되어 있다면 해당 어노테이션의 인스턴스를 생성하여 변수에 저장
																		  //getDeclaredAnnotation 메소드는 해당 요소에 직접 선언된 어노테이션을 반환
				String value=annotation.value(); //annotation의 밸류를 가져옴
				System.out.println(method.getName() + ":" + value); //MyObject의 메서드값 + MyAnnotation의 값을 가져옴
				
				
			} 
		}
	}

}
