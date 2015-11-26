package org.toeknee.signUp.util;

/**
 * Created by toeknee on 11/26/15.
 */

import net.sf.json.JSONObject;
import org.toeknee.signUp.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuUtil {
    private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

    public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * create the menu
     *
     * @param menu
     * @param accessToken
     * @return true or false
     */
    public static boolean createMenu(Menu menu, String accessToken) {
        boolean result = false;
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // convert menu object to JSON string
        String jsonMenu = JSONObject.fromObject(menu).toString();
        // send post request to create menu
        JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
            } else {
                result = false;
                log.error("create menu error errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }

        return result;
    }

    /**
     * get menu
     *
     * @param accessToken
     * @return menu in JSON string
     */
    public static String getMenu(String accessToken) {
        String result = null;
        String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
        // send get request to get menu
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            result = jsonObject.toString();
        }
        return result;
    }

    /**
     * delete menu
     *
     * @param accessToken
     * @return true or false
     */
    public static boolean deleteMenu(String accessToken) {
        boolean result = false;
        String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
        // send get request to delete menu
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            if (0 == errorCode) {
                result = true;
            } else {
                result = false;
                log.error("delete menu error errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return result;
    }
}