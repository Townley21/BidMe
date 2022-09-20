package BidMeAPI.DAO;

import BidMeAPI.Model.HistoricalListing;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.SQLException;

public interface HistoricalListingsDAO {

    public HistoricalListing createHistoricalListing(HistoricalListing HListing) throws SQLException;

    public HistoricalListing getHistoricalListing(int userID) throws SQLException;

    public void updateHistoricalListing(HistoricalListing HListing) throws SQLException;

    public void deleteHistoricalListing(HistoricalListing Hlisting) throws SQLException;

}
