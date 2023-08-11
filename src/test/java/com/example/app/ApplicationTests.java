package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ApplicationTests {

    @Test
    void writeDocumentationSnippets() {

        var modules = ApplicationModules.of(Application.class).verify();
        modules.forEach(System.out::println);

        new Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
    }
}
