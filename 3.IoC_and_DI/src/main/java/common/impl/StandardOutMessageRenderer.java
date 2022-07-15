package common.impl;

import common.api.MessageProvider;
import common.api.MessageRenderer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("renderer")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StandardOutMessageRenderer implements MessageRenderer {
    private final static String ERROR_MSG = "You must set the messageProvider property";

    @Autowired
    private MessageProvider messageProvider;

    public void render() {
        System.out.println(Objects.requireNonNull(
                messageProvider.getMessage(),
                ERROR_MSG));
    }
}
