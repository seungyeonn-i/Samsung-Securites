package Samsung.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/chart")
    public String chart(Model model){
        return "basic/basic";
    }
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
        return "basic/spendAnalysisReportNew";
    }

}
