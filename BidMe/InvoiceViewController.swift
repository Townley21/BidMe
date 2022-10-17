//
//  InvoiceViewController.swift
//  BidMe
//
//  Created by Brandon Townley on 10/16/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class InvoiceViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var titleLabel: UILabel!
    @IBOutlet var descriptionLabel: UILabel!
    @IBOutlet var tableView: UITableView!
    @IBOutlet var totalPriceLabel: UILabel!
    
    var totalprice = " "
    var titleOfJob = " "
    
    let lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    var nameData = [String]()
    var priceData = [String]()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let nib = UINib(nibName: "ListingDetailsCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingDetailsCell")
        tableView.delegate = self
        tableView.dataSource = self
        
        descriptionLabel.text = lorem
        titleLabel.text = titleOfJob
        totalPriceLabel.text = totalprice
        
        // Do any additional setup after loading the view.
    }
    
    @IBAction func goBack(_ sender: Any) {
        presentingViewController?.dismiss(animated: true, completion: nil)
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
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
