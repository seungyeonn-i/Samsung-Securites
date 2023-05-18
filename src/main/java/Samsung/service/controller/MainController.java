package Samsung.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainController {


    @GetMapping("/mydata")
    public String mydataAgree(Model model){
        return "basic/mydataAgree";
    }
    @GetMapping("/spendAnalysis")
    public String spendAnalysis(Model model){
        return "basic/spendAnalysis";
    }
    @GetMapping("/spendAnalysisReportNew")
    public String spendAnalysisReport(Model model){
        model.addAttribute("fixedPercent", 34);
        model.addAttribute("lastFixedPercent", 3);
        model.addAttribute("month",2000);
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
    public String spendAnalysisRecommend(Model model){
        return "basic/spendAnalysisRecommend";
    }
    @GetMapping("/spendAnalysisCompare")
    public String spendAnalysisCompare(Model model){
        model.addAttribute("maxSpend", "보험비요");
        model.addAttribute("maxSpendMoney", 8);

        return "basic/spendAnalysisCompare";
    }

}
