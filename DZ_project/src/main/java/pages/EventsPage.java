package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventsPage {
    private WebDriver driver;

    // Локатор для карточек мероприятий
    private By eventCards = By.cssSelector(".event-card");
    // Локатор для дат мероприятий
    private By eventDate = By.cssSelector(".event-card__date");

    public EventsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Получить даты всех мероприятий на странице.
     *
     * @return Список дат мероприятий.
     */
    public List<LocalDate> getEventDates() {
        List<WebElement> eventElements = driver.findElements(eventCards);
        List<LocalDate> eventDates = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // Укажите формат даты

        for (WebElement event : eventElements) {
            String dateText = event.findElement(eventDate).getText();
            LocalDate date = LocalDate.parse(dateText, formatter);
            eventDates.add(date);
        }

        return eventDates;
    }
}