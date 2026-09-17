package com.sap.fhir.patient_api;

import java.util.List;

public record Patient(
        String resourceType,
        String id,
        List<HumanName> name,
        String birthDate,
        String gender
) {
    public record HumanName(String family, List<String> given) {}

    public static Patient withId(Patient p, String id) {
        return new Patient("Patient", id, p.name(), p.birthDate(), p.gender());
    }
}
