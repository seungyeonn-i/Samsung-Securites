package Samsung.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subscriptionId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private long price;
    private Date date;

}
