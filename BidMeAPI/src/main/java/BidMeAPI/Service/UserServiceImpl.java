package BidMeAPI.Service;

import BidMeAPI.DAO.UsersListDAO;
import BidMeAPI.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Primary
@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    UsersListDAO dao;

    @Override
    public User createUser(User user) throws SQLException{
        return dao.createUser(user);
    }

    @Override
    public User getUser(String email) throws SQLException{
        return dao.getUser(email);
    }

    @Override
    public User getUser(int id) throws SQLException {
        return dao.getUser(id);
    }

    @Override
    public void updateUser(User user)throws SQLException {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(User user)throws SQLException {
        dao.deleteUser(user);
    }

}