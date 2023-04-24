package kucse.introductoryproject.b01;

import kucse.introductoryproject.b01.csvhandler.ContactHandler;
import kucse.introductoryproject.b01.dto.UserInfo;
import kucse.introductoryproject.b01.utils.StringUtil;

import java.util.Scanner;

public class AddressBookHandler {
    private Scanner scanner;
    private AddressBook addressBook;

    public AddressBookHandler(Scanner scanner, AddressBook addressBook) {
        this.scanner = scanner;
        this.addressBook = addressBook;
    }

    public UserInfo executeCommands(UserInfo signedInUser) {
        displayHelpList();
        boolean loop = true;
        while (loop) {
            System.out.print("> ");
            String prompt = scanner.nextLine();

            switch (prompt.split(" ")[0]) {
                case "help" -> displayHelpList();
                case "logout" -> {
                    ContactHandler.destroyInstance();
                    signedInUser = null;
                    loop = false;
                }
                case "exit" -> loop = false;
                case "view" -> handleViewCommand(prompt.split(" "));
                case "search" -> handleSearchCommand(prompt.split(" "));
                case "add" -> addressBook.addContact();
                case "delete" -> addressBook.deleteContact();
                case "edit" -> addressBook.editContact();
                case "myprofile" -> addressBook.myProfile();
                default -> {
                    System.out.println("잘못된 입력입니다");
                    displayHelpList();
                }
            }
        }
        return signedInUser;
    }

    private void handleViewCommand(String[] input) {
        if (input.length == 1) {
            addressBook.viewAddressBook();
        } else {
            try {
                int page = Integer.parseInt(input[1]);
                addressBook.viewAddressBook(page);
            } catch (NumberFormatException e) {
                addressBook.viewAddressBook(input[1]);
            }
        }
    }

    private void handleSearchCommand(String[] input) {
        if (input.length < 2)
            System.out.println("입력 오류");
        else if (input.length < 3) {
            addressBook.searchContact(input[1]);
        } else if (!StringUtil.isNumber(input[2])) {
            System.out.println("입력 오류");
        } else {
            addressBook.searchContact(input[1], Integer.parseInt(input[2]));
        }
    }

    private void displayHelpList() {
        System.out.println("""
                ========================= 도 움 말 =========================
                - view <value> : 주소록 열람
                \t<value>가 페이지 수라면 그 페이지에 해당하는 주소록을 출력합니다
                \t<value>가 이름이라면 그 이름에 해당하는 연락처를 열람합니다
                - search <value1> <value2> : 주소록 검색
                \t<value1>의 내용을 포함하는 연락처들 중
                \t<value2>에 해당하는 페이지의 연락처들을 출력합니다
                - add 주소록 추가
                - edit : 열람하고 있는 연락처 수정
                - delete : 열람하고 있는 연락처 삭제
                - myprofile : 내 정보 수정
                - logout : 로그아웃
                - help : 도움말
                - exit : 프로그램 종료
                ===========================================================
                """);

    }
}