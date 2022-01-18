package me.lm.framework.normal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Noninstantiable class for service registration and access
public class Services {

    private Services() {
    }

    //Map service names to service's provider
    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "def";

    // Provider Registration API
    public static void registerDefaultProvider(Provider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME,provider);
    }

    public static void registerProvider(String name, Provider provider) {
        providers.put(name, provider);
    }

    //Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider provider = providers.get(name);
        if (provider == null){
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return provider.newService();
    }
}
