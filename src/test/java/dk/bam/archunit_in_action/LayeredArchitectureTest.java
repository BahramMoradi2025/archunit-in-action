package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import dk.bam.archunit_in_action.controller.UserController;
import dk.bam.archunit_in_action.utils.MapUser;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class LayeredArchitectureTest {

    @ArchTest
    static final ArchRule layerDependenciesRule = layeredArchitecture().consideringAllDependencies()
            .layer("Controllers").definedBy("dk.bam.archunit_in_action.controller..")
            .layer("Services").definedBy("dk.bam.archunit_in_action.service..")
            .layer("Persistence").definedBy("dk.bam.archunit_in_action.repository..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");

    @ArchTest
    static final ArchRule layerDependenciesRuleWithException = layeredArchitecture().consideringAllDependencies()
            .layer("Controllers").definedBy("dk.bam.archunit_in_action.controller..")
            .layer("Services").definedBy("dk.bam.archunit_in_action.service..")
            .layer("Persistence").definedBy("dk.bam.archunit_in_action.repository..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services")
            .ignoreDependency(MapUser.class, UserController.class);
}
