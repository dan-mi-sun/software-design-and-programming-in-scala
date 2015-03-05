package dao;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    public void addCustomer(Customer c) throws DataAccessException, SQLException;

    public Customer getCustomer(String id) throws DataAccessException;

    public List getCustomers() throws DataAccessException;

    public void removeCustomer(String id) throws DataAccessException;

    public void modifyCustomer(Customer c) throws DataAccessException;
}