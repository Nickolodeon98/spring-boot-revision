package com.example.revision.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String name;
    private String password;
}
