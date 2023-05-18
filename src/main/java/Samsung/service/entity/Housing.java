package Samsung.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long housingId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private long price;
    private Date date;

}
