package Samsung.service.repository;

import Samsung.service.entity.Category;
import Samsung.service.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("select avg(m.food) from Member m")
    Optional<Integer> getSameAgeExpenseAverageFood(@Param("userId") Long userId);

    @Query("select avg(m.housing) from Member m")
    Optional<Integer> getSameAgeExpenseAverageHousing(@Param("userId") Long userId);
    @Query("select avg(m.insurance) from Member m")
    Optional<Integer> getSameAgeExpenseAverageInsurance(@Param("userId") Long userId);
    @Query("select avg(m.subscription) from Member m")
    Optional<Integer> getSameAgeExpenseAverageSubscription(@Param("userId") Long userId);
    @Query("select avg(m.transportation) from Member m")
    Optional<Integer> getSameAgeExpenseAverageTranportation(@Param("userId") Long userId);

}
