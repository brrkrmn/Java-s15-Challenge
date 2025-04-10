package com.library.console;

import com.library.utils.DataHelper;
import com.library.utils.Input;
import com.library.utils.UIHelper;

public abstract class Flow implements DataHelper, UIHelper {
    private final Input input = new Input();

    public abstract void run();
    public abstract int showActions();

    public String askName(String prompt) {
        printPrompt(prompt);
        while (true) {
            String name = input.readLine();

            if (isNullOrEmpty(name)) {
                printPrompt("You must have a name, right? What is it?");
                continue;
            }

            if (isNumeric(name) || containsInteger(name)) {
                printPrompt("Come on, we know your name is not " + name);
                continue;
            }
            return name;
        }
    }


}
