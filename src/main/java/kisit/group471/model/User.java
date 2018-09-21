package kisit.group471.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "smart_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String hashPassword;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private State state;

    public User(String login, String hashPassword, Role role, State state) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.role = role;
        this.state = state;
    }

}
