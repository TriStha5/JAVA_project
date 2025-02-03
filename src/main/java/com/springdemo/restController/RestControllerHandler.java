package com.springdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.model.Admin;
import com.springdemo.model.Location;
import com.springdemo.repository.LocationRepository;

@RestController
public class RestControllerHandler {

	@Autowired
	private LocationRepository lRepo;

	/*
	 * @GetMapping("/home1") public String staffTable(@ModelAttribute Location l,
	 * Model model) {
	 * 
	 * List<Location> locationList = lRepo.findAll(); model.addAttribute("aList",
	 * locationList); return "home.html"; }
	 */

	/*
	 * @GetMapping("/search/{address}") public String
	 * getSearchByAddress(@PathVariable String address, Model model){
	 * 
	 * Location list = (Location) lRepo.getByAddress(address);
	 * model.addAttribute("aList", list); Location uList =
	 * lRepo.findByAddress(address).get();
	 * 
	 * return "search.html"; }
	 */

	/*
	 * @PostMapping("/api/postBook") public String postBook(@RequestBody Book b) {
	 * bRepo.save(b); return "Saved Sucessfully"; }
	 */
	/*
	 * @PutMapping("/api/updateBook") public String updateBook(@RequestBody Book b)
	 * { bRepo.save(b); return "Sucessfully Updated"; }
	 */

	/*
	 * @DeleteMapping("/api/deleteBook/{id}") public String deleteBook(@PathVariable
	 * int id) { bRepo.deleteById(id); return "Sucessfully Deleted"; }
	 */

}
