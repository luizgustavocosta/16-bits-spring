package com.costa.luiz.mocks.domain;

public class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String fullName;
    private final String dob;

    private Customer(String id, String firstName, String lastName, String fullName, String dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.dob = dob;
    }


    public static final class CustomerBuilder {
        private String id;
        private String firstName;
        private String lastName;
        private String fullName;
        private String dob;

        private CustomerBuilder() {
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public CustomerBuilder withDob(String dob) {
            this.dob = dob;
            return this;
        }

        public Customer build() {
            return new Customer(id, firstName, lastName, fullName, dob);
        }
    }
}
