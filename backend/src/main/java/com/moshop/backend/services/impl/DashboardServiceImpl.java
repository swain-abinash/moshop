package com.moshop.backend.services.impl;

import com.moshop.backend.model.entity.Dashboard;
import com.moshop.backend.repository.*;
import com.moshop.backend.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    @Override
    public Dashboard countAll() {
        return new Dashboard();
    }
}
