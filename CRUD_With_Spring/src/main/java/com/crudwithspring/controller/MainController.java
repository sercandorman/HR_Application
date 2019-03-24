package com.crudwithspring.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.crudwithspring.model.Jobs;
import com.crudwithspring.model.Lists;
import com.crudwithspring.repository.ListRepository;
import com.crudwithspring.service.ApplicationService;
import com.crudwithspring.service.JobsService;
import com.crudwithspring.service.ListsService;

@RestController
public class MainController {

	ModelAndView mavIndex = new ModelAndView("login"); // Goruntulenecek sayfanin adi (view page name)
	ModelAndView mavHomepage = new ModelAndView("homepage"); // Goruntulenecek sayfanin adi (view page name)

	@Autowired
	private ListsService listsService;

	@Autowired
	private JobsService jobsService;

	@Autowired
	private ListRepository listRepository;

	@Autowired
	private ApplicationService applicationService;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		return mavIndex;
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView findAllLists() {
		mavHomepage.addObject("allLists", listsService.findAllLists());
		mavHomepage.addObject("mod", "VIEW_LISTS");
		return mavHomepage;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		mavIndex.addObject("mod", "HIDE_RECORDS");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String findAllApplications() {
		return "COMING SOON";
		/*
		ResponseEntity<byte[]> findAllApplications()
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		String filename = "applications-Resume.bin";

		headers.add("content-disposition", "attachment;filename=" + filename);

		headers.setContentDispositionFormData(filename, filename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(headers, HttpStatus.OK);

		mavHomepage.addObject("allApplications", applicationService.findAllJobs());
		mavHomepage.addObject("mod", "VIEW_APPLICATIONS");
		return response;*/
		
	}

	@PostMapping(value = "createList")
	public void createList(@RequestBody Lists list, HttpServletResponse hsr) throws IOException {
		listsService.save(list);
		mavHomepage.addObject("allLists", listsService.findAllLists());
	}

	@RequestMapping(value = "/oneList", method = RequestMethod.GET)
	public ModelAndView oneList(@RequestParam(value = "id", required = true) Long id, HttpServletResponse hsr)
			throws IOException {
		mavHomepage.addObject("oneJobList", jobsService.findAllJobsById(id));
		mavHomepage.addObject("findOneList", listsService.findOne(id));
		mavHomepage.addObject("mod", "VIEW_ONELIST");
		return mavHomepage;
	}

	@RequestMapping(value = "/editList", method = RequestMethod.GET)
	public ModelAndView editList(@RequestParam long id, HttpServletResponse hsr) throws IOException {
		mavHomepage.addObject("getOneList", listsService.findOne(id));
		mavHomepage.addObject("mod", "EDIT_LIST");
		return mavHomepage;
	}

	@RequestMapping(value = "/updateList")
	public @ResponseBody ModelAndView updateList(@RequestParam(value = "id", required = true) long listID,
			@RequestParam String listname) {
		Lists listttt = listRepository.findOne(listID);
		listttt.setListName(listname);
		listsService.save(listttt);
		mavHomepage.addObject("allLists", listsService.findAllLists());
		mavHomepage.addObject("mod", "VIEW_LISTS");
		return mavHomepage;
	}

	@RequestMapping("/deleteList")
	public void deleteList(@RequestParam long id, HttpServletResponse hsr) throws IOException {
		listsService.delete(id);
		mavHomepage.addObject("allLists", listsService.findAllLists());
		hsr.sendRedirect("/homepage");
	}
	
	@RequestMapping(value = "/detailList", method = RequestMethod.GET)
	public void detailList(@RequestParam(value = "listid", required = true) Long id, HttpServletResponse hsr) throws IOException {
		mavHomepage.addObject("modd", "VIEW_DETAIL");
		mavHomepage.addObject("oneJobList2", jobsService.findAllJobsById(id));
		hsr.sendRedirect("/homepage");
	}

	@RequestMapping(value = "/createJob", method = RequestMethod.POST)
	@ResponseBody
	public String createJob(@RequestBody Jobs jobs, @RequestParam(value = "listid", required = true) Long listid,
			HttpServletResponse hsr) throws IOException {
		return "COMING SOON";
/*
		Lists listttt = listsService.findOne(listid);
		jobs.setLists(listttt);
		jobsService.save(jobs);

		// mavHomepage.addObject("oneJobList", jobsService.findAllJobsById(listid));
		// mavHomepage.addObject("findOneList", listsService.findOne(listid));
		mavHomepage.addObject("mod", "VIEW_ONELIST");
		// hsr.sendRedirect("/oneList?id=" + listid);
		hsr.sendRedirect("/homepage");*/
		
	}

	@RequestMapping("/deleteJob/{jobID}/{listID}")
	public void deleteJob(@PathVariable("jobID") long jobID, @PathVariable("listID") long listID,
			HttpServletResponse hsr) throws IOException {
		jobsService.delete(jobID);
		// mavHomepage.addObject("mod", "VIEW_ONELIST");
		hsr.sendRedirect("/oneList?id=" + listID);
	}
}
