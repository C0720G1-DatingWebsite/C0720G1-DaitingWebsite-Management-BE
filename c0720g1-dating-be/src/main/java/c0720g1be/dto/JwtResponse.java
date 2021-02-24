package c0720g1be.dto;


import java.util.Map;

public class JwtResponse {

    private String jwtToken;

    private Integer id;
    private String username;
    private String avatar;
    private Map<Integer, String> roleList;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, Integer id, String username, String avatar, Map<Integer, String> roleList) {
        this.jwtToken = jwtToken;
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.roleList = roleList;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Map<Integer, String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Map<Integer, String> roleList) {
        this.roleList = roleList;
    }
}
