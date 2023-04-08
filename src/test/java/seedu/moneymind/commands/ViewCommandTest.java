package seedu.moneymind.commands;

import org.junit.jupiter.api.Test;
import seedu.moneymind.event.Event;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewCommandTest extends CommandTest {

    public ViewCommandTest() {
        super();
    }

    @Test
    void viewCommand_viewAll_expectEverythingToBePrintedOut() {
        setup();
        Event nutrition = new Event("nutrition", 100, "10/10/2010 12:00");
        food.addEvent(nutrition);
        String terminalOutput = executeInput("view").toString();
        String expected = "Category: food (budget: 0)" + System.lineSeparator()
                + "1." + salad + System.lineSeparator()
                + "2." + pizza + System.lineSeparator()
                + "3." + nutrition + System.lineSeparator()
                + "Category: book (budget: 0)" + System.lineSeparator()
                + "1." + harryPotter + System.lineSeparator()
                + "2." + lordOfTheRings + System.lineSeparator();
        assertEquals(expected, terminalOutput);
        clear();
    }

    @Test
    void viewCommand_viewOneCategory_expectCategoryToBePrintedOut() {
        setup();
        String terminalOutput = executeInput("view food").toString();
        String expected = "1." + salad + System.lineSeparator()
                + "2." + pizza + System.lineSeparator();
        assertEquals(expected, terminalOutput);
        clear();
    }

}
