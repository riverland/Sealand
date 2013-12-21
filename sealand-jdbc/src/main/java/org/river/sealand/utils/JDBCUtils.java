package org.river.sealand.utils;

import java.util.Properties;

/**
 * <p>
 * jdbc相关工具方法
 * 
 * @author river
 * @since Dec 21, 2013
 */
public class JDBCUtils {

	/**
	 * <p>
	 * 解析jdbc url
	 * 
	 * @param url
	 * @return
	 */
	public static Properties parseUrl(String url, Properties dft) {
		if (url == null || "".equals(url.trim())) {
			return null;
		}
		Properties urlProps = new Properties(dft);

		String svrUrl = url;
		String urlArgs = "";

		int pos = url.indexOf('?');
		if (pos != -1) {
			svrUrl = url.substring(0, pos);
			urlArgs = url.substring(pos + 1);
		}

		if (!svrUrl.startsWith(Constant.CON_PREFIX)) {
			return null;
		}
		svrUrl = svrUrl.substring("jdbc:postgresql:".length());

		String port = Constant.CON_DEFAULT_PORT;
		String host = Constant.LOCALHOST;
		String dbName = svrUrl;
		if (svrUrl.startsWith("//")) {
			svrUrl = svrUrl.substring(2);
			int slash = svrUrl.indexOf('/');
			if (slash == -1) {
				return null;
			}

			dbName = svrUrl.substring(slash + 1);
			int portIdx = svrUrl.lastIndexOf(':');
			port = svrUrl.substring(portIdx + 1);
			host = svrUrl.substring(0, portIdx);
		}

		urlProps.setProperty(Constant.CON_PROPS_DBNAME, dbName);
		urlProps.setProperty(Constant.CON_PROPS_PORT, port);
		urlProps.setProperty(Constant.CON_PROPS_HOST, host);

		// 解析参数
		String[] args = urlArgs.split("&");
		for (int i = 0; i < args.length; ++i) {
			String token = args[i];
			if (token.length() == 0) {
				continue;
			}
			int l_pos = token.indexOf('=');
			if (l_pos == -1) {
				urlProps.setProperty(token, "");
			} else {
				urlProps.setProperty(token.substring(0, l_pos), token.substring(l_pos + 1));
			}
		}
		return urlProps;

	}
}
