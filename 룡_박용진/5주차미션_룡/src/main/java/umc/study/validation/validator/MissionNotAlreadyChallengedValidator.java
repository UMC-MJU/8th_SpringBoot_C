package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotaition.MissionNotAlreadyChallenged;

@Component
@RequiredArgsConstructor
public class MissionNotAlreadyChallengedValidator implements ConstraintValidator<MissionNotAlreadyChallenged, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L; // 하드코딩된 유저

        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        if (exists) {
            // 바로 예외 던져버리기
            throw new IllegalArgumentException("이미 도전 중인 미션입니다.");
        }

        return true;
    }
}
