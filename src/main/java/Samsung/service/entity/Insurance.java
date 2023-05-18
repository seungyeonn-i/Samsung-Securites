package Samsung.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceId;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private String title;
    private long price;
    private Date date;

}
