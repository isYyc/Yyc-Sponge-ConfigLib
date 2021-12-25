package org.yyc.yycspongeconfiglib.Config;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigRoot;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.plugin.PluginContainer;

@SuppressWarnings("unused")
public class YamlConfigManager {

    private final PluginContainer pluginContainer;

    private final ConfigRoot configRoot;

    public YamlConfigManager(PluginContainer pluginContainer) {
        this.pluginContainer = pluginContainer;
        configRoot = Sponge.configManager().pluginConfig(pluginContainer);
    }

    public void save(ConfigurationNode configurationNode){
        try {
            configRoot.config(configurationNode.options()).save(configurationNode);
        } catch (ConfigurateException e) {
            e.printStackTrace();
        }
    }

    public void delete(ConfigurationNode configurationNode){
    }
}
