package com.toy.videostreaming.domain;

import java.time.LocalDateTime;

public class Member {
    private String memId;
    private String memPw;
    private String memName;
    private String memEmail;
    private String activeStatus;
    private LocalDateTime lastLoginTime;
    private String memPermit;

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getMemPermit() {
        return memPermit;
    }

    public void setMemPermit(String memPermit) {
        this.memPermit = memPermit;
    }
}
