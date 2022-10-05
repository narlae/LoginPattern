package narlae.LoginPattern.domain.member;

import lombok.RequiredArgsConstructor;
import narlae.LoginPattern.domain.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public ArrayList<Member> findAll() {
        return memberMapper.findAll();
    }
    public Integer regMember(Member member) {
        return memberMapper.memberAdd(member);
    }
}
