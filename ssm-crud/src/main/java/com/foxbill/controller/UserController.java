package com.foxbill.controller;

import com.foxbill.pojo.User;
import com.foxbill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",userService.findAll());
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }


    @RequestMapping("/toModifyUser")
    public ModelAndView toModifyUser(int id){
        ModelAndView mv = new ModelAndView();
        System.out.println(id);
        System.out.println(userService.getUserById(id));
        mv.addObject("user",userService.getUserById(id));
        mv.setViewName("modifyUser");
        return mv;
    }
    @RequestMapping("/doModifyUser")
    public String doModifyUser(User user,
                               @RequestParam("uploadfile")List<MultipartFile> headImg,
                               HttpServletRequest request){
        //判断文件是否存在
        if (!headImg.isEmpty() && headImg.size() > 0){
            //循环输出上传的文件
            for (MultipartFile file : headImg) {
                String originalFilename = file.getOriginalFilename();
                String dirPath = request.getServletContext().getRealPath("/upload/");
                System.out.println(dirPath);
                File filePath = new File(dirPath);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                String newFilename = UUID.randomUUID() + "_" + originalFilename;
                try {
                    file.transferTo(new File(dirPath +"/"+ newFilename));
                    user.setHeadImg(newFilename);
                    System.out.println(user);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            userService.modifyUser(user);
            return "redirect:findAll.do";
        }else {
            userService.modifyUserNoImg(user);
        }

        return "redirect:findAll.do";
    }

    @RequestMapping("/doDeleteUser")
    public String doDeleteUser(int id){
        userService.dropUser(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/upload")
    public String fileUpload(){
        return "addUser";
    }

    @RequestMapping("/doAddUser")
//    public String handleFormUpload(@RequestParam("username") String username,
    public String handleFormUpload(User user,
                                   @RequestParam("uploadfile")List<MultipartFile> headImg,
                                   HttpServletRequest request){
            //判断文件是否存在
        if (!headImg.isEmpty() && headImg.size() > 0){
            //循环输出上传的文件
            for (MultipartFile file : headImg) {
                String originalFilename = file.getOriginalFilename();
                String dirPath = request.getServletContext().getRealPath("/upload/");
                System.out.println(dirPath);
                File filePath = new File(dirPath);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                String newFilename = UUID.randomUUID() + "_" + originalFilename;
                try {
                    file.transferTo(new File(dirPath +"/"+ newFilename));
                    user.setHeadImg(newFilename);
                    System.out.println(user);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            userService.addUser(user);
            return "redirect:findAll.do";
        }else {
            return "error";
        }
    }

}
