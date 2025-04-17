package study.ratelsproject.dto.requestDto;

public record PostNewByMember(String title,
                              String content,
                              int memberId) {
}
