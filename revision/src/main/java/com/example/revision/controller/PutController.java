package com.example.revision.controller;

import com.example.revision.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/api/v2/put-api", method=RequestMethod.PUT)
public class PutController {
    /* 리소스 Update 를 위해 사용되는 PUT. POST 와 서비스 로직에는 차이가 있지만
     * 컨트롤러에서는 request body 에 내용을 담는다는 점에서 비슷하다. */
    @PutMapping("/hello")
    public String putHello() {
        return "Hello PUT World!";
    }
    /*첫 번째 방법: Map 을 사용해 request body 내용을 받아서 서버에 보낸다.*/
    @PutMapping("/credentials")
    public String putCredentials(@RequestBody Map<String, Object> content) {
        StringBuilder sb = new StringBuilder();

        content.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue());
        });

        return sb.toString();
    }

    /* 두 번째 방법: DTO 를 사용해 클라이언트와 서버 사이에서 Request Body 의 내용을 받아서
     * (가이드라인에 따라 알아서 Body 에 내용을 담아 전송할 것이다) 서버로 가공된 데이터를 전송한다.
     * DTO 에서 명시된 데이터 타입에 따라 null 이나 0 과 같은 값으로 초기화되어 있다.*/
    @PutMapping("/page")
    public String putPage(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping("/home")
    public MemberDto putHome(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    /* 아래와 같은 방법으로 status 를 기존 디폴트값인 200에서 ACCEPTED 가 해당하는 202로 바꿔줄 수 있다.*/
    @PutMapping("/remote")
    public ResponseEntity<MemberDto> putRemote(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
