package com.springdemo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.model.Admin;
import com.springdemo.model.Location;
import com.springdemo.model.Message;
import com.springdemo.model.User;
import com.springdemo.repository.AdminRepository;
import com.springdemo.repository.LocationRepository;
import com.springdemo.repository.MessageRepository;
import com.springdemo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignupController {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AdminRepository aRepo;
	
	@Autowired
	private LocationRepository lRepo;
	
	@Autowired
	private MessageRepository mRepo;
	
	@Value("${springBootDemo.image}")     
	private String uploadDir;

	
	@GetMapping("/")
	public String frontPage()
	{
		return "index.html";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User u)
	{
		uRepo.save(u);
		return "login.html";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login.html";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "home.html";
	}
	
	@GetMapping("/signup")
	public String signup()
	{
		return "signup.html";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "adminLogin.html";
	}
	
	@GetMapping("/adminHome")
	public String adminHome()
	{
		return "adminHome.html";
	}
	
	
/* LogIns */
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User u, Model model, HttpSession session)
	{
		if(uRepo.existsByEmailAndPassword(u.getEmail(), u.getPassword()))
		{
			session.setAttribute("activeUser", u.getUserName());
			session.setMaxInactiveInterval(5);
			
			return "home.html";
		}
		else {
			model.addAttribute("error", "Incorrect Email or Password");
			return "login.html";
		}
	}

	  @PostMapping("/adminLogin")
		public String adminLogin(@ModelAttribute Admin u, Model model, HttpSession session)
		{
			if (u.getEmail().equals("admin@kaata.com") && u.getPassword().equals("Admin@123")){
				session.setAttribute("activeUser", "Admin");
				session.setMaxInactiveInterval(5);
				return "adminHome.html";
				
			}else {
				if(aRepo.existsByEmailAndPassword(u.getEmail(), u.getPassword()))
				{
					session.setAttribute("id", u.getId());
					session.setAttribute("activeUser", u.getName());
					session.setMaxInactiveInterval(500);
					
					return "staffHome.html";
				}
				else {
					model.addAttribute("adminError", "Incorrect Email or Password");
					return "adminLogin.html";
				}
			}
		}
	
	
/* User */
	@GetMapping("/userAdd")
	public String userAdd()
	{
		return "addUser.html";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User a, Model model)
	{
		uRepo.save(a);
		List<User> adminList = uRepo.findAll();
		model.addAttribute("uList",adminList);
		return "userTable.html";
	}
	
	@GetMapping("/userTable")
	public String userTable(@ModelAttribute User a, Model model)
	{
		
		List<User> adminList = uRepo.findAll();
		model.addAttribute("uList",adminList);
		return "userTable.html";
	}
	
	  @GetMapping("/editUser/{id}") public String editForm(@PathVariable int id, Model
	  model, HttpSession session) {
	  
			/*
			 * if(session.getAttribute("activeUser")==null) { session.setAttribute("error",
			 * "Please login first"); return "adminLogin.html"; }
			 */
	  User u= uRepo.getById(id);
	  
	  model.addAttribute("userObject",u);
	  
	  return "editForm.html"; 
	  }
	  
	  @PostMapping("/editUser") public String edit(@ModelAttribute User u, Model model)
	  { uRepo.save(u); model.addAttribute("uList",uRepo.findAll());
	  
	  return "redirect:/userTable"; 
	  }
	  
	  @GetMapping("/deleteUser/{id}") public String deleteAData(@PathVariable int id,
	  Model model) { 
		  uRepo.deleteById(id);
			/* model.addAttribute("uList",uRepo.findAll()); */
	      return "redirect:/userTable"; 
	  }
	  
	  
/* Staff */
	  @GetMapping("/staffHome")
		public String staffHome()
		{
			return "staffHome.html";
		}
		
		@GetMapping("/staffAdd")
		public String staffAdd()
		{
			return "addStaff.html";
		}
		
	  @PostMapping("/addStaff")
		public String addStaff(@ModelAttribute Admin a, Model model)
		{
			aRepo.save(a);
			List<Admin> adminList = aRepo.findAll();
			model.addAttribute("aList",adminList);
			return "staffTable.html";
		}
	  
	  @GetMapping("/staffTable")
		public String staffTable(@ModelAttribute Admin a, Model model)
		{
			
			List<Admin> adminList = aRepo.findAll();
			model.addAttribute("aList",adminList);
			return "staffTable.html";
		}
	  
	  @GetMapping("/editStaff/{id}") 
	  public String editStaffForm(@PathVariable int id, Model model, HttpSession session) {
			  
			/*
			 * if(session.getAttribute("activeUser")==null) { session.setAttribute("error",
			 * "Please login first"); return "adminLogin.html"; }
			 */
			  Admin a= aRepo.getById(id);
			  
			  model.addAttribute("adminObject", a);
			  
			  return "editStaff.html"; 
			  }
	  
	  @GetMapping("/deleteStaff/{id}") 
	  public String deleteStaffData(@PathVariable int id, Model model) 
	  { 
	    aRepo.deleteById(id);
		/* model.addAttribute("aList",aRepo.findAll()); */
	    return "redirect:/staffTable"; 
			  
	  }

	  
/* Location */
	  @GetMapping("/locationAdd")
		public String locationAdd()
		{
			return "addLocation.html";
		}
		
		@GetMapping("/locationTable")
		public String locationTable(@ModelAttribute Location l, Model model)
		{
			List<Location> locationList = lRepo.findAll();
			model.addAttribute("loList",locationList);
			return "locationTable.html";
		}
		
	  @PostMapping("/addLocation")
		public String addLocation(@ModelAttribute Location l, BindingResult result, Model model, @RequestParam("logo") MultipartFile file) {
		   

		    try {
		        if (!file.isEmpty()) {
		            byte[] bytes = file.getBytes();
		            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		            Path path = Paths.get(uploadDir + fileName);
		            Files.write(path, bytes);
		            l.setLogo(fileName);
		        }
		        lRepo.save(l);
		    } catch (IOException e) {
		        // Handle file processing errors // Replace "error_template" with the template name for displaying errors
		    }
		    List<Location> locationList = lRepo.findAll();
			model.addAttribute("loList",locationList);
		    return "locationTable.html"; // Replace with the appropriate template for displaying location table
		}
	  
	  @GetMapping("/editLocation/{id}") 
	  public String editLocationForm(@PathVariable int id, Model model, HttpSession session) {
			  
			/*
			 * if(session.getAttribute("activeUser")==null) { session.setAttribute("error",
			 * "Please login first"); return "adminLogin.html"; }
			 */
			  Location l= lRepo.getById(id);
			  
			  model.addAttribute("locationObject", l);
			  
			  return "editLocation.html"; 
			  }
			  
			  @PostMapping("/editStaff") 
			  public String editStaff(@ModelAttribute Admin a, Model model)
			  { 
				  aRepo.save(a); 
				  model.addAttribute("aList",aRepo.findAll());
			  
			  return "redirect:/staffTable"; 
			  }
			  
	  @PostMapping("/editLocation") 
	  public String editLocation(@ModelAttribute Location l, BindingResult result, Model model, @RequestParam("logo") MultipartFile file)
	  { 
		  try {
		        if (!file.isEmpty()) {
		            byte[] bytes = file.getBytes();
		            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		            Path path = Paths.get(uploadDir + fileName);
		            Files.write(path, bytes);
		            l.setLogo(fileName);
		        }
		        lRepo.save(l);
		    } catch (IOException e) {
		        // Handle file processing errors // Replace "error_template" with the template name for displaying errors
		    }
		  lRepo.save(l); 
		  model.addAttribute("aList",lRepo.findAll());
	  
	  return "redirect:/locationTable"; 
	  }
	  
	  @GetMapping("/deleteLocation/{id}") 
	  public String deleteLocationData(@PathVariable int id, Model model) 
	  { 
	    lRepo.deleteById(id);
		/* model.addAttribute("aList",aRepo.findAll()); */
	    return "redirect:/locationTable"; 
			  
	  }
	  
	  
/* Search */	  
	  @GetMapping("/search")
		public String getSearchByAddress(@RequestParam("address") String address, Model model){
			
		  List<Location> locationList = lRepo.findByAddress(address);
			model.addAttribute("aList", locationList);
			/* Location uList = lRepo.findByAddress(address).get(); */
			
			return "search.html";
		}
		
	  
/* message */
	@PostMapping("/sendMessage")
	public String addMessage(@ModelAttribute Message m)
	{
		mRepo.save(m);
		return "redirect:/";
	}
	
	@GetMapping("/messageTable")
	public String messageTable(@ModelAttribute Message m, Model model)
	{
		
		List<Message> adminList = mRepo.findAll();
		model.addAttribute("mList",adminList);
		return "messageTable.html";
	}
	
/* LogOuts */	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "login.html";
		
	}
	@GetMapping("/adminLogout")
	public String adminLogout(HttpSession session) {
		
		session.invalidate(); 
		return "adminLogin.html";
		
	}
}
