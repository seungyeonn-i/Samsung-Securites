package Samsung.service.service;

import Samsung.service.dto.CardDto;
import Samsung.service.dto.ExpenseDto;
import Samsung.service.entity.Card;
import Samsung.service.entity.Category;
import Samsung.service.entity.Member;
import Samsung.service.repository.CardRepository;
import Samsung.service.repository.ExpenseRepository;
import Samsung.service.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final ExpenseRepository expenseRepository;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;

    public List<Integer> getIncomes(Long userId) {
        List<Integer> incomes = new ArrayList<>();
        Member member = memberRepository.getMyExpenses(41L).orElseThrow(NullPointerException::new);

        int income = Math.toIntExact(member.getIncome());
        incomes.add(income);

        double sum = (double) (member.getFood() + member.getTransportation() + member.getHousing() + member.getSubscription() + member.getInsurance());
        incomes.add((int)sum);
        incomes.add((int) (sum / income * 100));
        return incomes;
    }

    public String createMainChart(Long userId) throws JsonProcessingException {

        // 나의 지출 , 동일 연령대, 동일 소득 파트별
        Long [] dataValues = new Long[5];

        Member member = memberRepository.getMyExpenses(41L).orElseThrow(NullPointerException::new);

        dataValues[0] = member.getFood();
        dataValues[1] = member.getTransportation();
        dataValues[2] = member.getInsurance();
        dataValues[3] = member.getHousing();
        dataValues[4] = member.getSubscription();

        System.out.println(Arrays.toString(dataValues));

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dataValues);

    }
    public String createChart(Category category) throws JsonProcessingException {

        // 나의 지출 , 동일 연령대, 동일 소득 파트별
        int[] dataValues = new int[3];
        dataValues[0] = expenseRepository.getMyExpensesSumByCategory(41L, category).orElseThrow(NullPointerException::new)/10000;
        if (category.equals(Category.식비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageFood().orElseThrow(NullPointerException::new)/10000;
            dataValues[2] = memberRepository.getSameIncomeAverageFood(2500000L).orElseThrow(NullPointerException::new)/10000;
        }
        if (category.equals(Category.교통비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageTransportation().orElseThrow(NullPointerException::new)/10000;
            dataValues[2] = memberRepository.getSameIncomeAverageTransportation(2500000L).orElseThrow(NullPointerException::new)/10000;
        }
        if (category.equals(Category.보험비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageInsurance().orElseThrow(NullPointerException::new)/10000;
            dataValues[2] = memberRepository.getSameIncomeAverageInsurance(2500000L).orElseThrow(NullPointerException::new)/10000;
        }
        if (category.equals(Category.주거비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageHousing().orElseThrow(NullPointerException::new)/10000;
            dataValues[2] = memberRepository.getSameIncomeAverageHousing(2500000L).orElseThrow(NullPointerException::new)/10000;
        }
        if (category.equals(Category.구독비)) {
            dataValues[1] =memberRepository.getSameAgeExpenseAverageSubscription().orElseThrow(NullPointerException::new)/10000;
            dataValues[2] = memberRepository.getSameIncomeAverageSubscription(2500000L).orElseThrow(NullPointerException::new)/10000;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dataValues);

    }

    public List<ExpenseDto> getExpenseList(Category category) {

        List<ExpenseDto> expenseDtos = expenseRepository.getExpensesByCategory(41L, category).orElseThrow(NullPointerException::new);
        for (ExpenseDto expenseDto : expenseDtos) {

            expenseDto.setPriceStr(expenseDto.getPrice());
            expenseDto.setDateStr(expenseDto.getDate());

        }

        return expenseDtos;

    }

    public List<CardDto> getCards(Long categoryNum) {
        List<CardDto> recards = new ArrayList<>();

        List<Card> cards = cardRepository.findCardByCategoryId(categoryNum).orElseThrow(NullPointerException::new);
        for (Card card : cards) {
            recards.add(new CardDto(card.getName(), card.getDescription1(), card.getDescription2(),card.getImg()));
        }
        return recards;
    }

    public String getTotalByCategory(Category category) {

        DecimalFormat decFormat = new DecimalFormat("###,###");

        return decFormat.format(expenseRepository.getMyExpensesSumByCategory(41L, category).orElseThrow(NullPointerException::new));
    }
}
