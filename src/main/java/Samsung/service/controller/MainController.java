package Samsung.service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainController {


    @GetMapping("/mydata")
    public String mydataAgree(Model model) {
        return "basic/mydataAgree";
    }

    @GetMapping("/spendAnalysis")
    public String spendAnalysis(Model model) {
        return "basic/spendAnalysis";
    }

    @GetMapping("/spendAnalysisReportNew")
    public String spendAnalysisReport(Model model) {
        model.addAttribute("fixedPercent", 34);
        model.addAttribute("lastFixedPercent", 3);
        model.addAttribute("month", 2000);
        model.addAttribute("total", 20000);
        model.addAttribute("fixed", 2032);
//        String[] arrays = {
//                "3","4","5","6","2"
//        };
//        model.addAttribute("array", arrays);
        model.addAttribute("many", "보험비");
        return "basic/spendAnalysisReportNew";
    }

    @GetMapping("/spendAnalysisRecommend")
    public String spendAnalysisRecommend(Model model) {
        return "basic/spendAnalysisRecommend";
    }

    @GetMapping("/spendAnalysisCompare")
    public String spendAnalysisCompare(Model model) throws JsonProcessingException {
        model.addAttribute("maxSpend", "보험비");
        model.addAttribute("maxSpendMoney", 8);

        int[] dataValues = new int[]{9, 30, 50};
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(dataValues);

        model.addAttribute("jsonData", jsonData);

        return "basic/spendAnalysisCompare";
    }

    @GetMapping("/spendList")
    public String spendList(Model model) {
        return "basic/spendList";
    }
}
