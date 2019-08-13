package com.bortni.model.entities;

import java.sql.Time;

public class Order {
    private final int id;
    private final Reader reader;
    private final Book book;
    private final Time time;

    private Order(int id, Reader reader, Book book, Time time) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public Time getTime() {
        return time;
    }

    public static class OrderBuilder{
        private int id;
        private Reader reader;
        private Book book;
        private Time time;

        public OrderBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder setReader(final Reader reader) {
            this.reader = reader;
            return this;
        }

        public OrderBuilder setBook(final Book book) {
            this.book = book;
            return this;
        }

        public OrderBuilder setTime(final Time time) {
            this.time = time;
            return this;
        }

        public Order build(){
            return new Order(id, reader, book, time);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reader=" + reader +
                ", book=" + book +
                ", time=" + time +
                '}';
    }
}
