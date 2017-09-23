package frameworks.mock.core;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.isEquals;
import static net.bytebuddy.matcher.ElementMatchers.isNative;
import static net.bytebuddy.matcher.ElementMatchers.not;
import static net.bytebuddy.matcher.ElementMatchers.returns;

public class Cosmo {


    public <T> T mock(Class<T> typeToMock) {
        try {
            return new ByteBuddy()
                    .subclass(typeToMock)
                    .method(not(isNative().or(isEquals()).or(returns(TypeDescription.VOID))))
                    .intercept(FixedValue.nullValue())
                    .make()
                    .load(typeToMock.getClassLoader())
                    .getLoaded()
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
