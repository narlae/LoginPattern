package narlae.LoginPattern.domain.member;

import narlae.LoginPattern.domain.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public ArrayList<HashMap<String, Object>> findAll() {
        return memberMapper.findAll();
    }
}
