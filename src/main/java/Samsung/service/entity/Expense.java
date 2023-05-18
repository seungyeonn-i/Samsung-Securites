package Samsung.service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private Long price;
    private Date date;

    @Enumerated(EnumType.STRING)
    private Category category;

}
