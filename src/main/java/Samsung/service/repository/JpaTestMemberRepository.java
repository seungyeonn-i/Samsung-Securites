package Samsung.service.repository;

import Samsung.service.entity.QTestMember;
import Samsung.service.entity.TestMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaTestMemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public JpaTestMemberRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public TestMember save(TestMember testMember) {
        em.persist(testMember);
        return testMember;
    }

    public TestMember findOne(Long id) {
        return em.find(TestMember.class, id);
    }

    public List<String> findAllOld(TestMember testMember) {
        QTestMember tm = new QTestMember("i");
        return query.select(tm.username)
                .from(tm)
                .where()
                .fetch();
    }






}
