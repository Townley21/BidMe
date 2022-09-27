package BidMeAPI.Service;

import BidMeAPI.Model.Bid;

import java.sql.SQLException;

public interface BidService {
    public Bid createBid(Bid bid) throws SQLException;

    public Bid getBid(int id) throws SQLException;

    public void deleteBid(int bidID) throws SQLException;

    public void updateBid(Bid bid) throws SQLException;

}
