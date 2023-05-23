package Samsung.service.controller;

import Samsung.service.dto.CardDto;
import Samsung.service.dto.ExpenseDto;
import Samsung.service.entity.Category;
import Samsung.service.entity.Expense;
import Samsung.service.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

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
        model.addAttribute("fixedPercent", 34);
        model.addAttribute("lastFixedPercent", 3);
        model.addAttribute("month", 2000);
        model.addAttribute("total", 20000);
        model.addAttribute("fixed", 2032);

        model.addAttribute("many", "보험비");

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
        model.addAttribute("maxSpend", "보험비");
        model.addAttribute("maxSpendMoney", 8);
        model.addAttribute("category", "식비");

        int[] dataValues = new int[]{9, 30, 50};
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(dataValues);

        model.addAttribute("jsonData", jsonData);

        return "basic/spendAnalysisCompare";
    }

    @GetMapping("/spendList/{category}")
    public String spendList(Model model , @PathVariable("category") String category) {
        model.addAttribute("month", 5);
        model.addAttribute("totalMoney", 20000);
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
