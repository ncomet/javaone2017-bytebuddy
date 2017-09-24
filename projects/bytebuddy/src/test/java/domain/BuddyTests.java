package domain;

import frameworks.mock.Cosmockpolitan;
import interceptors.GetterSetterInterceptor;
import net.bytebuddy.ByteBuddy;
import org.testng.annotations.Test;

import java.lang.reflect.Modifier;

import static net.bytebuddy.implementation.FixedValue.value;
import static net.bytebuddy.implementation.MethodDelegation.to;
import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BuddyTests {

    @Test
    public void buddyIntro() throws Exception {
        Cat cat = new ByteBuddy()
                .subclass(Cat.class)
                /*.method(named("getStomach"))
                .intercept(to(StrangeFeelingInterceptor.class))*/
                .make()
                .load(getClass().getClassLoader())
                .getLoaded().newInstance();

        cat.setName("Garfield");
        cat.feed("lasagna");
        cat.feed("moar lasagna");

        assertThat(cat.getStomach()).containsOnly("lasagna", "moar lasagna");
        assertThat(cat.getName()).isEqualTo("Garfield");
    }

    @Test
    public void interceptors() throws Exception {

        Cat cat = new ByteBuddy()
                .subclass(Cat.class)
                .method(isGetter().or(isSetter()))
                .intercept(to(GetterSetterInterceptor.class))
                .make().load(getClass().getClassLoader())
                .getLoaded().newInstance();

        cat.setName("Felix");

        assertThat(cat.getName()).isEqualTo("Felix");

    }

    @Test
    public void cosmockpolitan() throws Exception {
        Cat mock = Cosmockpolitan.mock(Cat.class);

        mock.setName("Felix");

        assertThat(mock.getName()).isNull();
    }

    @Test
    public void shouldCreateAnActress() throws Exception {

        Actor actor = new ByteBuddy()
                .subclass(Actor.class)
                .name("domain.FemaleActress")
                .method(named("characterName")).intercept(value("Daenerys Targaryen"))
                .method(named("firstName")).intercept(value("Emilia"))
                .method(named("lastName")).intercept(value("Clarke"))
                .defineField("favoriteActor", Actor.class, Modifier.PUBLIC)
                .make().load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();

        System.out.println(actor.getClass().getSimpleName());

    }

}
