package com.moshop.backend.services;

import com.moshop.backend.model.dto.CustomerRequestDTO;
import com.moshop.backend.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    /**
     * <h3>Creates a new customer with the provided details and saves it to the database.</h3>
     *
     * @param customerRequestDTO The customer object containing the details of the customer to be created.
     */
    void createCustomer(CustomerRequestDTO customerRequestDTO);

    /**
     * <h3>Retrieves a list of all customers from the database.</h3>
     *
     * @return A list of customer objects representing all the customers.
     */
    List<Customer> getCustomers();

    /**
     * <h3>Retrieves a customer from the database based on the provided customer ID.</h3>
     *
     * @param customerId The ID of the customer to retrieve.
     * @return An optional containing the customer if found, or an empty optional if not found.
     */
    Optional<Customer> getCustomer(String customerId);

    /**
     * <h3>Deletes a customer from the database based on the provided customer ID.</h3>
     *
     * @param customerId The ID of the customer to delete.
     * @throws IllegalArgumentException if the customer ID is null or empty.
     */
    void deleteCustomer(String customerId);

    /**
     * <h3>Updates the details of a customer with the provided customer ID.</h3>
     *
     * @param customerId The ID of the customer to update.
     * @param customerRequestDTO  The updated customer object with new details.
     */
    void updateCustomer(String customerId, CustomerRequestDTO customerRequestDTO);

    /**
     *<h3> Counts the total number of customers in the database.</h3>
     *
     * @return The total number of customers.
     */
    long countAll();

    /**
     * <h3>Retrieves a list of active customers from the database.</h3>
     *
     * @return A list of active customer objects.
     */
    List<Customer> getActiveCustomer();

    /**
     * <h3>Performs customer login by verifying the provided email and password.</h3>
     *
     * @param email    The email of the customer.
     * @param password The password of the customer.
     * @return An optional containing the customer if the login is successful, or an empty optional if the login fails.
     */
    Optional<Customer> customerLogin(String email, String password);
}
