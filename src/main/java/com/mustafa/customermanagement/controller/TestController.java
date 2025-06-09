package com.mustafa.customermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-security-manager")
    public String testSecurityManager()
    {
        String securityManagerProp = System.getProperty("java.security.manager");
        boolean isSecurityManagerEnabled = securityManagerProp != null && !securityManagerProp.isEmpty();
       // return "Security Manager:" + (isSecurityManagerEnabled ? "Enabled(via Property :" + securityManagerProp + : "Disabled");
        return "Security Manager: " + (isSecurityManagerEnabled ? "Enabled (via property: " + securityManagerProp + ")" : "Disabled");
    }
}
