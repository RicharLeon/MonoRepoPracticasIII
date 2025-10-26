package com.example.practicas.infrastructure.entrypoints.controllers.employeeassistance;

import com.example.practicas.domain.models.employeeassistance.gateway.IEmployeeAssistanceService;
import com.example.practicas.domain.models.employeeassistance.models.EmployeeAssistance;
import com.example.practicas.domain.models.groupmenu.gateway.IMenuGrupoService;
import com.example.practicas.infrastructure.entrypoints.dto.groupmenu.MenuConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/assistance")
public class EmployeeAssistanceControllers {

    @Autowired
    private IEmployeeAssistanceService employeeAssistanceService;

    @GetMapping("/{date}")
    public ResponseEntity<Integer> getPositionsInDateSpecific(@PathVariable("date")
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                         LocalDate date) {
        int available = employeeAssistanceService.availablePositions(date);
        return ResponseEntity.ok(available);
    }

    @PostMapping("")
    public ResponseEntity<EmployeeAssistance> createAssitance(@RequestBody EmployeeAssistance assitance) {
        var available = employeeAssistanceService.saveAsssistance(assitance);
        return ResponseEntity.ok(available);
    }

    @GetMapping("/foremployee/{employeeId}")
    public ResponseEntity<List<EmployeeAssistance>> getAllAssistances(@PathVariable Long employeeId) {
        List<EmployeeAssistance> assistances = employeeAssistanceService.employeeAssitanceAll(employeeId);
        return ResponseEntity.ok(assistances);
    }

}
