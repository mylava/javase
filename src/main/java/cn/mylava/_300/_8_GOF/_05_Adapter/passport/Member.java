package cn.mylava._300._8_GOF._05_Adapter.passport;

/**
 * comment: 会员类
 *
 * @author: lipengfei
 * @date: 27/03/2018
 */
public class Member {
    private String username;
    private String password;
    private String mid;
    private String info;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
