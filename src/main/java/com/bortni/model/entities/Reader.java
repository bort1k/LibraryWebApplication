package com.bortni.model.entities;

public class Reader {
    private final int id;
    private final String email;
    private final String password;
    private final String telephoneNumber;

    public Reader(int id, String email, String password, String telephoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public static class ReaderBuilder{
        private int id;
        private String email;
        private String password;
        private String telephoneNumber;

        public ReaderBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public ReaderBuilder setEmail(final String email) {
            this.email = email;
            return this;
        }

        public ReaderBuilder setPassword(final String password) {
            this.password = password;
            return this;
        }

        public ReaderBuilder setTelephoneNumber(final String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Reader build(){
            return new Reader(id, email, password, telephoneNumber);
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
