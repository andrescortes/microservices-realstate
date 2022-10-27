package com.dev.springbootmicroservice1realstate.service;

import com.dev.springbootmicroservice1realstate.model.RealState;
import java.util.List;

public interface RealStateService {

    RealState saveRealState(RealState realState);

    void deleteRealState(Long realStateId);

    List<RealState> findAllRealStates();
}
