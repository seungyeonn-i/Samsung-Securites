package Samsung.service.repository;

import Samsung.service.entity.Card;
import Samsung.service.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select c from Card c where c.categoryId = :categoryId")
    Optional<List<Card>> findCardByCategoryId(@Param("categoryId") Long categoryId);
}
