package greeting.impl;

/**
 * Created with IntelliJ IDEA.
 * User: bindiya.jinnappa
 * Date: 11/03/2014
 * Time: 08:57
 * To change this template use File | Settings | File Templates.
 */
import greeting.api.Greeting;

import org.apache.felix.scr.annotations.*;
import org.osgi.framework.Constants;

@Component(immediate=true)
@Service(Greeting.class)

@Properties({
        @Property(name = Constants.SERVICE_VENDOR, value = "Greeting Deamon"),
        @Property(name = Constants.SERVICE_RANKING, intValue = Integer.MAX_VALUE),
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "The first greeting implementation")
})

public class GreetingImpl implements Greeting {
    @Activate
    private void start() {

        System.out.println("Starting Greeting Service");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
