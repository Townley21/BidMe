//
//  ActiveJobsViewController.swift
//  BidMe
//
//  Created by Axel Mora on 11/3/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class ActiveJobsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    
    @IBOutlet var tableView: UITableView!
    
    
    let nameData = ["New Roof", "Lawn removal", "concrete slab", "Turf installation", "Painting"]
    let addressData = ["123 fake street", "789 horror avenue", "308 Negra Arroyo Lane", "742 Evergreen Terrace", "P Sherman 42 Wallaby Way"]
    
    //Segue Data
    var index = 0
    
    //BidsData
    var bidNameData0 = ["Chuck", "Sarah", "Mike"]
    var bidPriceData0 = ["$23/hr", "$24/hr", "$29/hr"]
    
    var bidNameData1 = ["Jeff", "Zack", "Kristy"]
    var bidPriceData1 = ["$20/hr", "$22/hr", "$24/hr"]
    
    var bidNameData2 = ["Linda", "Heather", "Maria"]
    var bidPriceData2 = ["$45/hr", "$46/hr", "$45/hr"]
    
    var bidNameData3 = ["Will", "Max", "Brycen"]
    var bidPriceData3 = ["$56/hr", "$38/hr", "$44/hr"]
    
    var bidNameData4 = ["Tony", "Gustavo", "Vinny"]
    var bidPriceData4 = ["$20/hr", "$17/hr", "$25/hr"]
    
    let lorem = "Lorem ipsum dolor sit amet, consec tetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Get nib (ListingTableViewCell.nib) and register it to this table
        let nib = UINib(nibName: "ListingTableViewCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingTableViewCell")
        tableView.delegate = self
        tableView.dataSource = self
        
        //Navbar
        title = "Available Listings"
        
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.index = indexPath.row
        performSegue(withIdentifier: "ContractorInvoiceSeg", sender: self)
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let dest = segue.destination as! ContractorInvoiceViewController
        let ListingsNameData = [bidNameData0, bidNameData1, bidNameData2, bidNameData3, bidNameData4]
        let ListingsPriceData = [bidPriceData0, bidPriceData1, bidPriceData2, bidPriceData3, bidPriceData4]
        
        dest.titleOfJob = nameData[index]
        dest.nameData = ListingsNameData[index]
        dest.priceData = ListingsPriceData[index]
    }

    //TableView Funcs
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nameData.count
    }
    
    //return cell to table view
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //Define custom cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "ListingTableViewCell",
                                                 for: indexPath) as! ListingTableViewCell
        
        cell.nameLabel?.text = nameData[indexPath.row]
        cell.addressLabel?.text = addressData[indexPath.row]
        cell.bidCountLabel?.text = "7"
        cell.descriptionLabel?.text = lorem
        return cell
    }
}
