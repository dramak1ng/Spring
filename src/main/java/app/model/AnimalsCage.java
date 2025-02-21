package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AnimalsCage {
    Logger logger = Logger.getLogger(getClass().getName());

    @Qualifier("dog")
    @Autowired
    private Animal animal;
    @Autowired
    private Timer timer;


    public void whatAnimalSay() {
        logger.info("Say:");
        logger.info(animal.toString());
        logger.info("At:");
        logger.info(String.valueOf(new Timer().getTime()));
        logger.info("________________________");
    }
    public Timer getTimer() {
        return timer;
    }
}
