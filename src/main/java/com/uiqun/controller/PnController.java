package com.uiqun.controller;

import com.uiqun.service.PnService;
import com.uiqun.utils.Encrypt_Dncrypt;
import com.uiqun.utils.ImportExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class PnController {
    @Resource
    private PnService pnService;

    @RequestMapping("/importExcle")
    public String importExclePnList(Model model, MultipartFile upload, HttpSession session) throws Exception {
        boolean flag =false;
        String filename = null;
        String upfilelogin =null;
        if(upload!=null){
            //图片上传
            //获取用户上传的Logo的文件名
            filename = Encrypt_Dncrypt.getUpLoadFileName(session,upload,"importExcle");
            try {
                upfilelogin = session.getServletContext().getRealPath("upfilelogin");
                //保存路径&保存文件名
                upload.transferTo(new File(upfilelogin,filename));
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(flag){
            if(filename==null||upfilelogin==null){
                model.addAttribute("AlertMessage","添加型号失败");
                return "forward:/addPnsPage";
            }else{
                upfilelogin+="/"+filename;
            }
            String filepath = upfilelogin;
            FileInputStream inputStream = new FileInputStream(new File(filepath));
            List<List<Object>> list = ImportExcelUtil.getBankListByExcel(inputStream, filepath);
            //添加到数据库
            pnService.insertPns(list);
            //删除以添加到数据库中的文件
            File file = new File(filepath);
            if(file.exists()){
                file.delete();
            }
            //返回消息
            model.addAttribute("AlertMessage","添加型号成功");
        }else{
            model.addAttribute("AlertMessage","添加型号失败");
        }
        return "forward:/addPnsPage";
    }

    @RequestMapping("/addPnsPage")
    public String importExclePnList(){
        return "Xpn";
    }
}
