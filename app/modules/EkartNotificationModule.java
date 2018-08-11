package modules;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import play.Environment;

import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: Dheeraj Reddy
 * Date: 18/06/18
 */

public class EkartNotificationModule extends AbstractModule {

    private Config config;

    @Inject
    public EkartNotificationModule(Environment environment, Config config) {
        this.config = config;
    }

    @Override
    protected void configure() {

    }
}
