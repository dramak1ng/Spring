package web.exception;

public class UserNotFoundExp extends RuntimeException {

    public UserNotFoundExp(int id){
        super("Пользователь "+id+ " не найден");
    }

}
