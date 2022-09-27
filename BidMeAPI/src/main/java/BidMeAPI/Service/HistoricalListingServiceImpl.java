package BidMeAPI.Service;

import BidMeAPI.DAO.HistoricalListingsDAO;
import BidMeAPI.Model.HistoricalListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Primary
@Service
public class HistoricalListingServiceImpl implements HistoricalListingService {

    @Autowired
    HistoricalListingsDAO dao;

    @Override
    public HistoricalListing createHistoricalListing(HistoricalListing HListing) throws SQLException{
        return dao.createHistoricalListing(HListing);
    }

    @Override
    public HistoricalListing getHistoricalListing(int userID) throws SQLException{
        return dao.getHistoricalListing(userID);
    }

    @Override
    public void updateHistoricalListing(HistoricalListing HListing) throws SQLException{
        dao.updateHistoricalListing(HListing);
    }

    @Override
    public void deleteHistoricalListing(HistoricalListing Hlisting) throws SQLException{
        dao.deleteHistoricalListing(Hlisting);
    }

}
