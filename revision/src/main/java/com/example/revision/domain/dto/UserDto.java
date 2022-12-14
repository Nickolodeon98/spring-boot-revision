package com.example.revision.domain.dto;

public class UserDto { // 컨트롤러에서 RequestBody 로 클라이언트로부터 정보를 받을 때 사용되는 Data Transfer Object

    private String id;
    private String name;
    private String password;

    public UserDto(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
