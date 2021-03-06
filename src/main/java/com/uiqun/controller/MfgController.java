package com.uiqun.controller;

import com.uiqun.model.Mfg;
import com.uiqun.service.MfgService;
import com.uiqun.utils.Encrypt_Dncrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class MfgController {
    @Resource
    private MfgService mfgService;
    //跳转网页
    @RequestMapping("/insertmfg")
    public String mfg(){
        return "addMfg";
    }
    //新增品牌
    @RequestMapping("/addmfg")
    public String addMfg(Model model, Mfg mfg, MultipartFile upload, HttpSession session){
        boolean flag =false;
        if(upload!=null){
            //图片上传
            //获取用户上传的Logo的文件名
            String filename = Encrypt_Dncrypt.getUpLoadFileName(session,upload,"logo");
            mfg.setMlogo(filename);
            try {
                String upfilelogin = session.getServletContext().getRealPath("upfilelogin");
                //保存路径&保存文件名
                upload.transferTo(new File(upfilelogin,filename));
                flag=true;
                //返回消息
                model.addAttribute("AlertMessage","添加品牌成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(mfg.getMfgName()==null){
            model.addAttribute("AlertMessage","添加品牌失败,必须填写中文或者英文");
        }
        if(flag){
            //添加到数据库
            mfgService.addMfg(mfg);
        }
        return "forward:/insertmfg";
    }
}
