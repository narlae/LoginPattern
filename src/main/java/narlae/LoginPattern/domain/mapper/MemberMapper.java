package narlae.LoginPattern.domain.mapper;

import narlae.LoginPattern.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface MemberMapper {

    //    ArrayList<HashMap<String, Object>> findAll();
    ArrayList<Member> findAll();
    Integer memberAdd(Member member);


}
