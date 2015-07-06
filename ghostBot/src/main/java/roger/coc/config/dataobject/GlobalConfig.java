package roger.coc.config.dataobject;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author zirui.wzr
 * 全局配置对象
 */
public class GlobalConfig {
	private String name;
	private Common common;
	private Train train;
	private List<Strategy> strategys=Lists.newArrayList();
}
