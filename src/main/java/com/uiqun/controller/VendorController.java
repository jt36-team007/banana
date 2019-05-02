package com.uiqun.controller;

import com.uiqun.model.Vendor;
import com.uiqun.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class VendorController {
    @Resource
    private VendorService vendorService;

    @RequestMapping("/vendor")
    public List<Vendor> queryVendor(){
        return vendorService.queryVendor();
    }
}
