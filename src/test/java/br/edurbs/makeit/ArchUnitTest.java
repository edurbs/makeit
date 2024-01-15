package br.edurbs.makeit;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import java.util.Set;
import org.junit.jupiter.api.Test;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

class ArchUnitTest {

    @Test
    void some_architecture_rule() {
        String javaPackages[] = {"java..", "jakarta.validation..", "jakarta.annotation..", "lombok.."};

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOptions(Set.of(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS, ImportOption.Predefined.DO_NOT_INCLUDE_PACKAGE_INFOS))
            .importPackages("br.edurbs.makeit");

        layeredArchitecture().consideringAllDependencies()
				.optionalLayer("Java").definedBy(javaPackages)
                .layer("Infra").definedBy("..infra..")
                // .layer("Presentation").definedBy("..presentation..")
                //.layer("Application").definedBy("..application..")
				.layer("Domain").definedBy("..domain..")

                .whereLayer("Infra").mayNotBeAccessedByAnyLayer()
                //.whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
				//.whereLayer("Application").mayOnlyAccessLayers("Java", "Domain")
				.whereLayer("Domain").mayOnlyAccessLayers("Java")

                .check(importedClasses);
    }
}
