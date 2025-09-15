package dk.bam.archunit_in_action.utils;

public class MapUser {
    public void map(final String name){
        assert name != null : "Name should not be null";
    }

    public void useDeprecated(final String name){
        deprecated(name);
    }

    @Deprecated
    public void deprecated(final String name){
        
    }
}
