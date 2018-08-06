package com.mbxx.pojo;

public class User_Singer {
    private Long userId;

    private String username;

    private String singerExplain;

    private String type1;

    private String type2;

    private String type3;

    private String country;

    private Integer sex;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSingerExplain() {
        return singerExplain;
    }

    public void setSingerExplain(String singerExplain) {
        this.singerExplain = singerExplain == null ? null : singerExplain.trim();
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1 == null ? null : type1.trim();
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2 == null ? null : type2.trim();
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3 == null ? null : type3.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}