package com.moshop.backend.controller;

import com.moshop.backend.model.entity.Dashboard;
import com.moshop.backend.services.impl.DashboardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardServiceImpl dashboardServiceImpl;

    @GetMapping
    public ResponseEntity<Dashboard> countAll() {
        var dashboard = dashboardServiceImpl.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(dashboard);
    }
}
