package Samsung.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubController {

    @GetMapping("/getFoodCompare")
    public String FoodCompare(Model model) {
        model.addAttribute("maxSpend", "식비");
        model.addAttribute("maxSpendMoney", 8);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getTransportCompare")
    public String getTransportCompare(Model model) {
        model.addAttribute("maxSpend", "교통비");
        model.addAttribute("maxSpendMoney", 8);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getSubscribeCompare")
    public String getSubscribeCompare(Model model) {
        model.addAttribute("maxSpend", "구독비");
        model.addAttribute("maxSpendMoney", 8);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getHousingCompare")
    public String getHousingCompare(Model model) {
        model.addAttribute("maxSpend", "주거비");
        model.addAttribute("maxSpendMoney", 8);
        return "basic/spendAnalysisCompare";
    }
    @GetMapping("/getInsuranceCompare")
    public String getInsuranceCompare(Model model) {
        model.addAttribute("maxSpend", "보험비");
        model.addAttribute("maxSpendMoney", 8);
        return "basic/spendAnalysisCompare";
    }
}
