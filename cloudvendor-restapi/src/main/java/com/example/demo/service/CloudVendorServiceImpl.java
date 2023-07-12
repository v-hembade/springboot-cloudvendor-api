package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CloudVendorNotFoundException;
import com.example.demo.model.CloudVendor;
import com.example.demo.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService
{

	@Autowired
	CloudVendorRepository cloudvendorrepository;

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) 
	{
		// TODO Auto-generated method stub
		cloudvendorrepository.save(cloudVendor);
		return "sucess";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) 
	{
		// TODO Auto-generated method stub
		cloudvendorrepository.save(cloudVendor);
        return "Success";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
		cloudvendorrepository.deleteById(cloudVendorId);
		return "sucess";
	}

	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
	    if(cloudvendorrepository.findById(cloudVendorId).isEmpty())
	         throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		return cloudvendorrepository.findById(cloudVendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() 
	{
		// TODO Auto-generated method stub
		return cloudvendorrepository.findAll();
	}

	public List<CloudVendor> getByVendorName(String vendorName) 
	{
		// TODO Auto-generated method stub
		return cloudvendorrepository.findByVendorName(vendorName);
	}

}
