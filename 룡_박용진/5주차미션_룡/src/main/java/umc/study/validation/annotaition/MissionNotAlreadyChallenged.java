package umc.study.validation.annotaition;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import umc.study.validation.validator.MissionNotAlreadyChallengedValidator;

@Documented
@Constraint(validatedBy = MissionNotAlreadyChallengedValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionNotAlreadyChallenged {

    String message() default "이미 도전 중인 미션입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}