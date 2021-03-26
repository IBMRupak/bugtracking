package com.ibm.bts;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.bts.entity.Bug;
import com.ibm.bts.service.BugService;

@RestController
public class BugController {
	@Autowired
BugService bugService;
	
	@PostMapping("/bug")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createBug(@RequestBody @Valid Bug bug, BindingResult bindingResult) {
		
		validateModel(bindingResult);
		System.out.println(bug);
		return bugService.createBug(bug);
		
	}
	
	@GetMapping("/bug")
	List<Bug> getBugs()
	{
		return bugService.getBugs();
	}
   /**
    * method to search for a bug
    * @param bugId
    * @return
    */
	
	@GetMapping("/bug/{id}")
	Optional <Bug> getBug (@PathVariable("id")String bugId){
		
		return bugService.getBug(bugId);
	}
	
	
	
	private void validateModel(Errors bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			throw new IllegalArgumentException("Something is wrong.please retry");
		}
	}
	
	@PutMapping("/bug/{id}")
	void updateOrder(@RequestBody @Valid Bug bug, BindingResult bindingResult,@PathVariable ("id") String bugId)
	{
		validateModel(bindingResult);
		System.out.println(bugId);
		bug.setId(bugId);
		bugService.updateBug(bug);
	}
	
	@DeleteMapping("/bug/{id}")
	void deleteOrder(@PathVariable("id") String bugId, HttpRequest httpRequest) {
		System.out.println(httpRequest.getHeaders());
		System.out.println(bugId);
		bugService.deleteBug(bugId);
		
	}
	
	
	
	
	
}
