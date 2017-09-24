package domain;

import static net.bytebuddy.implementation.FixedValue.value;
import static net.bytebuddy.implementation.MethodDelegation.to;
import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import interceptors.StrangeFeelingInterceptor;
import net.bytebuddy.ByteBuddy;

import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import frameworks.mock.Cosmockpolitan;
import interceptors.GetterSetterInterceptor;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Date;

public class BuddyTests {



}
