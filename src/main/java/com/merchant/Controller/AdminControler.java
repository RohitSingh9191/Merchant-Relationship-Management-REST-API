package com.merchant.Controller;

import com.merchant.Authentication.Adminlogin;
import com.merchant.Model.RequestBody.JwtRequest;
import com.merchant.Model.ResponseBody.JwtResponse;
import com.merchant.Model.ResponseBody.ResponseClass;
import com.merchant.Service.AdminService.AdminImplimentation;
import com.merchant.Utils.JwtHelper;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.logging.Logger;

@RestController
@RequestMapping("admin")
public class AdminControler {

    @Autowired
    private AdminImplimentation adminService;


    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<ResponseClass> adminLogin(@Valid @RequestBody Adminlogin adminlogin) {

        return adminService.adminAuthentication(adminlogin);
    }

    @RequestMapping("/currenUser")
    public String getlogginUser(Principal principal){
        //This interface represents the abstract notion of a principal, which can be used to represent any entity, such as an individual, a corporation, and a login id.
        return principal.getName();
    }

}
