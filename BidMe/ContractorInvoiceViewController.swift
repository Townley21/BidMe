//
//  ContractorInvoiceViewController.swift
//  BidMe
//
//  Created by Jerin Sharif on 11/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//


import UIKit

class ContractorInvoiceViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    

    @IBOutlet var titleLabel: UILabel!
    @IBOutlet var descriptionLabel: UILabel!
    @IBOutlet var tableView: UITableView!
    @IBOutlet var totalPriceLabel: UILabel!
    
    var nameData = [String]()
    var priceData = [String]()
    var totalprice = " "
    var titleOfJob = " "
    
    let lorem = "A description here..."

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let nib = UINib(nibName: "ListingDetailsCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingDetailsCell")
        tableView.delegate = self
        tableView.dataSource = self
        
        descriptionLabel.text = lorem
        titleLabel.text = titleOfJob
        totalPriceLabel.text = totalprice
        title = "Invoice"
        // Do any additional setup after loading the view.
    }
    
    
    @IBAction func editInvoice(_ sender: Any) {
        performSegue(withIdentifier: "EditInvoiceSeg", sender: self)
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
    // This function is called before the segue
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {

   
        let secondViewController = segue.destination as! EditInvoiceViewController

        secondViewController.nameData = nameData
        secondViewController.priceData = priceData
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
