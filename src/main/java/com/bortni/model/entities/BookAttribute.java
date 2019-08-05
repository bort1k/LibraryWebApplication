package com.bortni.model.entities;

public class BookAttribute {
    private final int id;
    private final String keyWord;
    private final Language language;

    private BookAttribute(int id, String keyWord, Language language) {
        this.id = id;
        this.keyWord = keyWord;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public Language getLanguage() {
        return language;
    }

    public static class BookAttributeBuilder {
        private int id;
        private String keyWord;
        private Language language;

        public BookAttributeBuilder() {
        }

        public BookAttributeBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public BookAttributeBuilder setKeyWord(final String keyWord) {
            this.keyWord = keyWord;
            return this;
        }

        public BookAttributeBuilder setLanguage(final Language language) {
            this.language = language;
            return this;
        }

        public BookAttribute build(){
            return new BookAttribute(this.id, this.keyWord, this.language);
        }
    }

    @Override
    public String toString() {
        return "BookAttribute{" +
                "id=" + id +
                ", keyWord='" + keyWord + '\'' +
                ", language=" + language +
                '}';
    }
}
