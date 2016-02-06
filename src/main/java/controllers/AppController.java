package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * В контроллере один незащищенный ресурс и два пути к ресурсам,
 * доступ к которым ограничен ролями администратора (admin)
 * и супер администратора (superadmin)
 */
@Controller
public class AppController {
    /**
     * Публичный доступ (никаких ограничений безопасности)
     */
    @RequestMapping(value = {"/", "/helloworld**"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Пример работы со Spring Security");
        model.addObject("message", "Публичный доступ (эта страница доступна всем пользователяем без авторизации)");
        model.setViewName("helloworld");
        return model;
    }

    /**
     * Только для администраторов (пользователей с ролью администратор)
     */
    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Пример работы со Spring Security - protected");
        model.addObject("message", "This is protected page - Only for Admin Users!");
        model.setViewName("protected");
        return model;
    }

    /**
     * Только для супер-администраторов
     */
    @RequestMapping(value = "/confidential**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Пример работы со Spring Security - admin");
        model.addObject("message", "This is confidential page - Need Super Admin Role!");
        model.setViewName("protected");
        return model;
    }
}