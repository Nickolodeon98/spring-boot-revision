package com.example.revision.controller;

import com.example.revision.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/api/v2/post-api", method= RequestMethod.POST)
public class PostController {
    /* URL 이 아니라 Request body 에서 parameter 를 서버로 전달하는 POST 방식 */
    @PostMapping("/hello")
    public String postHello() {
        return "Hello POST World!";
    }
    /*첫 번째 방법: Map 을 사용해 request body 내용을 받아서 서버에 보낸다.*/
    @PostMapping("/credentials")
    public String postCredentials(@RequestBody Map<String, Object> content) {
        StringBuilder sb = new StringBuilder();

        content.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue());
        });

        return sb.toString();
    }

    /* 두 번째 방법: DTO 를 사용해 클라이언트와 서버 사이에서 Request Body 의 내용을 받아서
     * (가이드라인에 따라 알아서 Body 에 내용을 담아 전송할 것이다) 서버로 가공된 데이터를 전송한다.
     * DTO 에서 명시된 데이터 타입에 따라 null 이나 0 과 같은 값으로 초기화되어 있다.*/
    @PostMapping("/page")
    public String postPage(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
