package BidMeAPI.Service;

import BidMeAPI.Model.HistoricalListing;

import java.sql.SQLException;

public interface HistoricalListingService {

    public HistoricalListing createHistoricalListing(HistoricalListing HListing) throws SQLException;

    public HistoricalListing getHistoricalListing(int userID) throws SQLException;

    public void updateHistoricalListing(HistoricalListing HListing) throws SQLException;

    public void deleteHistoricalListing(HistoricalListing Hlisting) throws SQLException;

}
