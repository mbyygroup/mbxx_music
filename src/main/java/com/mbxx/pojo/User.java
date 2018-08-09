package com.mbxx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mbxx.base.BaseDTO;
import com.mbxx.util.Dates;

import javax.persistence.*;
import java.util.Date;

//系统用户
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "SYS_USER")
public class User{
    private static final long serialVersionUID = -7395431342736009038L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Long userId;

    private Long toId;

    private String username;

    private String password;

    @JsonFormat(pattern = Dates.Pattern.DATE)
    private Date birthday;

    private Integer sex;

    private Integer loggin;

    private Integer versionNumber;

    @JsonFormat(pattern = Dates.Pattern.DATE)
    private Date createDate;

    private String blog;

    private String occupation;

    private String gotUrl;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getLoggin() {
        return loggin;
    }

    public void setLoggin(Integer loggin) {
        this.loggin = loggin;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog == null ? null : blog.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getGotUrl() {
        return gotUrl;
    }

    public void setGotUrl(String gotUrl) {
        this.gotUrl = gotUrl == null ? null : gotUrl.trim();
    }
}