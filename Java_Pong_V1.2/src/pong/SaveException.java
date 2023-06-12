package pong;

import java.io.IOException;

public class SaveException extends IOException {
    public SaveException(String message) {
        super(message);
    }

    public SaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
