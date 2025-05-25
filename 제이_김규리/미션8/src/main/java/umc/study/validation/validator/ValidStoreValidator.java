package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ValidStore;
import umc.study.web.dto.ReviewRequestDTO;

@Component
@RequiredArgsConstructor
public class ValidStoreValidator implements ConstraintValidator<ValidStore, ReviewRequestDTO> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(ReviewRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getStoreId() == null) return true; // @NotNull 검증에 위임

        boolean exists = storeRepository.existsById(dto.getStoreId());
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("가게가 존재하지 않습니다.")
                    .addPropertyNode("storeId")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}