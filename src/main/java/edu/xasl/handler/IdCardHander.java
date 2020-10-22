package edu.xasl.handler;

import edu.xasl.pojo.IdCard;
import edu.xasl.pojo.PagingForUser;
import edu.xasl.service.IdCardService;
import edu.xasl.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpSession;

@Controller("idCardHander")
@RequestMapping("/idCardHander")
public class IdCardHander {
    private IdCardService idCardService;



    @RequestMapping("/findAllIdcard.do")                                                 //分页查找身份证信息
    public String findAllIdcard(Integer currentPageNo, HttpSession session){
        PagingForUser pagingForUser=new PagingForUser();
        if(currentPageNo==null){
            currentPageNo=1;
        }
        pagingForUser.setCurrentPageNo(currentPageNo);
        pagingForUser.setPageUnit(Constant.PAGE_UNIT);
        PagingForUser pagingForUser1=idCardService.selectIdCard(pagingForUser);
        session.setAttribute("currentidcard",pagingForUser1);

       return "redirect:/IDcardmanagement.jsp";
    }
    @RequestMapping("/updateById.do")                                                     //更新身份证信息
    public String updateById(HttpSession session,String idcard_id){
        IdCard idCard = idCardService.upateFindByIdcard(idcard_id);
        session.setAttribute("idCard1",idCard);
        return "redirect:/updateidcard.jsp";
    }
    @RequestMapping("/updateidcard.do")                                                   //根据身份证id更新身份证信息
    public String updateidcard(String idcard_id,String idcard_no){
        boolean result=idCardService.updateidcard(idcard_id,idcard_no);
        if(result){
            return "redirect:afterUpdateidcard.do";
        }else {
            return "redirect:updateById.do";
        }

    }
    @RequestMapping("/afterUpdateidcard.do")
    public String afterUpdateidcard(HttpSession session){
        IdCard idCard1 = (IdCard) session.getAttribute("idCard1");
        int idcard_id=idCard1.getIdcard_id();
        IdCard idCard=new IdCard();
        idCard.setIdcard_id(idcard_id);
        IdCard idCard2 = idCardService.selectDeptById(idCard);
        session.setAttribute("idCard",idCard2);
        return "redirect:/Afteraddidcard.jsp";


    }
    @RequestMapping("/deleteById.do")                                                       //删除身份证信息
    public String deleteById(String idcard_id){
        idCardService.deleteById(idcard_id);
        return "redirect:findAllIdcard.do";

    }
    @RequestMapping("/insertIdCard.do")                                                     //添加身份证信息
    public String insertIdCard(String idcard_no){
        boolean b = idCardService.insertIdCard(idcard_no);
        if (b){
            return"redirect:findallIdCardno.do";
        }else {
            return"redirect:/addidcard.jsp";
        }
    }
    @RequestMapping("/findallIdCardno.do")                                                  //添加完倒叙
    public String findallIdCardno(Integer currentPageNo, HttpSession session){
            PagingForUser pagingForUser=new PagingForUser();
            if(currentPageNo==null){
                currentPageNo=1;
            }
            pagingForUser.setCurrentPageNo(currentPageNo);
            pagingForUser.setPageUnit(Constant.PAGE_UNIT);
            PagingForUser pagingForUser1=idCardService.findAllUserno(pagingForUser);
            session.setAttribute("currentidcard",pagingForUser1);

            return "redirect:/IDcardmanagement.jsp";
    }
    public IdCardService getIdCardService() {
        return idCardService;
    }
@Resource(name = "idCardServiceImp")
    public void setIdCardService(IdCardService idCardService) {
        this.idCardService = idCardService;
    }

}
