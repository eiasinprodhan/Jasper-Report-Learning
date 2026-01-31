package com.springboot.practice.controller;

import com.springboot.practice.dto.request.UserRequest;
import com.springboot.practice.dto.response.UserResponse;
import com.springboot.practice.service.ReportService;
import com.springboot.practice.service.UserService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/reports/{format}")
    public String getAllUsersByFormat(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
