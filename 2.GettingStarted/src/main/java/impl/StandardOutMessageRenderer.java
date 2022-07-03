package impl;

import api.MessageProvider;
import api.MessageRenderer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StandardOutMessageRenderer implements MessageRenderer {
    private final static String ERROR_MSG = "You must set the messageProvider property";
    private MessageProvider messageProvider;

    public void render() {
        System.out.println(Objects.requireNonNull(
                messageProvider.getMessage(),
                ERROR_MSG));
    }
}
