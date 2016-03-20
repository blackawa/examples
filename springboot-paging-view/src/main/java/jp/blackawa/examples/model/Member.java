package jp.blackawa.examples.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    Long memberId;
    String memberName;
}
