package com.ponser2000.appserver.service;

import com.ponser2000.appserver.model.Contract;
import com.ponser2000.appserver.repository.ContractRepository;
import com.ponser2000.appserver.to.ContractTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractDatabaseSearchImpl implements ContractDatabaseSearch {

    private final ContractRepository contractRepository;

    @Override
    public List<ContractTo> getAll() {
        Iterable<Contract> contracts = contractRepository.findAll();
        List<ContractTo> result = new ArrayList<>();
        for (Contract contract : contracts) {
            boolean actual = LocalDateTime.now().minusDays(60).compareTo(contract.getDateUpdate()) < 0;
            result.add(new ContractTo(contract.getDateCreate(), contract.getRevision(), contract.getDateUpdate(), actual));
        }
        return result;
    }
}
