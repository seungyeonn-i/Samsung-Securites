package Samsung.service.controller;

import Samsung.service.entity.Category;
import Samsung.service.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SubController {

    private final MainService mainService;

    @GetMapping("/getFoodCompare")
    public String FoodCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "식비");
        model.addAttribute("maxSpendMoney", 8);
        model.addAttribute("category", "식비");

        String jsonData = mainService.createChart(Category.식비);
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
//        return "redirect:/spendAnalysisCompare";
    }
    @GetMapping("/getTransportCompare")
    public String getTransportCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "교통비");
        model.addAttribute("maxSpendMoney", 8);
        model.addAttribute("category", "교통비");


        String jsonData = mainService.createChart(Category.교통비);
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getSubscribeCompare")
    public String getSubscribeCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "통신비");
        model.addAttribute("maxSpendMoney", 8);
        model.addAttribute("category", "구독비");

        String jsonData = mainService.createChart(Category.구독비);
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getHousingCompare")
    public String getHousingCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "주거비");
        model.addAttribute("maxSpendMoney", 8);
        model.addAttribute("category", "주거비");


        String jsonData = mainService.createChart(Category.주거비);
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getInsuranceCompare")
    public String getInsuranceCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "보험비");
        model.addAttribute("maxSpendMoney", 8);
        model.addAttribute("category", "보험비");


        String jsonData = mainService.createChart(Category.보험비);
        model.addAttribute("jsonData", jsonData);

        return "basic/spendAnalysisCompare";
    }






}
