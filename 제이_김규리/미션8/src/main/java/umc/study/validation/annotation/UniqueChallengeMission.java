package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.UniqueChallengeMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueChallengeMissionValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueChallengeMission {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
