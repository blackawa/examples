package jp.blackawa.examples.controller;

import jp.blackawa.examples.service.ExamplesService;
import jp.blackawa.examples.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class ExamplesController {

    private static final int RECORD_PER_PAGE = 10;
    private static final int LENGTH = 5;

    @Autowired
    private ExamplesService examplesService;

    @RequestMapping("")
    public String index(@RequestParam(required = false) final String page, Model model) {
        int currentPage = 1;
        if (page != null) {
            try {
                currentPage = Integer.parseInt(page);
            } catch (NumberFormatException e) {
                currentPage = 1;
            }
        }
        model.addAttribute("records", examplesService.find(currentPage, RECORD_PER_PAGE));
        int totalRecordNum = examplesService.count();
        model.addAttribute(
                "paging",
                PagingUtil.generatePagingView(
                        currentPage,
                        totalRecordNum,
                        RECORD_PER_PAGE,
                        LENGTH,
                        new HashMap<>()));
        return "index";
    }
}
