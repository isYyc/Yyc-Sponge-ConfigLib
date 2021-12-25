package org.yyc.yycspongeconfiglib.Assets;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;
import org.spongepowered.plugin.PluginContainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class YamlAssetsManager {

    private final PluginContainer pluginContainer;

    public YamlAssetsManager(PluginContainer pluginContainer) {
        this.pluginContainer = pluginContainer;
    }

    /**
     *
     * @param fileName 文件名
     * @return 对应的 {@link Asset}
     *
     * 如果没找到返回 Null
     */
    public Asset getAsset(String fileName){
        Optional<Asset> optional = Sponge.assetManager().asset(pluginContainer, fileName);
        return optional.orElse(null);
    }

    public void createLocalFile(Asset asset) {
        Path path = Sponge.configManager().pluginConfig(pluginContainer).configPath();
        if (Files.notExists(path)) {
            try {
                if(asset != null){
                    asset.copyToDirectory(path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param fileName 文件名
     * @return 对应本地配置文件的 {@link ConfigurationNode}
     *
     * 如果没找到返回 Null
     */
    public ConfigurationNode loadNode(String fileName){
        File file = new File(Sponge.configManager().pluginConfig(pluginContainer).configPath() + "/" +fileName);
        ConfigurationNode node = null;
        try {
            node = YamlConfigurationLoader.builder().file(file).build().load();
        } catch (ConfigurateException e) {
            e.printStackTrace();
        }
        return node;
    }
}
