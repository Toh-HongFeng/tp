package seedu.moneymind;

import java.util.Scanner;

import seedu.moneymind.command.Command;
import seedu.moneymind.command.InvalidCommandException;
import seedu.moneymind.command.Parser;
import seedu.moneymind.storage.Storage;

public class Moneymind {
    private Parser parser;
    private Storage storage;
    private Ui ui;
    private Scanner in;

    public Moneymind() {
        this.parser = new Parser();
        this.storage = new Storage();
        this.ui = new Ui();
        this.in = new Scanner(System.in);
    }

    public void run() {
        ui.greet();
        boolean isExit = false;
        storage.load();
        while (!isExit) {
            try {
                Command command = parser.parseNextCommand(in.nextLine());
                if (command.isExit()) {
                    ui.goodbye();
                    isExit = true;
                } else {
                    command.execute(ui); // should also accept storage object as parameter
                }
            } catch (InvalidCommandException e) {
                e.showErrorMessage();
            } catch (Exception e) {
                ui.error(e);
            }
        }
        storage.save();
    }

    public static void main(String[] args) {
        new Moneymind().run();
    }
}