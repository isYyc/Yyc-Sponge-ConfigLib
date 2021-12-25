package org.yyc.yycspongeconfiglib;

import org.spongepowered.api.asset.Asset;
import org.spongepowered.configurate.ConfigurationNode;
import org.yyc.yycspongeconfiglib.Assets.YamlAssetsManager;
import org.yyc.yycspongeconfiglib.Nodes.YamlNodeManager;

public class Test {

    private final ConfigurationNode configurationNode;

    private final YamlAssetsManager yam;

    private final YamlNodeManager ynm;

    public Test(){
        yam = new YamlAssetsManager(YycSpongeConfigLib.pluginContainer);
        Asset asset = yam.getAsset("config.yml");
        yam.createLocalFile(asset);
        configurationNode = yam.loadNode("config.yml");
        ynm = new YamlNodeManager(configurationNode);
        test();
    }

    public void test(){
       for(String s : ynm.getStringList("Test1.Test2")){
           System.out.println(s);
       }
        System.out.println("getDouble: " + ynm.getDouble("Test1.Test3.Test4.Money"));
        System.out.println("getInt: " + ynm.getDouble("Test1.Test3.Test4.Age"));
        System.out.println("getString: " + ynm.getString("Test1.Test3.Test4.Name"));
    }
}
