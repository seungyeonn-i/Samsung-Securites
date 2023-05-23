package Samsung.service.repository;

import Samsung.service.dto.ExpenseDto;
import Samsung.service.entity.Category;
import Samsung.service.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("select new Samsung.service.dto.ExpenseDto(e.title, e.price,e.date) from Expense e where e.member.id = :userId and e.category = :category order by e.date ")
    Optional<List<ExpenseDto>> getExpensesByCategory(@Param("userId") Long userId, @Param("category") Category category);

    @Query("select sum(e.price) from Expense e where e.member.id = :userId and e.category = :category")
    Optional<Integer> getMyExpensesSumByCategory(@Param("userId") Long userId, @Param("category") Category category);
}
