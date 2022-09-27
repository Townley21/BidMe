package BidMeAPI.Service;

import BidMeAPI.DAO.BidTableDAO;
import BidMeAPI.Model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Primary
@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidTableDAO dao;

    @Override
    public Bid createBid(Bid bid) throws SQLException{
        return dao.createBid(bid);
    }

    @Override
    public Bid getBid(int id) throws SQLException{
        return dao.getBid(id);
    }

    @Override
    public void deleteBid(int bidID) throws SQLException{
        dao.deleteBid(bidID);
    }

    @Override
    public void updateBid(Bid bid) throws SQLException{
        dao.updateBid(bid);
    }

}
