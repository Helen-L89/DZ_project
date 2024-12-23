package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CoursesPage;

public class CoursesTest extends BaseTest {
    @Test
    public void testCourseCount() {
        driver.get("https://otus.ru/test-section");
        CoursesPage coursesPage = new CoursesPage(driver);

        int courseCount = coursesPage.getCourseCount();
        Assertions.assertEquals(10, courseCount, "Количество курсов должно быть 10.");
    }
}
