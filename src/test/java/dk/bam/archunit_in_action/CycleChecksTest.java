package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class CycleChecksTest {
    @ArchTest
    ArchRule noCycle = slices().matching("dk.bam.archunit_in_action.(*)..").should().beFreeOfCycles();
}
