package narlae.LoginPattern.domain.member;

import lombok.RequiredArgsConstructor;
import narlae.LoginPattern.domain.mapper.MemberMapper;
import narlae.LoginPattern.web.member.form.MemberSaveForm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public Member formToMember(MemberSaveForm form) {
        Member member = Member.builder()
                .member_email(form.getMember_email())
                .member_nm(form.getMember_nm())
                .member_telno(form.getMember_telno())
                .member_pwd(form.getMember_pwd())
                .member_subs_dt(LocalDate.now())
                .member_birth(form.getMember_birth())
                .member_ad_ag(form.isMember_ad_ag())
                .member_id_ag(form.isMember_ad_ag())
                .build();

        return member;
    }


    public ArrayList<Member> findAll() {
        return memberMapper.findAll();
    }
    public Integer regMember(Member member) {
        return memberMapper.memberAdd(member);
    }
}
