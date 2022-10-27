package com.example.revision.controller;

import com.example.revision.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/get-api")
public class GetController {

    @GetMapping("/hello/{variable}")
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
