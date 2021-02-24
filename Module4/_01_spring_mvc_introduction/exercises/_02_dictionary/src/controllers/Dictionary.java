package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @RequestMapping(value = "/home")
    public ModelAndView getHomepage() {
        return new ModelAndView("dictionary");
    }

    @RequestMapping(value = "/search")
    public String search(@RequestParam String word, Model model) {
        Map<String, String> dictionary = new HashMap();
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("computer", "máy tính");
        dictionary.put("information", "thông tin");
        dictionary.put("developer", "nhà phát triển");
        String english = word.trim().toLowerCase();
        String vietnamese = dictionary.get(english);
        model.addAttribute("english", english);
        if (vietnamese != null){
            model.addAttribute("vietnamese", vietnamese);
        } else {
            model.addAttribute("vietnamese", "Không tìm thấy từ này trong từ điển");
        }
        return "dictionary";
    }
}
