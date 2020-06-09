package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.CustomerForm;
import com.codegym.service.ICustomerService;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class homeController {
    @Autowired
    Environment env;
    @Autowired
    ICustomerService customerService;

    @GetMapping()
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customerForm", new CustomerForm());
        return modelAndView;
    }

    @PostMapping("customer")
    public ModelAndView saveFile(@ModelAttribute CustomerForm customerForm) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        Customer customer = new Customer(customerForm.getName(), null);
        MultipartFile multipartFile = customerForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(customerForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        customer.setAvatar(fileName);
        Customer customer1 = customerService.save(customer);
        if (customer1 == null) {
            modelAndView.addObject("message", "errors");
        } else {
            modelAndView.addObject("message", "ok");
        }
        modelAndView.addObject("customerForm", new CustomerForm());
        return modelAndView;

    }
}
