package edu.xasl.handler;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("roleHandler1")
@RequestMapping("/roleHandler1")
public class dddd {
    @RequestMapping("/addrole.do")
    public String addrole(@Param("role_name") String role_name, @Param("functions") String functions) {
        String f = functions;
        System.out.println(functions);
        System.out.println(role_name);
        String[] functionArray = f.split("\\.");
        System.out.println(functionArray.length);
        for (int n = 0; n < functionArray.length; n++) {
            System.out.println(functionArray[n]);
        }
        return "redirect:/addRole.jsp";
    }
}
