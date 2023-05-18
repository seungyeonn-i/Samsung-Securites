package Samsung.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transportation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transportationId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private long price;
    private Date date;

}
