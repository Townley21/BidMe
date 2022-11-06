//
//  ViewController.swift
//  BidMe
//
//  Created by Axel Mora on 9/13/22.
//

import UIKit

class ProfileViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet var username: UILabel!
    @IBOutlet var fullName: UILabel!
    @IBOutlet var email: UILabel!
    @IBOutlet var image: UIImageView!
    @IBOutlet var tableView: UITableView!
    
    var nameData = ["Tree Trimming", "Carpet Installation"]
    var addressData = ["One University Dr, Camarillo, CA 93012", "One University Dr, Camarillo, CA 93012"]
    var priceData = ["1400.00", "2300.00"]
    
    var invoiceNameData0 = ["Labor", "Materials"]
    var invoicePriceData0 = ["900.00", "400.00"]
    
    var invoiceNameData1 = ["Labor", "Materials"]
    var invoicePriceData1 = ["1500.00", "800.00"]
    
    let lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    var index = 0

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        title = "Profile"
        username?.text = "@HGoat23"
        fullName?.text = "Henry Goat"
        email?.text = "Henry.goat@gmail.com"
        
        //circular image (crops edges off of square photo)
        image.layer.borderWidth = 1
        image.layer.masksToBounds = false
        image.layer.borderColor = UIColor.black.cgColor
        image.layer.cornerRadius = image.frame.height / 2
        image.clipsToBounds = true
        
        //History Table setup
        let nib = UINib(nibName: "ListingTableViewCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: "ListingTableViewCell")
        tableView.delegate = self
        tableView.dataSource = self
        
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return addressData.count
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.index = indexPath.row
        performSegue(withIdentifier: "InvoiceSeg", sender: self)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ListingTableViewCell", for: indexPath) as! ListingTableViewCell
        
        cell.addressLabel?.text = addressData[indexPath.row]
        cell.bidCountLabel?.text = ""
        cell.nameLabel?.text = nameData[indexPath.row]
        cell.bidStaticLabel?.text = "$" + priceData[indexPath.row]
        cell.descriptionLabel?.text = lorem
        return cell
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
