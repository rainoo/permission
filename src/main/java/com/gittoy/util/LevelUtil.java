package com.gittoy.util;

import org.apache.commons.lang3.StringUtils;

/**
 * LevelUtil
 * Create by GaoYu 2017/11/23 20:06
 */
public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
