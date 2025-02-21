package web.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundExp.class)
    public String handleUserNotFoundException(UserNotFoundExp e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
