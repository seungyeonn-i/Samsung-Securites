package Samsung.service.service;

import Samsung.service.dto.ExpenseDto;
import Samsung.service.entity.Category;
import Samsung.service.repository.ExpenseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final ExpenseRepository expenseRepository;

    public String createChart() throws JsonProcessingException {
        int[] dataValues = new int[]{9, 30, 50};
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dataValues);

    }

    public List<ExpenseDto> getExpenseList(Category category) {

        return expenseRepository.getExpensesByCategory(41L, category).orElseThrow(NullPointerException::new);

    }
}
