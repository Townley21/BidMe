//
//  ListingsViewController.swift
//  BidMe
//
//  Created by Brandon Townley on 10/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class ListingsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var tableView: UITableView!
    
    //ListingData
    let nameData = ["New Roof", "Lawn removal", "concrete slab", "Turf installation", "Painting"]
    let addressData = ["123 fake street", "789 horror avenue", "308 Negra Arroyo Lane", "742 Evergreen Terrace", "P Sherman 42 Wallaby Way"]
    
    //Segue Data
    var index = 0
    
    //BidsData
    var bidNameData0 = ["stark industries", "Camarillo Roofing", "Lampert Rooofing"]
    var bidPriceData0 = ["6000.00", "5850.00", "5900.00", "5500.00"]
    
    var bidNameData1 = ["Pacific Lawn Care", "Grand Oak Landscape Maintence", "JC Landscaping"]
    var bidPriceData1 = ["2000.00", "1600.00", "1400.00", "1200.00"]
    
    var bidNameData2 = ["Reinhart Concrete", "Ideal Concrete Worx"]
    var bidPriceData2 = ["3400.00", "3600.00"]
    
    var bidNameData3 = ["TruGreen Lawn Care", "Turf Max", "TruGreen"]
    var bidPriceData3 = ["900.00", "800.00", "750.00", "650.00"]
    
    var bidNameData4 = ["Tonys Painting"]
    var bidPriceData4 = ["500.00"]
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Get nib (ListingTableViewCell.nib) and register it to this table
        let nib = UINib(nibName: "ListingTableViewCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingTableViewCell")
        
        tableView.delegate = self
        tableView.dataSource = self
        
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.index = indexPath.row
        performSegue(withIdentifier: "seg", sender: self)
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let dest = segue.destination as! ListingDetailsViewController
        let ListingsNameData = [bidNameData0, bidNameData1, bidNameData2, bidNameData3, bidNameData4]
        let ListingsPriceData = [bidPriceData0, bidPriceData1, bidPriceData2, bidPriceData3, bidPriceData4]
        
        dest.jobTitle = nameData[index]
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
        return cell
    }
}


