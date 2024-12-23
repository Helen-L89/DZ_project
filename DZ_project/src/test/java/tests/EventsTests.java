package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EventsPage;
import java.util.List;
import java.time.LocalDate;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.junit.jupiter.api.BeforeAll;


public class EventsTests extends BaseTest {


    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup(); // или WebDriverManager.chromedriver().setup();
    }


    @Test
    public void testEventDates() {
        // Переход в раздел календаря мероприятий
        /*driver.findElement(By.linkText("События")).click();
        driver.findElement(By.linkText("Календарь мероприятий")).click();

        // Получаем все карточки мероприятий
        List<WebElement> eventCards = driver.findElements(By.cssSelector(".event-card"));

        // Проверка, что дата мероприятия больше или равна текущей
        for (WebElement eventCard : eventCards) {
            String eventDate = eventCard.findElement(By.cssSelector(".event-date")).getText();
            // Преобразование строки с датой в объект Date и проверка
            Assertions.assertTrue(isDateGreaterThanOrEqualToCurrentDate(eventDate), "Дата мероприятия должна быть больше или равна текущей");
        }
    }

    private boolean isDateGreaterThanOrEqualToCurrentDate(String eventDate) {
        // Логика для проверки даты (сравнение с текущей датой)
        return true;
    }*/
        driver.get("https://otus.ru/events");

        // Явное ожидание появления элемента, чтобы удостовериться, что страница загружена
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".event-card")));


        EventsPage eventsPage = new EventsPage(driver);


        // Получаем список дат мероприятий
        List<LocalDate> eventDates = eventsPage.getEventDates();

        // Проверяем, что список не пуст
        Assertions.assertNotNull(eventDates, "Список дат не должен быть null");
        Assertions.assertFalse(eventDates.isEmpty(), "Список дат не должен быть пуст");

        // Проверка, что дата мероприятия не раньше текущей
        for (LocalDate date : eventDates) {
            Assertions.assertFalse(date.isBefore(LocalDate.now()),
                    "Дата мероприятия должна быть не раньше текущей даты: " + date);


        /*List<LocalDate> eventDates = eventsPage.getEventDates();
        for (LocalDate date : eventDates) {
            Assertions.assertFalse(date.isBefore(LocalDate.now()),
                    "Дата мероприятия должна быть не раньше текущей даты: " + date);*/
        }

    }

}
