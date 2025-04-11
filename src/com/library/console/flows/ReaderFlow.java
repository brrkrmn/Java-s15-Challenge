package com.library.console.flows;

import com.library.console.Flow;
import com.library.models.MemberRecord;
import com.library.models.MemberType;
import com.library.models.person.Reader;
import com.library.service.LibraryService;
import com.library.service.MemberRecordService;
import com.library.service.ReaderService;
import com.library.utils.Input;

public class ReaderFlow extends Flow {
    private final LibraryService libraryService;
    private final Input input = new Input();
    private Reader reader;
    private MemberRecordService memberRecordService;
    private ReaderService readerService;

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
                case 1:
                    printPrompt("Enter the id of the book you want to borrow");
                    printGoBackPrompt();
                    String id = input.readLine();

                    if (id.equals("00")) {
                        break;
                    }

                    if (libraryService.getBook(id) == null) {
                        printPrompt("This book does not exist in the library.");
                        continue;
                    }

                    readerService.borrowBook(libraryService.getBook(id));
                    break;
                case 2:
                    readerService.showBorrowedBooks();
                    printPrompt("Enter the id of the book you want to return");
                    printGoBackPrompt();
                    String returnId = input.readLine();

                    if (returnId.equals("00")) {
                        break;
                    }

                    if (libraryService.getBook(returnId) == null) {
                        printPrompt("This book does not exist in the library.");
                        continue;
                    }

                    readerService.returnBook(libraryService.getBook(returnId));
                    break;
                case 3:
                    printPrompt("Enter the id of the book you want to purchase");
                    printGoBackPrompt();
                    String purchaseId = input.readLine();

                    if (purchaseId.equals("00")) {
                        break;
                    }
                    if (libraryService.getBook(purchaseId) == null) {
                        printPrompt("This book does not exist in the library.");
                        continue;
                    }

                    readerService.purchaseBook(libraryService.getBook(purchaseId));
                    break;
                case 4:
                    readerService.showBorrowedBooks();
                    break;
                case 5:
                    readerService.showPurchasedBooks();
                    break;
                case 6:
                    printPrompt(libraryService.getBooks().toString());
                    break;
                case 7:
                    printPrompt(libraryService.getAuthors().toString());
                    break;
                case 8:
                    searchBooks(libraryService);
                    break;
                case 9: memberRecordService.viewMemberCard();
            }
        }
    }

    @Override
    public int showActions() {
        printPrompt(reader.getName() + ", what do you want to do?");
        printOptions(true,
                "Borrow a book",
                "Return a book",
                "Purchase a book",
                "Show borrowed books",
                "Show purchased books",
                "Show all books",
                "Show all authors",
                "Search books",
                "View member data"
        );
        return input.readIntRange(0, 9);
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

        String accessKey;
        while (true) {
             accessKey = input.readLine("Create an access key");
             if (accessKey.length() < 3 || accessKey.length() > 10) {
                 printPrompt("Access key must be minimum 3 and maximum 10 characters");
                 continue;
             }
             break;
        }

        MemberRecord memberRecord = new MemberRecord(reader, memberType, address, phone, accessKey);
        readerService = new ReaderService(reader);
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
}
