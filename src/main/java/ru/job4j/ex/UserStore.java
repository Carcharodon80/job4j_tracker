package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                rsl = user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException();
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((user.getUsername().length() < 3) || (!user.isValid())) {
            throw new UserInvalidException();
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Ro", true)
        };
        try {
            User user = findUser(users, "Ro");
            if (validate(user)) {
                System.out.println("This is user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("User invalid");
        }
        catch (UserNotFoundException e) {
            System.out.println("User not found");
        }
    }
}
