package Samsung.service.controller;

import Samsung.service.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SubController {

    private final MainService mainService;

    @GetMapping("/getFoodCompare")
    public String FoodCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "식비");
        model.addAttribute("maxSpendMoney", 8);

        String jsonData = mainService.createChart();
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getTransportCompare")
    public String getTransportCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "교통비");
        model.addAttribute("maxSpendMoney", 8);

        String jsonData = mainService.createChart();
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getSubscribeCompare")
    public String getSubscribeCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "구독비");
        model.addAttribute("maxSpendMoney", 8);

        String jsonData = mainService.createChart();
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getHousingCompare")
    public String getHousingCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "주거비");
        model.addAttribute("maxSpendMoney", 8);

        String jsonData = mainService.createChart();
        model.addAttribute("jsonData", jsonData);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getInsuranceCompare")
    public String getInsuranceCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "보험비");
        model.addAttribute("maxSpendMoney", 8);

        String jsonData = mainService.createChart();
        model.addAttribute("jsonData", jsonData);

        return "basic/spendAnalysisCompare";
    }


}
