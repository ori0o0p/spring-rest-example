package rest.project.domain.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(length = 100, nullable = false)
    private String password;

    protected User() {
    }

    @Builder
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        setPassword(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
