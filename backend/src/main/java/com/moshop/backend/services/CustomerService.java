package com.moshop.backend.services;

import com.moshop.backend.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    /**
     * Creates a new customer with the provided details and saves it to the database.
     *
     * @param customer The customer object containing the details of the customer to be created.
     */
    void createCustomer(Customer customer);

    /**
     * Retrieves a list of all customers from the database.
     *
     * @return A list of customer objects representing all the customers.
     */
    List<Customer> getCustomers();

    /**
     * Retrieves a customer from the database based on the provided customer ID.
     *
     * @param customerId The ID of the customer to retrieve.
     * @return An optional containing the customer if found, or an empty optional if not found.
     */
    Optional<Customer> getCustomer(String customerId);

    /**
     * Deletes a customer from the database based on the provided customer ID.
     *
     * @param customerId The ID of the customer to delete.
     * @throws IllegalArgumentException if the customer ID is null or empty.
     */
    void deleteCustomer(String customerId);

    /**
     * Updates the details of a customer with the provided customer ID.
     *
     * @param customerId The ID of the customer to update.
     * @param customer   The updated customer object with new details.
     */
    void updateCustomer(String customerId, Customer customer);

    /**
     * Counts the total number of customers in the database.
     *
     * @return The total number of customers.
     */
    long countAll();

    /**
     * Retrieves a list of active customers from the database.
     *
     * @return A list of active customer objects.
     */
    List<Customer> getActiveCustomer();

    /**
     * Performs customer login by verifying the provided email and password.
     *
     * @param email    The email of the customer.
     * @param password The password of the customer.
     * @return An optional containing the customer if the login is successful, or an empty optional if the login fails.
     */
    Optional<Customer> customerLogin(String email, String password);
}
