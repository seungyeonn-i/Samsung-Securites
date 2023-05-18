package Samsung.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;
    private long categoryId;

    private String name;
    private String img;
    private String description1;
    private String description2;


}
