package spr.jfsd_sdp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spr.jfsd_sdp.Model.Scholarship;
import spr.jfsd_sdp.Model.FinancialAid;
import spr.jfsd_sdp.Model.ScholarshipApplications;
import spr.jfsd_sdp.Model.FinancialAidApplications;
import spr.jfsd_sdp.Service.ScholarshipService;
import spr.jfsd_sdp.Service.FinancialAidService;
import spr.jfsd_sdp.Service.ScholarshipApplicationsService;
import spr.jfsd_sdp.Service.FinancialAidApplicationService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ScholarshipService scholarshipService;

    @Autowired
    private FinancialAidService financialAidService;

    @Autowired
    private ScholarshipApplicationsService scholarshipApplicationsService;

    @Autowired
    private FinancialAidApplicationService financialAidApplicationsService;

    // CRUD operations for scholarships
    @PostMapping("/scholarships")
    public ResponseEntity<Scholarship> createScholarship(@RequestBody Scholarship scholarship) {
        return new ResponseEntity<>(scholarshipService.createScholarship(scholarship), HttpStatus.CREATED);
    }

    @GetMapping("/scholarships")
    public List<Scholarship> getAllScholarships() {
        return scholarshipService.getAllScholarships();
    }

    @PutMapping("/scholarships/{id}")
    public ResponseEntity<Scholarship> updateScholarship(@PathVariable Long id, @RequestBody Scholarship scholarship) {
        return new ResponseEntity<>(scholarshipService.updateScholarship(id, scholarship), HttpStatus.OK);
    }

    @DeleteMapping("/scholarships/{id}")
    public ResponseEntity<Void> deleteScholarship(@PathVariable Long id) {
        scholarshipService.deleteScholarship(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // CRUD operations for financial aid
    @PostMapping("/financial-aid")
    public ResponseEntity<FinancialAid> createFinancialAid(@RequestBody FinancialAid financialAid) {
        return new ResponseEntity<>(financialAidService.createFinancialAid(financialAid), HttpStatus.CREATED);
    }

    @GetMapping("/financial-aid")
    public List<FinancialAid> getAllFinancialAid() {
        return financialAidService.getAllFinancialAid();
    }

    @PutMapping("/financial-aid/{id}")
    public ResponseEntity<FinancialAid> updateFinancialAid(@PathVariable Long id, @RequestBody FinancialAid financialAid) {
        return new ResponseEntity<>(financialAidService.updateFinancialAid(id, financialAid), HttpStatus.OK);
    }

    @DeleteMapping("/financial-aid/{id}")
    public ResponseEntity<Void> deleteFinancialAid(@PathVariable Long id) {
        financialAidService.deleteFinancialAid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Scholarship applications management
    @GetMapping("/applications/scholarship")
    public List<ScholarshipApplications> getAllScholarshipApplications() {
        return scholarshipApplicationsService.getAllApplications();
    }

    @PutMapping("/applications/scholarship/{applicationId}")
    public ResponseEntity<ScholarshipApplications> updateScholarshipApplication(@PathVariable Long applicationId, @RequestBody ScholarshipApplications application) {
        ScholarshipApplications updatedApplication = scholarshipApplicationsService.updateApplication(applicationId, application);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    // Financial aid applications management
    @GetMapping("/applications/financial-aid")
    public List<FinancialAidApplications> getAllFinancialAidApplications() {
        return financialAidApplicationsService.getAllApplications();
    }

    @PutMapping("/applications/financial-aid/{applicationId}")
    public ResponseEntity<FinancialAidApplications> updateFinancialAidApplication(@PathVariable Long applicationId, @RequestBody FinancialAidApplications application) {
        FinancialAidApplications updatedApplication = financialAidApplicationsService.updateApplication(applicationId, application);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }
}
