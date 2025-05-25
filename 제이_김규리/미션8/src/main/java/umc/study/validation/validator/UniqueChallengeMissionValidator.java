package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.UniqueChallengeMission;
import umc.study.web.dto.StoreMissionRequestDTO;
import umc.study.domain.enums.MissionStatus;

@Component
@RequiredArgsConstructor
public class UniqueChallengeMissionValidator implements ConstraintValidator<UniqueChallengeMission, StoreMissionRequestDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(StoreMissionRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) return true; // @NotNull 검증에 맡김

        boolean exists = memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(
                dto.getMemberId(), dto.getMissionId(), MissionStatus.CHALLENGING);

        if (exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 도전 중인 미션입니다.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
