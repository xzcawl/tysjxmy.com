package com.tysj.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname User
 * @Description TODO 用户登录
 * @Date 2018/11/9 10:27
 * @Created by xzcawl
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;//索引号

    private String username;//用户名

    private String password;//密码

    private Date createDate;//创建账号的时间

    private Date lastLoginDate;//最后登录的时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}
