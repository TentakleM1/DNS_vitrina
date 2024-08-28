package ru.dns.vitrina.server.storage.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.dns.vitrina.server.model.Message;
import ru.dns.vitrina.server.storage.inheritance.MessageStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageDatabaseStorage implements MessageStorage {
    private final JdbcTemplate jdbcTemplate;
    //static final int SIZE_MPA = 5;

    @Override
    public Map<Integer, Message> getAllMessage() {
        Map<Integer, Message> allMessage = new HashMap<>();
        String sqlQuery = "SELECT * FROM massege;";
        List<Message> messagesFromDb = jdbcTemplate.query(sqlQuery, this::mapRowToMessage);
        for (Message message : messagesFromDb) {
            allMessage.put(message.getId(), message);
        }
        return allMessage;
    }

    @Override
    public Optional<Message> getMessage(Integer id) {
//        if (id > SIZE_MPA) {
//            throw new NotFoundException("Данного рейтинга не существует по id" + id);
//        }
        String sqlQuery = "SELECT * FROM message WHERE id = ?";
        SqlRowSet messageRows = jdbcTemplate.queryForRowSet(sqlQuery, id);
        if (messageRows.next()) {
            Message message = new Message(messageRows.getInt("id"), messageRows.getString("name"));
            log.info("Найден шаблон сообщения с id {}", id);
            return Optional.of(message);
        }
        return Optional.empty();
    }

    private Message mapRowToMessage(ResultSet rs, int rowNum) throws SQLException {
        return new Message(rs.getInt("id"), rs.getString("name"));
    }
}
