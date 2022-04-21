package configs;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfigs extends Config {
    String timeout();
    String url();
    String browser();

}
