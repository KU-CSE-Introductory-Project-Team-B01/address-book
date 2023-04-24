package kucse.introductoryproject.b01.dto;

import kucse.introductoryproject.b01.csvhandler.UserInfoHandler;

import static kucse.introductoryproject.b01.Main.scanner;

public class UserInfo extends UserData {
    private String id;
    private String password;

    public UserInfo() {

    }

    public UserInfo(String id, String password, String name, String phone, String address, String birthday) {
        super(name, phone, address, birthday);
        this.id = id;
        this.password = password;
    }

    public boolean isMatchingPassword(String password) {
        return this.password.equals(password);
    }

    public String getId() {
        return id;
    }

    public void setId() {
        do System.out.print("ID를 입력하세요\n> ");
        while (!validateId(scanner.nextLine().trim()));
        notifyObservers();
    }

    private boolean validateId(String id) {
        if (UserInfoHandler.getInstance().userInfoHashMap.isIdPresent(id)) {
            System.out.println("이미 존재하는 아이디입니다.");
        } else if (id.length() < 5)
            System.out.println("ID의 길이는 5 이상이어야 합니다.");
        else if (!id.matches("^[a-zA-Z0-9]*$"))
            System.out.println("ID는 알파벳 또는 숫자로만 이루어져야 합니다.");
        else {
            this.id = id;
            return true;
        }

        return false;
    }

    public void setPassword() {
        do System.out.print("비밀번호를 입력하세요\n> ");
        while (!validatePassword(scanner.nextLine().trim()));
        notifyObservers();
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8)
            System.out.println("암호의 길이는 8 이상이어야 합니다.");
        else if (password.matches(".*\\s.*"))
            System.out.println("암호는 공백 또는 탭을 포함할 수 없습니다.");
        else {
            this.password = password;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String str;
        str = "\n---------------------\n" +
                "ID : " + getId() + "\n" +
                "이름 : " + getName() + "\n" +
                "전화번호 : " + getPhone() + "\n" +
                "주소 : " + getAddress() + "\n" +
                "생년월일 : " + getBirthday() + "\n" +
                "---------------------\n";
        return str;
    }

    @Override
    public String toCsv() {
        return id + "\t" + password + "\t" + super.toCsv() + "\n";
    }
}
