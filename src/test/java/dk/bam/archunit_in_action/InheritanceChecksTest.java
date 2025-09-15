package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import dk.bam.archunit_in_action.rule.Rule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class InheritanceChecksTest {
    @ArchTest
    static final ArchRule inheritanceChecksRule = classes()
            .that()
            .implement(Rule.class).should()
            .haveSimpleNameEndingWith("Rule");
}
