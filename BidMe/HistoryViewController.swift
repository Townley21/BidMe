//
//  HistoryViewController.swift
//  BidMe
//
//  Created by Brandon Townley on 10/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class HistoryViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var tableView: UITableView!
    
    var index = 0
    
    var nameData = ["Tree Trimming", "Carpet Installation"]
    var addressData = ["something address", "another address"]
    var priceData = ["1400.00", "2300.00"]
    
    var invoiceNameData0 = ["Labor", "Materials"]
    var invoicePriceData0 = ["900.00", "400.00"]
    
    var invoiceNameData1 = ["Labor", "Materials"]
    var invoicePriceData1 = ["1500.00", "800.00"]

    override func viewDidLoad() {
        super.viewDidLoad()
        title = "History"
        
        let nib = UINib(nibName: "HistoryViewCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "HistoryViewCell")
        tableView.delegate = self
        tableView.dataSource = self

             
    }
    
    @IBAction func goToMap(_ sender: Any) {
        performSegue(withIdentifier: "MapSeg", sender: self)
    }
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return addressData.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "HistoryViewCell", for: indexPath) as! HistoryViewCell
        
        cell.addressLabel?.text = addressData[indexPath.row]
        cell.priceLabel?.text = priceData[indexPath.row]
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.index = indexPath.row
        performSegue(withIdentifier: "InvoiceSeg", sender: self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "InvoiceSeg" {
            let dest = segue.destination as! InvoiceViewController
            
            let invoiceNameData = [invoiceNameData0, invoiceNameData1]
            let invoicePriceData = [invoicePriceData0, invoicePriceData1]
            
            dest.nameData = invoiceNameData[index]
            dest.priceData = invoicePriceData[index]
            dest.titleOfJob = nameData[index]
            dest.totalprice = priceData[index]
        }
    }


}
