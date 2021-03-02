package codegym.controller;

import codegym.dao.MailDao;
import codegym.model.MailSetting;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @GetMapping("/setting")
    public String setting(Model model){
        model.addAttribute("setting", new MailSetting());
        model.addAttribute("language", MailDao.languageList);
        model.addAttribute("pageSize", MailDao.pageSizeList);
        return "setting";
    }

    @PostMapping("/showSetting")
    public ModelAndView showSetting(@ModelAttribute("setting") MailSetting setting){
        return new ModelAndView("showSetting", "setting", setting);
    }
}
