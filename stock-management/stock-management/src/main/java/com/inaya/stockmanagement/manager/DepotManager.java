package com.inaya.stockmanagement.manager;

import com.inaya.stockmanagement.dto.CategoryDTO;
import com.inaya.stockmanagement.dto.DepotDTO;
import com.inaya.stockmanagement.model.Category;
import com.inaya.stockmanagement.model.Depot;
import com.inaya.stockmanagement.service.depot.DepotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DepotManager {

    private final DepotService depotService;


    public DepotManager(DepotService depotService) {
        this.depotService = depotService;
    }

    public ResponseEntity<DepotDTO> saveDepot(DepotDTO depotDTO) {
        Depot depot = new Depot();
        depot.setName(depotDTO.getName());
        depot.setAddress(depotDTO.getAddress());
        depot.setEmail(depotDTO.getEmail());
        depot.setPhone(depotDTO.getPhone());
        DepotDTO addedDepot = modelToDto(depotService.add(depot));
        return new ResponseEntity<>(addedDepot, HttpStatus.CREATED);
    }

    public DepotDTO updateDepot(DepotDTO depotDTO) {
        Depot depot = new Depot();
        depot.setId(depotDTO.getId());
        depot.setName(depotDTO.getName());
        depot.setPhone(depotDTO.getPhone());
        depot.setEmail(depotDTO.getEmail());
        return modelToDto(depotService.update(depot));
    }

    public DepotDTO getDepotById(Long id) {
        Optional<Depot> depot = depotService.findById(id);
        return depot.map(this::modelToDto).orElseGet(null);
    }

    public List<DepotDTO> getAllDepot() {
        List<Depot> depotList = depotService.getAll();
        List<DepotDTO> depotDTOList = new ArrayList<>();
        depotList.forEach(data -> depotDTOList.add(modelToDto(data)));
        return depotDTOList;
    }

    public String deleteDepot(Long id) {
        try {
            depotService.delete(id);
            return "Depot with " + id + " has been deleted";
        } catch (Exception e) {
            return "Depot with " + id + " not found";
        }
    }

    private DepotDTO modelToDto(Depot depot) {
        DepotDTO depotDTO = new DepotDTO();
        depotDTO.setId(depot.getId());
        depotDTO.setName(depot.getName());
        depotDTO.setAddress(depot.getAddress());
        depotDTO.setEmail(depot.getEmail());
        depotDTO.setPhone(depot.getPhone());
        depotDTO.setStock(depot.getStocks());
        return depotDTO;
    }

    private DepotDTO modelToDtoWithProduct(Depot depot) {
        DepotDTO depotDTO = new DepotDTO();
        depotDTO.setId(depot.getId());
        depotDTO.setName(depot.getName());
        depotDTO.setAddress(depot.getAddress());
        depotDTO.setEmail(depot.getEmail());
        depotDTO.setPhone(depot.getPhone());
        //depotDTO.setProductList(depot.getProductList());
        //depotDTO.setStock(depot.getStock());
        return depotDTO;
    }


}
