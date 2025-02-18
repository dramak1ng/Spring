import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class App {
    private final static Logger logger  = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");
        logger.info(bean.getMessage());
        Cat catBean = applicationContext.getBean("cat", Cat.class);
        Cat catBean2 = applicationContext.getBean("cat", Cat.class);
        boolean compare = bean == bean2;
        boolean compare2 = catBean == catBean2;
        logger.info("сравнение hellowordBean: " + compare);
        logger.info("сравнение catBean: " + compare2);
    }
}
