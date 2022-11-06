//
//  ContractorInvoiceViewController.swift
//  BidMe
//
//  Created by Axel Mora on 11/3/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class ContractorInvoiceViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var descriptionLabel: UILabel!
    @IBOutlet var tableView: UITableView!
    
    var jobTitle = " "
    let lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    var nameData = [String]()
    var priceData = [String]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = jobTitle
        print(jobTitle)
        print(nameData)
        print(priceData)

        
        let nib = UINib(nibName: "ListingDetailsCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingDetailsCell")
        tableView.delegate = self
        tableView.dataSource = self
        
        descriptionLabel.text = lorem
        
        // Do any additional setup after loading the view.
    }
            
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print("You tapped me!")
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nameData.count
    }

    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ListingDetailsCell", for: indexPath) as! ListingDetailsCell
        
        cell.contractorLabel?.text = nameData[indexPath.row]
        cell.priceLabel?.text = priceData[indexPath.row]
        return cell
    }
}
