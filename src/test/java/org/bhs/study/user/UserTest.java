package org.bhs.study.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    /**
     * 유저 생성 시 상태 default값은 UserStatus.ACTIVE
     * 유저 생성 시 username 값이 공백 ("") 또는 null 예외 발생
     * 유저 생성 시 userNo의 값이 0이하인 경우 예외 발생
     */
    @Test void 유저생성() {
        //given
        String username = "bhs";
        int userNo = 1;
        User user = new User(username, userNo);

        //when

        //then
        assertThat(user.getStatus()).isEqualTo(UserStatus.ACTIVE);
        assertThatThrownBy(() -> new User(username, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User("", userNo)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User(null, userNo)).isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 유저 인스턴스의 inactive() 메소드 호출 시 상태변경
     * 유저 상태 확인 메소드 테스트
     */
    @Test void 유저상태변경_상태확인() {
        //given
        User user = new User("bhs", 1);

        //when
        user.inactive();

        //then
        assertThat(user.getStatus()).isEqualTo(UserStatus.INACTIVE);
        assertThat(user.isActive()).isFalse();
    }
}
