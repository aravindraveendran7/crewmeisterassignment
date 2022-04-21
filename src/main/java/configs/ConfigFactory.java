package configs;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

    private ConfigFactory(){}
    public static FrameworkConfigs getConfig(){
        return ConfigCache.getOrCreate(FrameworkConfigs.class);
    }

}
