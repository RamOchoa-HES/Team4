package com.lib.stats.helper.LibStatsHelper.service;

import com.lib.stats.helper.LibStatsHelper.entity.AccessService;
import com.lib.stats.helper.LibStatsHelper.repository.AccessServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceService {
    @Autowired
    private AccessServiceRepository repository;

    public AccessService saveAccessService(AccessService accessservice) {
        return repository.save(accessservice);
    }
    public List<AccessService> saveAccessServices(List<AccessService> accessservices) {
        return repository.save(accessservices);
    }
    public List<AccessService> getAccessServices(){
        return repository.findAll();
    }
    public AccessService getAccessServiceById(int id){
        return repository.findById(id).orElse(null);
    }
    public AccessService getAccessServiceBySemester(String semester){
        return repository.findBySemester(semester);
    }
    public String deleteAccessService(int id){
        repository.deleteById(id);
        return "Access Service Entry has been removed - entry id:"+id;
    }

    public AccessService updateAccessService(AccessService accessservice){
        AccessService existingAccessService=repository.findById(accessservice.getId()).orElse(null);
        existingAccessService.setSemester(accessservice.getSemester());
        existingAccessService.setYear(accessservice.getYear());
        existingAccessService.setphysicalItem(accessservice.getphysicalItem());
        return repository.save(existingAccessService);
    }
}