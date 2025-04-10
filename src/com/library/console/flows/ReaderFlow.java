package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.MemberRecord;
import com.library.models.MemberType;
import com.library.models.Reader;
import com.library.service.LibraryService;
import com.library.service.MemberRecordService;
import com.library.utils.Input;

public class ReaderFlow extends Flow {
    private final LibraryService libraryService;
    private final Input input = new Input();
    private Reader reader;
    private MemberRecordService memberRecordService;

    public ReaderFlow(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void run() {
        initializeReader();

        if (reader.getMemberRecord() == null) {
            createMember();
        } else {
            boolean isVerified = verifyMember();
            if (!isVerified) {
                printPrompt("Returning to main menu...");
                return;
            }
        }

        while (true) {
            int actionNo = showActions();
            switch (actionNo) {
                case 0: return;
                case 1: ;
            }
        }
    }

    public void initializeReader() {
        String name = input.readLine("Welcome, reader. What is your name?");

        if (isNullOrEmpty(name)) {
            printPrompt("You must have a name :)");
            return;
        }

        if (isNumeric(name)) {
            printPrompt("We don't believe your name has a number in it...");
            return;
        }

        Reader existingReader = libraryService.getLibrary().getReaders().values().stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (existingReader == null) {
            this.reader = new Reader(name);
            libraryService.getLibrary().getReaders().put(reader.getId(), reader);
        } else {
            this.reader = existingReader;
        }
    }

    public void createMember() {
        printPrompt("Since you're new here, you need to create a member record to continue.");

        printPrompt("Select a member card.");
        printOptions(false,
                MemberType.STUDENT.getMemberType() + " (15$) - Book Limit: 5",
                MemberType.FACULTY.getMemberType() + " (30$) - Book Limit: 20");
        MemberType memberType = MemberType.fromInt(input.readIntRange(1, 2));

        String address = input.readLine("Enter your address");
        String phone = input.readLine("Enter your phone number");
        String accessKey = input.readLine("Create an access key");

        MemberRecord memberRecord = new MemberRecord(reader, memberType, address, phone, accessKey);
        reader.setMemberRecord(memberRecord);
        memberRecordService = new MemberRecordService(memberRecord);
        memberRecordService.createInvoice();
    }

    public boolean verifyMember() {
        String accessKey = input.readLine("You have to log in with your member access key to continue.");
        boolean isVerified = accessKey.equals(reader.getMemberRecord().getAccessKey());
        System.out.println(isVerified
                ? "Welcome back, " + reader.getName()
                : "Incorrect password, returning to main menu...")
        ;
        return isVerified;
    }

    public int showActions() {
        printPrompt(reader.getName() + ", what do you want to do?");
        printOptions(true,
                "Borrow a book",
                "Return a book",
                "Search books",
                "Show all books",
                "Show all authors",
                "Search books",
                "View member data"
        );
        return input.readIntRange(0, 7);
    }
}
