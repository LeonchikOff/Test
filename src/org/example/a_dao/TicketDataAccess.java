package org.example.a_dao;

import org.example.a_dao.util.ConnectionManager;
import org.example.b_model.entity.Ticket;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDataAccess implements DataAccessibleObject<Ticket, Long> {
    private static final TicketDataAccess DATA_ACCESS = new TicketDataAccess();

    private TicketDataAccess() {
    }

    public static TicketDataAccess getDataAccess() {
        return DATA_ACCESS;
    }

    //language=PostgreSQL
    private static final String SQL_FIND_ALL_BY_FLIGHT_ID =
            "select id, passenger_number, passenger_name, flight_id, seat_number, cost " +
            "from ticket " +
            "where flight_id = ?;";

    public List<Ticket> findAllTicketsByFlightId(Long flightId) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL_BY_FLIGHT_ID)) {
            preparedStatement.setObject(1, flightId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                tickets.add(populateTicketEntity(resultSet));
            return tickets;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    private Ticket populateTicketEntity(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_number", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Long.class),
                resultSet.getObject("seat_number", String.class),
                resultSet.getObject("cost", BigDecimal.class)
        );
    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }
}
