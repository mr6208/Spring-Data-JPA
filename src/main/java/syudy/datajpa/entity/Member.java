package syudy.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {

        this.username = username;
    }

    public Member(String name, int age, Team team) {
        this.username = name;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }

    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
