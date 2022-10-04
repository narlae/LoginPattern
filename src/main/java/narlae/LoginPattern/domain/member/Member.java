package narlae.LoginPattern.domain.member;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;


@Data
@Alias("MemberDto")
public class Member {
    private Integer member_id;
    private String member_email;
    private String member_nm;
    private Integer member_telno;
    private String member_pwd;
    private Date member_subs_dt;
    private Date member_birth;
    private boolean member_ad_ag;
    private boolean member_id_ag;

}
