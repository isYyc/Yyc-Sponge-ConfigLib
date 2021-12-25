package org.yyc.yycspongeconfiglib.Nodes;

import io.leangen.geantyref.TypeToken;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.List;

@SuppressWarnings("unused")
public class YamlNodeManager {

    private final ConfigurationNode configurationNode;

    public YamlNodeManager(ConfigurationNode configurationNode){
        this.configurationNode = configurationNode;
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link String}
     *
     * 如果没有找到对应节点，返回 null
     */
    public String getString(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return null;
        return node.getString();
    }

    /**
     * 
     * @param path 节点路径
     * @return 对应节点后的 {@link Integer}
     *
     * 如果没有找到对应节点，返回 0
     */
    public int getInt(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return 0;
        return node.getInt();
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link Double}
     *
     * 如果没有找到对应节点，返回 0
     */
    public double getDouble(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return 0;
        return node.getDouble();
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link Float}
     *
     * 如果没有找到对应节点，返回 0
     */
    public float getFloat(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return 0;
        return node.getFloat();
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link List<Object>}
     *
     * 如果没有找到对应节点，返回 null
     */
    public List<Object> getList(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return null;
        try {
            return node.getList(TypeToken.get(Object.class));
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link List<String>}
     *
     * 如果没有找到对应节点，返回 null
     */
    public List<String> getStringList(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return null;
        try {
            return node.getList(TypeToken.get(String.class));
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link List<Integer>}
     *
     * 如果没有找到对应节点，返回 null
     */
    public List<Integer> getIntList(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return null;
        try {
            return node.getList(TypeToken.get(Integer.class));
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link List<Double>}
     *
     * 如果没有找到对应节点，返回 null
     */
    public List<Double> getDoubleList(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return null;
        try {
            return node.getList(TypeToken.get(Double.class));
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param path 节点路径
     * @return 对应节点后的 {@link List<Float>}
     *
     * 如果没有找到对应节点，返回 null
     */
    public List<Float> getFloatList(String path){
        ConfigurationNode node = findDeepNode(path);
        if(node == null) return null;
        try {
            return node.getList(TypeToken.get(Float.class));
        } catch (SerializationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ConfigurationNode findDeepNode(String path){
        ConfigurationNode node = configurationNode.copy();
        if(path.contains(".")){
            String[] keys = path.split("\\.");
            for(String key : keys) {
                if(!node.childrenMap().containsKey(key)){
                    return null;
                }
                node = node.node(key);
            }
        } else {
            if(!node.childrenMap().containsKey(path)){
                return null;
            }
            node = configurationNode.node(path);
        }
        return node;
    }
}
