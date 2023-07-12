package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CloudVendor;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController 
{
	    @Autowired
	    CloudVendorService cloudvendorservice;

	    // Read Specific Cloud Vendor Details from DB
	    @GetMapping("/{vendorId}")
	    public  ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
	    {		 
	    	return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
	                HttpStatus.OK, cloudvendorservice.getCloudVendor(vendorId));
	    }

	    // Read All Cloud Vendor Details from DB
	    @GetMapping("/")
	    public List<CloudVendor> getAllCloudVendorDetails()
	    {
	        return cloudvendorservice.getAllCloudVendors();
	    }

	    @PostMapping("/")
	    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	    {
	        cloudvendorservice.createCloudVendor(cloudVendor);
	        return "Cloud Vendor Created Successfully";
	    }

	    @PutMapping("/")
	    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	    {
	        cloudvendorservice.updateCloudVendor(cloudVendor);
	        return "Cloud Vendor Updated Successfully";
	    }

	    @DeleteMapping("/{vendorId}")
	    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
	    {
	        cloudvendorservice.deleteCloudVendor(vendorId);
	        return "Cloud Vendor Deleted Successfully";
	    }
}
