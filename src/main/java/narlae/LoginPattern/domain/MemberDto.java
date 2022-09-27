package narlae.LoginPattern.domain;

import lombok.Data;

import java.util.Date;


@Data
public class MemberDto {
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
