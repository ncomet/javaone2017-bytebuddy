package frameworks.mock;

import frameworks.mock.core.Cosmo;

/**
 * LECTRA
 * Cosmockpolitan class
 * @author n.comet
 */
public class Cosmockpolitan {

    static final Cosmo COSMO_CORE = new Cosmo();

    private Cosmockpolitan() {
    }

    public static <T> T mock(Class<T> classToMock) {
        return COSMO_CORE.mock(classToMock);
    }

}
