//package com.magang.plnicon.controller;
//
//import com.magang.plnicon.entity.Form;
//import com.magang.plnicon.exception.error.GlobalSettings;
//import com.magang.plnicon.repository.UserRepository;
//import com.magang.plnicon.service.FormService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@Controller
//public class FormController {
//
//    private final FormService formService;
//    private final UserRepository userRepository;
//
//    private GlobalSettings globalSettings;
//
//
//    @Autowired
//    public FormController(FormService formService, UserRepository userRepository) {
//        this.formService = formService;
//        this.userRepository = userRepository;
//    }
//
//    @RequestMapping(value = "/form", method = RequestMethod.GET)
//    public ModelAndView form() {
//        ModelAndView modelAndView = new ModelAndView();
//        Form form = new Form();
//        modelAndView.addObject("form", form);
//        modelAndView.setViewName("/form");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/form", method = RequestMethod.POST)
//    public ModelAndView formSubmit(@Valid Form form, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("/form");
//        } else {
//
//            String approver1 = globalSettings.majorToApproverMap.get((form.getMajor()));
//            form.setApprover1(globalSettings.majorToApproverMap.get((form.getMajor())));
//            form.setApprover2("approver2");
//            formService.saveForm(form);
//            modelAndView.addObject("successMessage", "Submitted successfully! You will receive an email confirmation shortly.");
//            modelAndView.addObject("form", new Form());
//            modelAndView.setViewName("/form");
//        }
//        return modelAndView;
//    }
//
//    //This is the code for changing the Torah Study Form
////    @RequestMapping(value = "/changeTS", method = RequestMethod.GET)
////    public ModelAndView changeTS() {
////        ModelAndView modelAndView = new ModelAndView();
////        ChangeTS changeTS = new ChangeTS();
////        modelAndView.addObject("changeTS", changeTS);
////        modelAndView.setViewName("/changeTS");
////        return modelAndView;
////    }
//
//    @RequestMapping(value = "/changeTS", method = RequestMethod.POST)
//    public ModelAndView changeTS(@Valid ChangeTS changeTS, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        if (bindingResult.hasErrors())
//        {
//            modelAndView.setViewName("/changeTS");
//        }
//        else {
//            String approver1 = globalSettings.torahStudiesToApproverMap.get((changeTS.getSwitchIntoProgam()));
//            changeTS.setApprover1(approver1);
//            changeTS.setApprover2("approver2");
//            changeTS.setApprover3(globalSettings.torahStudiesToApproverMap.get((changeTS.getCurrentProgram())));
//            changeTSService.saveForm(changeTS);
//
//            String approver1Email = userRepository.findByUsername(approver1).get().getEmail();
//            try {
//                emailService.sendNewApprovalHtmlMessage(approver1Email, (globalSettings.accessibleWebsiteUrl + "processingPage/processChangeTSForm/"+changeTS.getId()) );
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            try {
//                emailService.sendInitialStudentMessage(changeTS.getEmail(), changeTS.getTrackingId(), changeTS.getName(), changeTS.getSwitchIntoProgam(), "changeTS");
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            modelAndView.addObject("successMessage", "Submitted successfully! You will receive an email confirmation shortly.");
//            modelAndView.addObject("changeTS", new ChangeTS());
//            modelAndView.setViewName("/changeTS");
//        }
//        return modelAndView;
//
//    }
//
//    //This is the controller for the leave of absence form
//
//    @RequestMapping(value = "/leaveOfAb", method = RequestMethod.GET)
//    public ModelAndView leaveOfAb() {
//        ModelAndView modelAndView = new ModelAndView();
//        LeaveOfAb leaveOfAb = new LeaveOfAb();
//        modelAndView.addObject("leaveOfAb", leaveOfAb);
//        modelAndView.setViewName("/leaveOfAb");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/leaveOfAb", method = RequestMethod.POST)
//    public ModelAndView leatveOfAb(@Valid LeaveOfAb leaveOfAb, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("/leaveOfAb");
//        }
//        else {
//            leaveOfAb.setApprover1(globalSettings.registrar);//This is the registrar
//            String schoolDean = globalSettings.schoolToDeanMap.get((leaveOfAb.getSchool()));
//            leaveOfAb.setApprover2(schoolDean);
//            leaveOfAb.setApprover3(globalSettings.registrar);//this is for the registrar
//            leaveOfAbService.saveForm(leaveOfAb);
//
//            String approver1Email = userRepository.findByUsername(globalSettings.registrar).get().getEmail();
//            try {
//                emailService.sendNewApprovalHtmlMessage(approver1Email, (globalSettings.accessibleWebsiteUrl + "processingPage/processLeaveOfAbForm/"+leaveOfAb.getId()) );
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            try {
//                emailService.sendInitialStudentMessage(leaveOfAb.getEmail(), leaveOfAb.getTrackingId(), leaveOfAb.getName(), leaveOfAb.getSchool(), "leaveOfAb");
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            modelAndView.addObject("successMessage", "Submitted successfully! You will receive an email confirmation shortly.");
//            modelAndView.addObject("leaveOfAb", new LeaveOfAb());
//            modelAndView.setViewName("/leaveOfAb");
//        }
//        return modelAndView;
//    }
//}