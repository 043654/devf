package lv.dong.Dev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.testng.TestNG;
import org.testng.collections.Lists;
import java.util.List;

/**
 * @author Donglee
 * @version 1.0
 * @description: TODO
 * @date 2023/12/11 15:30
 */
@Slf4j
@Component
public class Go {

    public static final String FILEPATHNG = System.getProperty("user.dir") + "\\src\\main\\";

    public static void Execute() {
        TestNG tng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(FILEPATHNG + "testng.xml");
        tng.setTestSuites(suites);
        tng.run();
    }
}
