package com.MiniProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Entities.Lead;
import com.MiniProject.Services.LeadService;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

	@Autowired
	private LeadService leadService;

	@PostMapping
	public Lead addLead(@RequestBody Lead lead) {
		return leadService.addLead(lead);
	}

	@GetMapping
	public List<Lead> getAllLeads() {
		return leadService.getAllLeads();
	}

	@GetMapping("/search")
	public List<Lead> searchLeads(@RequestParam(required = false) String assignedTo,
			@RequestParam(required = false) String tag, @RequestParam(required = false) String status) {
		return leadService.searchLeads(assignedTo, tag, status);
	}

	@GetMapping("/{id}")
	public Lead getLeadById(@PathVariable Long id) {
		return leadService.getLeadById(id);
	}
}
