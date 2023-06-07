package Samsung.service.controller;

import Samsung.service.dto.CardDto;
import Samsung.service.dto.ExpenseDto;
import Samsung.service.entity.Category;
import Samsung.service.entity.Expense;
import Samsung.service.repository.ExpenseRepository;
import Samsung.service.repository.MemberRepository;
import Samsung.service.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    private final MemberRepository memberRepository;
    private final ExpenseRepository expenseRepository;

    @GetMapping("/mydata")
    public String mydataAgree(Model model) {
        return "basic/mydataAgree";
    }

    @GetMapping("/spendAnalysis")
    public String spendAnalysis(Model model) {
        return "basic/spendAnalysis";
    }

    @GetMapping("/spendAnalysisReportNew")
    public String spendAnalysisReport(Model model) throws JsonProcessingException {

        DecimalFormat decFormat = new DecimalFormat("###,###");

        List<Integer> incomes = mainService.getIncomes(41L);
        model.addAttribute("fixedPercent", incomes.get(2));
        model.addAttribute("lastFixedPercent", 3);
        model.addAttribute("month", decFormat.format(incomes.get(0)));
        model.addAttribute("total", decFormat.format(incomes.get(1)));
        model.addAttribute("fixed", decFormat.format(incomes.get(0)));

        model.addAttribute("many", "식비");

        String jsonData = mainService.createMainChart(41L);
        model.addAttribute("jsonData", jsonData);

        return "basic/spendAnalysisReportNew";
    }

    @GetMapping("/spendAnalysisRecommend")
    public String spendAnalysisRecommend(Model model) {

        Long categoryNum = 1L;
        model.addAttribute("cards", mainService.getCards(categoryNum));

        return "basic/spendAnalysisRecommend";
    }

    @GetMapping("/spendAnalysisCompare")
    public String spendAnalysisCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "식비");
        model.addAttribute("category", "식비");
        model.addAttribute("text", "절약");

        // 배열

        String jsonData = mainService.createChart(Category.식비);d -A
        ObjectMapper objectMapper = new ObjectMapper();

        model.addAttribute("jsonData", jsonData);

        int many = ( expenseRepository.getMyExpensesSumByCategory(41L, Category.식비).get() - memberRepository.getSameAgeExpenseAverageFood().get() ) / 10000;
        model.addAttribute("maxSpendMoney", many);


        return "basic/spendAnalysisCompare";
    }

    @GetMapping("/spendList/{category}")
    public String spendList(Model model , @PathVariable("category") String category) {
        model.addAttribute("month", 5);
        model.addAttribute("totalMoney", mainService.getTotalByCategory(Category.valueOf(category)));
        model.addAttribute("category", category);
        model.addAttribute("items", mainService.getExpenseList(Category.valueOf(category)));

        return "basic/spendList";
    }

    @GetMapping("/recommendCard/{category}")
    public String recommendCard(Model model , @PathVariable("category") Long categoryNum) {
        model.addAttribute("cards", mainService.getCards(categoryNum));
        return "basic/spendAnalysisRecommend";
    }
}
