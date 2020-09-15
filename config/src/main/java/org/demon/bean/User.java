package org.demon.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@PropertySource({"classpath:user.properties"})
@Component
// 从配置文件中获取 bean 的属性值
@ConfigurationProperties(prefix = "user")
public class User {

    private Integer id;
    private String username;
    private Boolean isAdmin;

    private Map<String, Object> maps;
    private List<Object> list;

    private Account account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isAdmin=" + isAdmin +
                ", maps=" + maps +
                ", list=" + list +
                ", account=" + account +
                '}';
    }
}
