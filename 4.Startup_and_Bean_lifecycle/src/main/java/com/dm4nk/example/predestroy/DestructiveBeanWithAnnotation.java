package com.dm4nk.example.predestroy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

import static com.dm4nk.common.Constants.DESTRUCTIVE_BEAN;
import static com.dm4nk.common.Constants.FILE_PATH;
import static java.util.Objects.isNull;

@Slf4j
@Getter
@Setter
@Builder
public class DestructiveBeanWithAnnotation {
    private File file;
    private String filePath;

    public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DestructiveBeanWithAnnotationConfig.class);
        ctx.getBean(DESTRUCTIVE_BEAN);
        ctx.registerShutdownHook();
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        log.debug("Initializing Bean");

        if (isNull(filePath)) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithAnnotation.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        log.debug("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        log.debug("Destroying Bean");

        if (!file.delete()) {
            log.error("ERROR: failed to delete file.");
        }

        log.debug("File exists: " + file.exists());
    }

    @Configuration
    @NoArgsConstructor
    private static class DestructiveBeanWithAnnotationConfig {

        @Lazy
        @Bean(name = DESTRUCTIVE_BEAN)
        DestructiveBeanWithAnnotation destructiveBean() {
            return DestructiveBeanWithAnnotation.builder()
                    .filePath(FILE_PATH)
                    .build();
        }
    }
}
