package org.yeongtae.member.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// Member 클래스: 회원 정보를 담는 Entity 클래스입니다.
@Data
@Builder
public class Member {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
