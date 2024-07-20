package pooproject.bookstation.dto.login;

public class LoginResponse {
    private String token;
    private String username;
    private String email;

    public LoginResponse(String token, String username, String email) {
        this.token = token;
        this.username = username;
        this.email = email;
    }

    public String getToken() {
        return token;
    }
}