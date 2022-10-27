package com.dev.springbootmicroservice1realstate.service;

import com.dev.springbootmicroservice1realstate.model.RealState;
import com.dev.springbootmicroservice1realstate.repository.RealStateRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RealStateServiceImpl implements RealStateService {

    private final RealStateRepository stateRepository;

    public RealStateServiceImpl(RealStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public RealState saveRealState(RealState realState) {
        realState.setCreateDate(LocalDateTime.now());
        return stateRepository.save(realState);
    }

    @Override
    public void deleteRealState(Long realStateId) {
        stateRepository.deleteById(realStateId);
    }

    @Override
    public List<RealState> findAllRealStates() {
        return stateRepository.findAll();
    }
}
