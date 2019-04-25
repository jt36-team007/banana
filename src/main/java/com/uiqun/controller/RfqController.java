package com.uiqun.controller;

import com.uiqun.model.Rfq;
import com.uiqun.service.RfqService;
import com.uiqun.utils.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class RfqController {
    @Resource
    private RfqService rfqService;

    @RequestMapping("/index")
    public String index(Model model, Pager<Rfq> pager, HttpSession session){
        model.addAttribute("user",session.getAttribute("user"));
        model.addAttribute("pager",rfqService.queryRfqList(pager));
        return "index";
    }
    @RequestMapping("/inMfg/{rfqno}")
    public String inMfg(Model model, HttpSession session,Pager<Rfq> pager,@PathVariable("rfqno") String rfqno){
        model.addAttribute("user", session.getAttribute("user"));
        if(rfqno!=null&&!"".equals(rfqno)) {
            pager.getCondition().put("rfqno",rfqno);
            Pager<Rfq> rfqPager = rfqService.queryRfqList(pager);
            model.addAttribute("rfq", rfqPager.getDatas().get(0));
            return "quote";
        }
        return null;
    }
}
