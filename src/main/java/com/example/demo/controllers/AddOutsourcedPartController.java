package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("outsourcedpart",part);
        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }
        else {
            try{
                if(!part.validMinAndMaxInv()) {
                    bindingResult.rejectValue("maxInv", "minAndMaxInventory.invalid", "Max inventory value must be greater than Min inventory value");
                    return "OutsourcedPartForm";
                }
                else if(!part.validInv()) {
                    bindingResult.rejectValue("inv", "inventory.invalid", "Inventory must be between " + part.getMinInv() + " and " + part.getMaxInv());
                    return "OutsourcedPartForm";
                }
                else{
                    OutsourcedPartService repo=context.getBean(OutsourcedPartServiceImpl.class);
                    OutsourcedPart op=repo.findById((int)part.getId());
                    if(op!=null)part.setProducts(op.getProducts());
                    repo.save(part);
                    return "confirmationaddpart";
                }

            } catch (IllegalStateException e){
                System.out.print(e.getMessage());
                return "OutsourcedPartForm";
            }
        }
    }
}
