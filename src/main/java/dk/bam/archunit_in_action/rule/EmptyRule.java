package dk.bam.archunit_in_action.rule;

import org.springframework.util.StringUtils;

public class EmptyRule implements Rule {
    @Override
    public boolean check(String data) {
        return StringUtils.hasText(data);
    }
}
