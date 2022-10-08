package narlae.LoginPattern.domain.login;

import lombok.RequiredArgsConstructor;
import narlae.LoginPattern.domain.member.Member;
import narlae.LoginPattern.domain.member.MemberService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;

    public Member login(String loginId, String pwd) {
        return memberService.findByLoginId(loginId).filter(m -> m.getMember_pwd().equals(pwd))
                .orElse(null);
    }
}
