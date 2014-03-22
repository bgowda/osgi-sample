package sample.consumer;

import greeting.api.Greeting;
import org.apache.felix.ipojo.annotations.*;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.scr.annotations.*;
import org.osgi.framework.Constants;

import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: bindiya.jinnappa
 * Date: 11/03/2014
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */

@org.apache.felix.scr.annotations.Component(immediate = true)

@Properties({
        @org.apache.felix.scr.annotations.Property(name = Constants.SERVICE_VENDOR, value = "Nine Demons"),
        @org.apache.felix.scr.annotations.Property(name = Constants.SERVICE_DESCRIPTION, value = "A simple consumer of another service")
})
public class GreetingConsumer extends TimerTask {

    private static final Logger LOG = Logger.getLogger(GreetingConsumer.class.getName());

    @Reference
    protected Greeting greeting;

    @Bind
    protected void bindGreeting(Greeting greeting){
        LOG.info("LOG::::Congratulations!! Your first osgi bundle commucated to consumer.");
       this.greeting = greeting;
       this.greeting.sayHello("Congratulations!! Your first osgi bundle commucated to consumer.");
    }


    @Unbind
    protected void unbindGreeting(Greeting greeting){
        LOG.info("LOG::::GoodBye consumer.");
       this.greeting = null;
    }

    @Override
    public void run() {
        System.out.println("Sample greeting consumer is running");
    }
}
