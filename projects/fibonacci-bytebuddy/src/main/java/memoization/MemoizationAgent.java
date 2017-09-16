package memoization;

import net.bytebuddy.agent.builder.AgentBuilder;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.implementation.MethodDelegation.to;
import static net.bytebuddy.matcher.ElementMatchers.any;
import static net.bytebuddy.matcher.ElementMatchers.named;


public class MemoizationAgent {

    public static void premain(String arguments, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(any())
                .transform(
                        (builder, typeDescription, classLoader, javaModule) ->
                                builder.method(named("compute"))
                                        .intercept(to(Memoization.class))
                ).installOn(instrumentation);
    }

}

