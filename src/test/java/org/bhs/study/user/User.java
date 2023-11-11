package org.bhs.study.user;

import org.springframework.util.Assert;

public class User {

    private String username;
    private int userNo;
    private UserStatus status;

    public User(final String username, final int userNo){
        Assert.hasText(username, "유저명은 필수입니다.");
        Assert.isTrue(userNo > 0, "유저번호는 0보다 커야합니다.");
        this.username = username;
        this.userNo = userNo;
        this.status = UserStatus.ACTIVE;
    }

    public UserStatus getStatus(){
        return this.status;
    }

    public void inactive(){
        this.status = UserStatus.INACTIVE;
    }

    public boolean isActive(){
        return this.status.equals(UserStatus.ACTIVE);
    }

}
