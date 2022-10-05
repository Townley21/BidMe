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
    
    let nameData = ["New Roof", "Lawn removal", "concrete slab", "Turf installation", "Painting"]
    let priceData = ["437.45", "345.34", "678.00", "456.90", "180.65"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Get nib (ListingTableViewCell.nib) and register it to this table
        let nib = UINib(nibName: "ListingTableViewCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingTableViewCell")
        
        tableView.delegate = self
        tableView.dataSource = self
        
    }

    //TableView Funcs
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nameData.count
    }
    
    //return cell to table view
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ListingTableViewCell",
                                                 for: indexPath) as! ListingTableViewCell
        cell.nameLabel?.text = nameData[indexPath.row]
        cell.priceLabel?.text = priceData[indexPath.row]
        return cell
    }
    
    
}


