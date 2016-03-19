package jp.blackawa.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
    @RequestMapping("")
    public String index() { return "index"; }
}
