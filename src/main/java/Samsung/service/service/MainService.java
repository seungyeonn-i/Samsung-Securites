package Samsung.service.service;

import Samsung.service.dto.ExpenseDto;
import Samsung.service.entity.Category;
import Samsung.service.repository.ExpenseRepository;
import Samsung.service.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final ExpenseRepository expenseRepository;
    private final MemberRepository memberRepository;

    public String createChart(Category category) throws JsonProcessingException {

        // 나의 지출 , 동일 연령대, 동일 소득 파트별
        int[] dataValues = new int[3];
        dataValues[0] = expenseRepository.getMyExpensesSumByCategory(41L, category).orElseThrow(NullPointerException::new)%100000;
        if (category.equals(Category.식비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageFood(41L).orElseThrow(NullPointerException::new)%100000;
            dataValues[2] = 3;
        }
        if (category.equals(Category.교통비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageTranportation(41L).orElseThrow(NullPointerException::new)%100000;
            dataValues[2] = 3;
        }
        if (category.equals(Category.보험비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageInsurance(41L).orElseThrow(NullPointerException::new)%100000;
            dataValues[2] = 3;
        }
        if (category.equals(Category.주거비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageHousing(41L).orElseThrow(NullPointerException::new)%100000;
            dataValues[2] = 3;
        }
        if (category.equals(Category.구독비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageSubscription(41L).orElseThrow(NullPointerException::new)%100000;
            dataValues[2] = 3;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dataValues);

    }

    public List<ExpenseDto> getExpenseList(Category category) {

        return expenseRepository.getExpensesByCategory(41L, category).orElseThrow(NullPointerException::new);

    }
}
