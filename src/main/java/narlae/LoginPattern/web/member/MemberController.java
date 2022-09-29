package narlae.LoginPattern.web.member;

import narlae.LoginPattern.domain.ResponseDto;
import narlae.LoginPattern.domain.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/findAll")
    public ResponseEntity<?> findAll() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResultCode("S0001");
        responseDto.setRes(memberService.findAll());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        ArrayList<HashMap<String, Object>> res = memberService.findAll();
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
