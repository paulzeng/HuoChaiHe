package com.thomas.hch.bean;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/18 11:36
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class UserBean {
    private int id;

    private String user_name;

    private String mobile;

    private String email;

    private String avatar;

    private String nick_name;

    private String birthday;

    private int amount;

    private int point;

    private int exp;

    private String reg_time;

    private int yibi;

    private String lasttime;

    private boolean isvip;

    private int logincount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getReg_time() {
        return reg_time;
    }

    public void setReg_time(String reg_time) {
        this.reg_time = reg_time;
    }

    public int getYibi() {
        return yibi;
    }

    public void setYibi(int yibi) {
        this.yibi = yibi;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public boolean isvip() {
        return isvip;
    }

    public void setIsvip(boolean isvip) {
        this.isvip = isvip;
    }

    public int getLogincount() {
        return logincount;
    }

    public void setLogincount(int logincount) {
        this.logincount = logincount;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", amount=" + amount +
                ", point=" + point +
                ", exp=" + exp +
                ", reg_time='" + reg_time + '\'' +
                ", yibi=" + yibi +
                ", lasttime='" + lasttime + '\'' +
                ", isvip=" + isvip +
                ", logincount=" + logincount +
                '}';
    }
}
