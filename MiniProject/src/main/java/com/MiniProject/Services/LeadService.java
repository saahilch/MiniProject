package com.MiniProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MiniProject.Entities.Lead;
import com.MiniProject.Repository.LeadRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;

	public Lead addLead(Lead lead) {
		lead.setCreated(java.time.LocalDateTime.now());
		return leadRepository.save(lead);
	}

	public List<Lead> getAllLeads() {
		return leadRepository.findAll();
	}

	public List<Lead> searchLeads(String assignedTo, String tag, String status) {
		if (assignedTo != null) {
			return leadRepository.findByAssignedTo(assignedTo);
		} else if (tag != null) {
			return leadRepository.findByTag(tag);
		} else if (status != null) {
			return leadRepository.findByStatus(status);
		}
		return leadRepository.findAll();
	}

	public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }
}
