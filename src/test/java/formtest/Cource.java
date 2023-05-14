package formtest;

public enum Cource {
    FRONT_END_BASIC("Front-end Basic"),
    FRONT_END_PRO("Front-end Pro"),
    REACT("React"),
    JAVA_BASIC("Java Basic"),
    QA_MANUAL("QA Manual"),
    QA_AUTOMATION_JAVA("QA Automation - Java"),
    QA_AUTOMATION_PYTHON("QA Automation - Python");
    private final String name;

    Cource(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
