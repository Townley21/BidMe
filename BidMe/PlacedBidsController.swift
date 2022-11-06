//
//  PlacedBidsController.swift
//  BidMe
//
//  Created by Axel Mora on 11/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class PlacedBidsController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var tableView: UITableView!
    
    
    let nameData = ["New Roof", "Lawn removal", "concrete slab", "Turf installation", "Painting"]
    let addressData = ["123 fake street", "789 horror avenue", "308 Negra Arroyo Lane", "742 Evergreen Terrace", "P Sherman 42 Wallaby Way"]
    
    //Segue Data
    var index = 0
    
    //BidsData
    var bidNameData0 = ["stark industries", "Camarillo Roofing", "Lampert Rooofing"]
    //var bidPriceData0 = ["6000.00", "5850.00", "5900.00", "5500.00"]
    
    var bidNameData1 = ["Pacific Lawn Care", "Grand Oak Landscape Maintence", "JC Landscaping"]
    //var bidPriceData1 = ["2000.00", "1600.00", "1400.00", "1200.00"]
    
    var bidNameData2 = ["Reinhart Concrete", "Ideal Concrete Worx"]
    //var bidPriceData2 = ["3400.00", "3600.00"]
    
    var bidNameData3 = ["TruGreen Lawn Care", "Turf Max", "TruGreen"]
    //var bidPriceData3 = ["900.00", "800.00", "750.00", "650.00"]
    
    var bidNameData4 = ["Tonys Painting"]
    //var bidPriceData4 = ["500.00"]
    
    let lorem = "Lorem ipsum dolor sit amet, consec tetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Get nib (ListingTableViewCell.nib) and register it to this table
        let nib = UINib(nibName: "BidsPlacedListCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "BidsPlacedListCell")
        tableView.delegate = self
        tableView.dataSource = self
        
        //Navbar
        title = "Bids Placed"
        
    }
    
    /*
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.index = indexPath.row
        performSegue(withIdentifier: "seg2", sender: self)
    }
     */
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let dest = segue.destination as! AvailListingDetailsViewController
        //let ListingsNameData = [bidNameData0, bidNameData1, bidNameData2, bidNameData3, bidNameData4]
        //let ListingsPriceData = [bidPriceData0, bidPriceData1, bidPriceData2, bidPriceData3, bidPriceData4]
        
        dest.jobTitle = nameData[index]
        //dest.nameData = ListingsNameData[index]
        //dest.priceData = ListingsPriceData[index]
    }

    //TableView Funcs
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nameData.count
    }
    
    
    //return cell to table view
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //Define custom cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "BidsPlacedListCell",
                                                 for: indexPath) as! BidsPlacedListCell
        
        cell.nameLabel?.text = nameData[indexPath.row]
        cell.addressLabel?.text = addressData[indexPath.row]
        //cell.bidCountLabel?.text = "$363.54"
        cell.descriptionLabel?.text = lorem
        return cell
    }
    
}
