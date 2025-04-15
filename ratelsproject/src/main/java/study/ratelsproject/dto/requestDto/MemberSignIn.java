package study.ratelsproject.dto.requestDto;

import org.springframework.stereotype.Service;

public record MemberSignIn(String id,
                           String password) {
}
