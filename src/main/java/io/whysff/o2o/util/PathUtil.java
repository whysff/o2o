package io.whysff.o2o.util;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/06/26
 */
public class PathUtil {

    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image";
        } else {
            basePath = "/Users/baidu/work/image";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getShopImagePath(Long shopId) {
        String imagePath = "/upload/images/item/shop/" + shopId +"/";
        return imagePath.replace("/",seperator);
    }
}
