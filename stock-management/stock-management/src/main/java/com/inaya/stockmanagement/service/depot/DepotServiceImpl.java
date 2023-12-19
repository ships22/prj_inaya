package com.inaya.stockmanagement.service.depot;

import com.inaya.stockmanagement.model.Depot;
import com.inaya.stockmanagement.repository.DepotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepotServiceImpl implements DepotService{

    private final DepotRepository depotRepository;

    public DepotServiceImpl(DepotRepository depotRepository) {
        this.depotRepository = depotRepository;
    }


    /**
     * @param depot
     * @return
     */
    @Override
    public Depot add(Depot depot) {
        return depotRepository.save(depot);
    }

    /**
     * @param depot
     * @return
     */
    @Override
    public Depot update(Depot depot) {
        return depotRepository.saveAndFlush(depot);
    }

    /**
     * @return
     */
    @Override
    public List<Depot> getAll() {
        return depotRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Depot> findById(Long id) {
        return depotRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        depotRepository.deleteById(id);
    }
}
