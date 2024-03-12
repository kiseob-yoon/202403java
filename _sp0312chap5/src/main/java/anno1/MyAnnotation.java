package anno1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//@Target 어노테이션은 어노테이션이 적용될 대상을 지정하며, 이 어노테이션은 메소드에만 적용될 수 있다.
@Retention(RetentionPolicy.RUNTIME) //@Retention 어노테이션은 어노테이션의 유지 정책을 설정 런타임까지 어노테이션 정보를 유지
public @interface MyAnnotation {
	String value() default "MyAnnotation : default value"; //속성을 명시하지 않을 경우 이 default값이 사용
	
}
