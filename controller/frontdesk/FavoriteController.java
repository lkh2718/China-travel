package com.itbaizhan.travel.controller.frontdesk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Member;
import com.itbaizhan.travel.pojo.Product;
import com.itbaizhan.travel.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frontdesk/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    // 收藏
    @RequestMapping("/add")
    // session是为了拿到mid，请求头可以拿到从哪里来的
    public String addFavorite(Integer pid, HttpSession session, @RequestHeader("Referer") String referer){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        favoriteService.addFavorite(pid,mid);
        return "redirect:"+referer;
    }

    // 取消收藏
    @RequestMapping("/del")
    public String delFavorite(Integer pid, HttpSession session, @RequestHeader("Referer") String referer){
        Member member = (Member) session.getAttribute("member");
        Integer mid = member.getMid();
        favoriteService.delFavorite(pid,mid);
        return "redirect:"+referer;
    }

    // 我的收藏
    @RequestMapping("/myFavorite")
    public ModelAndView myFavorite(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Member member = (Member) session.getAttribute("member");
        Page<Product> productPage = favoriteService.findMemberFavorite(page, size, member.getMid());
        modelAndView.addObject("productPage",productPage);
        modelAndView.setViewName("/frontdesk/my_favorite");
        return modelAndView;

    }
}
