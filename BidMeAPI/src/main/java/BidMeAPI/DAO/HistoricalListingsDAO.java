package BidMeAPI.DAO;

import BidMeAPI.Model.HistoricalListing;
import BidMeAPI.Model.Listing;
import BidMeAPI.Model.User;

import java.sql.SQLException;

public interface HistoricalListingsDAO {

    public HistoricalListing createHistoricalListing(Listing listing, User user) throws SQLException;

    public HistoricalListing getHistoricalListing(int listingID, int userID) throws SQLException;

    public void updateHistoricalListing(Listing listing, User user) throws SQLException;

    public void deleteHistoricalListing(Listing listing, User user) throws SQLException;

}
