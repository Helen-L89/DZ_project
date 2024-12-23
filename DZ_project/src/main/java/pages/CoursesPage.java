package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CoursesPage {
    private WebDriver driver;

    private By courseCards = By.cssSelector(".course-card");
    private By courseName = By.cssSelector(".course-card__title");
    private By courseDescription = By.cssSelector(".course-card__description");
    private By courseDuration = By.cssSelector(".course-card__duration");
    private By courseFormat = By.cssSelector(".course-card__format");

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCourseCount() {
        return driver.findElements(courseCards).size();
    }

    public CourseDetails getCourseDetails(int index) {
        List<WebElement> courses = driver.findElements(courseCards);
        WebElement course = courses.get(index);
        String name = course.findElement(courseName).getText();
        String description = course.findElement(courseDescription).getText();
        String duration = course.findElement(courseDuration).getText();
        String format = course.findElement(courseFormat).getText();

        return new CourseDetails(name, description, duration, format);
    }

    public static class CourseDetails {
        public String name;
        public String description;
        public String duration;
        public String format;

        public CourseDetails(String name, String description, String duration, String format) {
            this.name = name;
            this.description = description;
            this.duration = duration;
            this.format = format;
        }
    }
}
