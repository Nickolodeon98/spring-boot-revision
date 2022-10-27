package com.example.revision.controller;

import com.example.revision.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

/*클래스 수준에서 Request Mapping 어노테이션을 사용하면 이하 모든 메소드들에 공통적으로 적용된다.*/
@RestController
@RequestMapping(value="/api/v2/get-api", method=RequestMethod.GET)
public class GetController {

    @RequestMapping("/hello/{variable}")
    public String pathParameterPractice(@PathVariable("variable") String str) {
        return String.format("Path parameter is %s", str);
    }

    @GetMapping("/words")
    public String queryParameterPractice(@RequestParam String name,
                                         @RequestParam String email,
                                         @RequestParam String age) {
        return String.format("name: '%s', email: '%s', age: '%s'", name, email, age);
    }

    @GetMapping("/unknown")
    public String queryParamAsMapPractice(@RequestParam Map<String, Object> parameter) {
        StringBuilder sb = new StringBuilder();
        parameter.entrySet().forEach(map-> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @GetMapping("/dto")
    public String queryParamAsDtoPractice(MemberDto memberDto) {
        return memberDto.toString();
    }
}
