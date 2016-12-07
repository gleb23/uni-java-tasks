package edu.hlibbabii.mailapplication9;

/**
 * Created by hlib on 07.12.16.
 */
public class Email {
    private final String to;
    private final String subject;
    private final String text;

    public Email(Builder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.text = builder.text;
    }

    public static class Builder {
        private String to;
        private String subject;
        private String text;

        public Builder setTo(String to) {
            this.to = to;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }


}
