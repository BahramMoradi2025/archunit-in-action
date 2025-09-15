package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class CustomCondtions {

        static ArchCondition<JavaClass> methodnameMustBeMoreThanThreeCharacter = new ArchCondition<JavaClass>("Method name should be more than to character") {
        @Override
        public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
            Set<JavaMethod> violations = javaClass.getAllMethods().stream().filter(m -> m.getName().length() < 4).collect(Collectors.toSet());
            boolean satisfied = violations.isEmpty();
            String methods = String.join(", ", violations.stream().map(JavaMethod::getName).toList());
            conditionEvents.add(new SimpleConditionEvent(javaClass, satisfied, javaClass.getSimpleName()
                    + "Has methods with name less than four character " + methods));
        }
    };

   /* @ArchTest
    static ArchRule methodNameMustBeMoreThanFourCharacter = classes()
            .that().haveSimpleNameEndingWith("Service")
            .should(methodNameCondition);*/

    @ArchTest
    static ArchRule methodNameLengthRule = classes().should(methodnameMustBeMoreThanThreeCharacter);

}
