package narlae.LoginPattern.web.member;

import lombok.RequiredArgsConstructor;
import narlae.LoginPattern.domain.ResponseDto;
import narlae.LoginPattern.domain.member.Member;
import narlae.LoginPattern.domain.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    
    @PostMapping("/findAll")
    @ResponseBody
    public ResponseEntity<?> findAll() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResultCode("S0001");
        responseDto.setRes(memberService.findAll());

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity test() {
        ArrayList<HashMap<String, Object>> res = memberService.findAll();
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public ResponseEntity<String> save(@ModelAttribute Member member) {
        // memberAdd TODO
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
