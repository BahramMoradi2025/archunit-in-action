package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class PackageDependencyChecksTest {
    /**
     * Rules:
     *  1. controller classes should not access repository class
     *  2. controller classes should only use specific packages
     */
    @ArchTest
    static ArchRule controllerShouldDependOnRepository = noClasses()
            .that().resideInAPackage("..controller..")
            .should().dependOnClassesThat().resideInAPackage("..repository..");

    //or
    @ArchTest
    static  ArchRule controlerShouldOnlyDependOnSpecificPackege = classes().that()
            .resideInAPackage("..controller..")
            .should().onlyDependOnClassesThat().resideInAnyPackage("..service..","..utils..");


}
