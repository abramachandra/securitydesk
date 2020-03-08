package com.codepirates.securitydesk.controller;


import com.codepirates.securitydesk.model.LateNightConeyanceModel;
import com.codepirates.securitydesk.repository.EmployeeDAL;
import com.codepirates.securitydesk.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SecurityDeskController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDAL employeeDAL;

    public SecurityDeskController(EmployeeRepository employeeRepository, EmployeeDAL employeeDAL) {
        this.employeeRepository = employeeRepository;
        this.employeeDAL = employeeDAL;
    }

    @RequestMapping(value = "/createLNCEntry", method = RequestMethod.POST)
    public LateNightConeyanceModel addNewLNCEntry(@RequestBody LateNightConeyanceModel lateNightConeyanceModel) {
        lateNightConeyanceModel.setCheckInTime (LocalDate.now ());
        return employeeDAL.addNewLateNightEntry(lateNightConeyanceModel);
    }

    @RequestMapping(value = "/getLNCEntry", method = RequestMethod.GET)
    public List<LateNightConeyanceModel> getLNCEntry() {
        return employeeDAL.getAllEmployee ();
    }

}
