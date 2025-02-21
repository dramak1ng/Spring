package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;


public class MainApp {
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());
    public static void main(String[] args) throws SQLException {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(new User("danila","joplub","email",new Car("lada granta",15)));
        userService.add(new User("reqwe","erqer","emaerq",new Car("lada priora",16)));
        logger.info(String.valueOf(userService.getUserByCarSerialAndModel("lada granta",15)));
        List<User> users = userService.listUsers();
        for (User user : users) {
          logger.info(user.toString());
        }

        context.close();
    }
}

