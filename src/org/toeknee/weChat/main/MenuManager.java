package org.toeknee.weChat.main;

/**
 * Created by toeknee on 11/26/15.
 */

import org.toeknee.signUp.menu.Button;
import org.toeknee.signUp.menu.ClickButton;
import org.toeknee.signUp.menu.ComplexButton;
import org.toeknee.signUp.menu.Menu;
import org.toeknee.signUp.menu.ViewButton;
import org.toeknee.signUp.pojo.Token;
import org.toeknee.signUp.util.CommonUtil;
import org.toeknee.signUp.util.MenuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);
    private static String appID = "wx831edd6b0f4c18fc";
    private static String appSecret = "d4624c36b6795d1d99dcf0547af5443d";
    /**
     * menu structure
     *
     * @return menu
     */
    private static Menu getMenu() {
        ClickButton btn11 = new ClickButton();
        btn11.setName("课程注册");
        btn11.setType("click");
        btn11.setKey("enrollClass");

        ClickButton btn12 = new ClickButton();
        btn12.setName("课程签到");
        btn12.setType("click");
        btn12.setKey("signIn");

        ClickButton btn21 = new ClickButton();
        btn11.setName("课程创建");
        btn11.setType("click");
        btn11.setKey("registerClass");

        ViewButton btn22 = new ViewButton();
        btn12.setName("签到情况");
        btn12.setType("view");
        btn12.setKey("signStatus");

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("我是学生");
        mainBtn1.setSub_button(new Button[] { btn11, btn12 });

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("我是老师");
        mainBtn2.setSub_button(new Button[] { btn21, btn22 });

        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2 });

        return menu;
    }

    public static void main(String[] args) {
        Token token = CommonUtil.getToken(appID, appSecret);

        if (null != token) {
            boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());

            // check if create the menu successfully
            if (result)
                log.info("create menu success!");
            else
                log.info("create menu fail!");
        }
    }
}
