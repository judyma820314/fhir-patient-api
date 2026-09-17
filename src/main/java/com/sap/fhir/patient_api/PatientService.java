the package com.sap.fhir.patient_api;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PatientService {

    private final Map<String, Patient> store = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Patient save(Patient patient) {
        String id = String.valueOf(idCounter.getAndIncrement());
        Patient saved = Patient.withId(patient, id);
        store.put(id, saved);
        return saved;
    }

    public Optional<Patient> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }
}
