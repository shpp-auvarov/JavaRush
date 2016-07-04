package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public final static class Constants {
        public final static String SERVER_NOT_ACCESSIBLE_EXCEPTION = "Server is not accessible for now.";
        public final static String UNAUTHORIZED_USER_EXCEPTION = "User is not authorized.";
        public final static String BANNED_USER_EXCEPTION = "User is banned.";
        public final static String RESTRICTION_EXCEPTION = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Solution.Constants.SERVER_NOT_ACCESSIBLE_EXCEPTION);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Solution.Constants.SERVER_NOT_ACCESSIBLE_EXCEPTION, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Solution.Constants.UNAUTHORIZED_USER_EXCEPTION);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Solution.Constants.UNAUTHORIZED_USER_EXCEPTION, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Solution.Constants.BANNED_USER_EXCEPTION);
        }

        public BannedUserException(Throwable cause) {
            super(Solution.Constants.BANNED_USER_EXCEPTION, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Solution.Constants.RESTRICTION_EXCEPTION);
        }

        public RestrictionException(Throwable cause) {
            super(Solution.Constants.RESTRICTION_EXCEPTION, cause);
        }
    }
}
