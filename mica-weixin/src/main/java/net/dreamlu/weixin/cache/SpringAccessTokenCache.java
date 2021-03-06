package net.dreamlu.weixin.cache;

import com.jfinal.weixin.sdk.cache.IAccessTokenCache;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;

/**
 * 基于 spring cache 的 weixin token 缓存
 *
 * @author L.cm
 */
@RequiredArgsConstructor
public class SpringAccessTokenCache implements IAccessTokenCache {
	private final static String ACCESS_TOKEN_PREFIX = "dream-weixin:token:";
	private final Cache cache;

	@Override
	public String get(String key) {
		return cache.get(ACCESS_TOKEN_PREFIX + key, String.class);
	}

	@Override
	public void set(String key, String jsonValue) {
		cache.put(ACCESS_TOKEN_PREFIX + key, jsonValue);
	}

	@Override
	public void remove(String key) {
		cache.evict(ACCESS_TOKEN_PREFIX + key);
	}
}
