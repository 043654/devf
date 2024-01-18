package lv.dong.Dev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import static lv.dong.Dev.Go.Execute;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DevApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DevApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) {
        Go.Execute();
    }
}
