package com.inaya.stockmanagement.controller;

import com.inaya.stockmanagement.dto.DepotDTO;
import com.inaya.stockmanagement.manager.DepotManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/depots")
public class DepotController {

    private final DepotManager depotManager;

    public DepotController(DepotManager depotManager) {
        this.depotManager = depotManager;
    }

    @GetMapping
    public List<DepotDTO> getAllDepot() {
        return depotManager.getAllDepot();
    }

    @GetMapping(value = "/depot/{id}")
    public DepotDTO getDepotById(@PathVariable Long id) {
        return depotManager.getDepotById(id);
    }

    @PostMapping(value = "/depot")
    public ResponseEntity<DepotDTO> addDepot(@RequestBody DepotDTO depotDTO) {
        return depotManager.saveDepot(depotDTO);
    }

    @PutMapping(value = "/depot")
    public DepotDTO updateDepot(@RequestBody DepotDTO depotDTO) {
        return depotManager.updateDepot(depotDTO);
    }
    @DeleteMapping(value = "/depot/{id}")
    public String deleteDepot(@PathVariable Long id){
        return depotManager.deleteDepot(id);
    }
}
