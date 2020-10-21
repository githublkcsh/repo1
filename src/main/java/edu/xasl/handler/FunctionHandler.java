package edu.xasl.handler;

import edu.xasl.pojo.Authority;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.service.FunctionService;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("FunctionHandler")
@RequestMapping("/functionHandler")
public class FunctionHandler {
    private FunctionService functionService;
    @RequestMapping("/addfunction.do")
    public String addfunction(String function_name,String function_address,String fatherFunction){
        boolean result=functionService.addfunction(function_name,function_address,fatherFunction);
        if(result){
            return "redirect:selectFunction.do";
        }else {
            return "redirect:";
        }
    }
    @RequestMapping("/findAllFatherFunction.do")
    public String findAllFatherFunction(HttpSession session){
       List<Authority> list=functionService.findAllFatherFunction();
       session.setAttribute("allFatherFunction",list);
       return"redirect:/addfuntion.jsp";
    }
    @RequestMapping("/selectFunction.do")
    public String selectFunction(Integer currentPageNo, HttpSession session){
        PagingForUser pagingForUser=new PagingForUser();
        if(currentPageNo==null){
            currentPageNo=1;
        }
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1=functionService.selectFunction(pagingForUser);
        session.setAttribute("currentfunction",pagingForUser1);

        return "redirect:/showFunction.jsp";
    }
    @RequestMapping("/selectFunctionById.do")
    public String selectFunctionById(String function_id,HttpSession session){
        Authority authority = functionService.selectFunctionById(function_id);

        List<Authority>list=functionService.findAllFatherFunction();
        session.setAttribute("updateFunction",authority);
        session.setAttribute("allFatherFunction1" ,list);

        return "redirect:/updatefunction.jsp";

    }
    @RequestMapping("/updatefunction.do")
    public String updatefunction(String function_name,String function_address,String fatherFunction_name ,HttpSession session){
        Authority authority= (Authority) session.getAttribute("updateFunction");
        int function_id=authority.getFunction_id();
        Boolean result = functionService.updateFunction(function_name, function_address, fatherFunction_name,function_id);
        if(result){
            return "redirect:selectFunction.do";
        }else{
            return "";
        }


    }
    @RequestMapping("/deleteFunction.do")
    public String deleteFunction(String function_id){
        boolean b=functionService.deleteFunction(function_id);
        if (b){
            return "redirect:selectFunction.do";
        }else {
            return"";
        }
    }

    public FunctionService getFunctionService() {
        return functionService;
    }
@Resource(name="functionServiceImp")
    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
