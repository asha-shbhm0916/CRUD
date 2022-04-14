package com.CrudApplication.CRUD.Controller;

import com.CrudApplication.CRUD.model.User;
import com.CrudApplication.CRUD.modelImpl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TestController {

    @Autowired(required = true)
    private UserImpl userimpl;
    @GetMapping("/home")
    public String welocme()
    {
        return "home";
    }
    @GetMapping("home/add-details")
    public String add(){
        return "Add";
    }
    @GetMapping("home/get-details")
    public String Getthephone(){
        return "get-number";
    }
    @GetMapping("home/update")
    public String update()
    {
        return "update-details";
    }
    @GetMapping("home/delete")
    public  String delete()
    {
        return "delete-details";
    }
    //Create

    @PostMapping("/home/home/add-details/addUser")
    public String save(@RequestParam("email") String email ,
                       @RequestParam("first") String fName,
                       @RequestParam("last") String LName ,
                       @RequestParam("number") Integer number)
    {
        try {


                User user = new User(number, fName, LName, email);
                userimpl.saveuser(user);
            System.out.println(user.toString());

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return "DATASAVED";
    }

    //Read

    @PostMapping("/home/home/get-details/details")
    public String getuser(@RequestParam("number") Integer number , Model model)
    {
//            System.out.println(number);
//            Optional<User> user = userimpl.getuser(number);
//            if(user!= null) {
//                System.out.println(user.toString());
//                model.addAttribute("user",user.get());
//            }
//
//            else {
//                System.out.println("user with id = "+number +" is not found");
//                model.addAttribute("error","user not found");
//                return "get-number";
//            }
//         return "details";

        try {
            System.out.println(number);
            Optional<User> user = userimpl.getuser(number);
            model.addAttribute("user",user.get());
            return "details";
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            model.addAttribute("error","User is not found");

        }
        return "get-number";
    }

    //UPDATE

    @PostMapping("/home/home/update/updateuser")
    public String update(
                       @RequestParam("number") Integer number ,  Model model) {

           Optional<User> user = userimpl.getuser(number);
           if(user!=null)
           {
               return "ADD";
           }
           else
           {
               model.addAttribute("error","user not found");
           }
           return "update-details";

    }

    //update with details

    @PostMapping("/home/home/update/home/add-details/addUser")
    public String updatesave(@RequestParam("email") String email ,
                             @RequestParam("first") String fName,
                             @RequestParam("last") String LName ,
                             @RequestParam("number") Integer number)
    {
        try {


            User user = new User(number, fName, LName, email);
            userimpl.saveuser(user);
            System.out.println("updated user is = "+ user.toString());

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return "update-details";
    }

    //Delete
    @PostMapping("/home/home/delete/deleteuser")
    public String delete(@RequestParam("number") Integer numer,Model model)
    {
//        try {
//            userimpl.deleteuser(numer);
//            System.out.println("user with id  = " +numer+" is deleted");
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.toString());
//        }
//        return "DELET
        if(userimpl.deleteuser(numer))
        {
            model.addAttribute("success","User Deleted");
        }
        else
        {
            model.addAttribute("error","User Not Found");
        }
        return "delete-details";
    }
}
