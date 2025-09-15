package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import dk.bam.archunit_in_action.controller.UserController;
import dk.bam.archunit_in_action.service.UserService;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class ClassDependencyChecksTest {
    /**
     * Rules:
     * 1. user controller should only depend on user service
     *
     */
    @ArchTest
    static ArchRule controllerShouldDependOnRepository = classes()
            .that()
            .haveSimpleNameEndingWith(UserController.class.getSimpleName())
            .should()
            .onlyDependOnClassesThat()
            .haveSimpleNameEndingWith(UserService.class.getSimpleName());
}

