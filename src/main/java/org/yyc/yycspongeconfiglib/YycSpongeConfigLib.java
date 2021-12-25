package org.yyc.yycspongeconfiglib;

import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.ConstructPluginEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

/**
 * An example Sponge plugin.
 *
 * <p>All methods are optional -- some common event registrations are included as a jumping-off point.</p>
 */
@Plugin("assets.yyc_sponge_lib")
public class YycSpongeConfigLib {

    private final PluginContainer container;

    private final Logger logger;

    public static PluginContainer pluginContainer;

    public static Logger log;

    @Inject
    YycSpongeConfigLib(final PluginContainer container, final Logger logger) {
        this.container = container;
        this.logger = logger;
        pluginContainer = container;
        log = logger;

    }

    @Listener
    public void onConstructPlugin(final ConstructPluginEvent event) {
        // Perform any one-time setup
        this.logger.info("Yyc-Sponge-Lib 已加载 —— 作者: 郁冬Yyc");
        // 提供测试的实例
        new Test();
    }
}