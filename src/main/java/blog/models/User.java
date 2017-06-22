package blog.models;


import java.util.HashSet;
import java.util.Set;
/**
 * Created by Artur on 2017-06-14.
 */
public class User {

    private Long id;

    public User(Long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }

    private String username;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    private String passwordHash;
    private String fullName;
    private Set<Post> posts = new HashSet<>();
}
