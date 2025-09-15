package dk.bam.archunit_in_action;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;


import static com.tngtech.archunit.library.GeneralCodingRules.ASSERTIONS_SHOULD_HAVE_DETAIL_MESSAGE;
import static com.tngtech.archunit.library.GeneralCodingRules.DEPRECATED_API_SHOULD_NOT_BE_USED;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;
import static com.tngtech.archunit.library.GeneralCodingRules.OLD_DATE_AND_TIME_CLASSES_SHOULD_NOT_BE_USED;

@AnalyzeClasses(packages = "dk.bam.archunit_in_action", importOptions = ImportOption.DoNotIncludeTests.class)
public class CleanCodeTest {

    /*  @ArchTest
  private void no_access_to_standard_streams_as_method(JavaClasses classes) {
      noClasses().should(ACCESS_STANDARD_STREAMS).check(classes);
  }*/

    @ArchTest
    private final ArchRule noAccessToStandardStreams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
    @ArchTest
    ArchRule throwOfGenericExceptionIsForbidden = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
    @ArchTest
    ArchRule usingJavaUtilLoggingIsForbidden = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
    @ArchTest
    ArchRule usingJodaTimeIsForbidden = NO_CLASSES_SHOULD_USE_JODATIME;
    @ArchTest
    ArchRule filedInjectionIsForbidden = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
    @ArchTest
    ArchRule assertionDetailMessageIsRequired = ASSERTIONS_SHOULD_HAVE_DETAIL_MESSAGE;
    @ArchTest
    ArchRule usingDeprecatedApiIsForbidden = DEPRECATED_API_SHOULD_NOT_BE_USED;
    @ArchTest
    ArchRule usingOldDateTimeIsForbidden = OLD_DATE_AND_TIME_CLASSES_SHOULD_NOT_BE_USED;


}
