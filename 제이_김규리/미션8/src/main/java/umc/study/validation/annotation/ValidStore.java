package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import umc.study.validation.validator.ValidStoreValidator;

@Documented
@Constraint(validatedBy = ValidStoreValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStore {
    String message() default "존재하지 않는 가게입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}