package Samsung.service.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private int month;

    private Long food;
    private Long housing;
    private Long transportation;
    private Long subscription;
    private Long insurance;
    @OneToMany(mappedBy = "member")
    private List<Food> foods = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Housing> housings = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Insurance> insurances = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Subscription> subscriptions = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Transportation> transportations = new ArrayList<>();



}
