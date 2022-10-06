package narlae.LoginPattern.domain.member;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;
import java.util.Date;


@Data
@Alias("MemberDto")
@Builder
public class Member {
    private Integer member_id;
    private String member_email;
    private String member_nm;
    private Integer member_telno;
    private String member_pwd;
    private LocalDate member_subs_dt; //등록일
    private LocalDate member_birth;
    private boolean member_ad_ag; //광고 수신 동의
    private boolean member_id_ag; //개인정보 동의

}
