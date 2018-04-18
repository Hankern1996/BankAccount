package com.example.hannahkern.bankaccount.database;

/**
 * Created by hannahkern on 18.04.18.
 */

public class AccountDbSchema {
    public static final class AccountTable {
        public static final String NAME = "users";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String PASSWORD = "password";
            public static final String BALANCE = "balnace";
        }
    }
}
