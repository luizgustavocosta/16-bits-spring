package com.costa.luiz.mocks.domain;

import java.util.List;

public class CustomerEntity {

    private final String id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dob;
    private final List<String> phones;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public List<String> getPhones() {
        return phones;
    }

    public CustomerEntity(String id, String firstName, String middleName, String lastName, String dob, List<String> phones) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.phones = phones;
    }

    public static final class CustomerEntityBuilder {
        private String id;
        private String firstName;
        private String middleName;
        private String lastName;
        private String dob;
        private List<String> phones;

        private CustomerEntityBuilder() {
        }

        public static CustomerEntityBuilder aCustomerEntity() {
            return new CustomerEntityBuilder();
        }

        public CustomerEntityBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CustomerEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerEntityBuilder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public CustomerEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerEntityBuilder withDob(String dob) {
            this.dob = dob;
            return this;
        }

        public CustomerEntityBuilder withPhones(List<String> phones) {
            this.phones = phones;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(id, firstName, middleName, lastName, dob, phones);
        }
    }
}
