package wrk.esb.api;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.GetMapping;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Api {
  
  @AliasFor(annotation = GetMapping.class) //?
  String value() default "";
  
  String method() default "GET";
}
