package annotations;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
public @interface RoleRequired {
    String role() default "Admin";
}