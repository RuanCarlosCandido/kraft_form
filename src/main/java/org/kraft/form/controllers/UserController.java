package org.kraft.form.controllers;

import java.util.ArrayList;
import java.util.List;

import org.kraft.form.domain.entities.Partner;
import org.kraft.form.domain.entities.UserInfo;
import org.kraft.form.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getUsers(Model model) {
    List<UserInfo> users = userService.getUsers();
    model.addAttribute("users", users);
    model.addAttribute("userInfo", new UserInfo());
    model.addAttribute("partners", mockList());
    model.addAttribute("partner", new Partner());

    return "homePage";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String createUser(Model model, @ModelAttribute UserInfo userInfo) {
    UserInfo user = userService.createUser(userInfo);
    return "redirect:/users/";
  }
  
  
  @RequestMapping(value = "/partner", method = RequestMethod.POST)
  public String postPartner(Model model, @ModelAttribute Partner partner) {
	  System.out.println(partner.getId());
	  return "redirect:/users/";
  }
  
  private List<Partner> mockList() {
	List<Partner> partners = new ArrayList<Partner>();
	partners.add(new Partner(1, "JOAO"));
	partners.add(new Partner(2, "JOSE"));
	partners.add(new Partner(3, "MARIA"));
	return partners;
}

}
