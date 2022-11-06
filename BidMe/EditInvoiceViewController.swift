//
//  EditInvoiceViewController.swift
//  BidMe
//
//  Created by Jerin Sharif on 11/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class EditInvoiceViewController: UIViewController, UITableViewDelegate, UITableViewDataSource,
    MyCellDelegate{
        
    @IBOutlet weak var addCostDescription: UITextView!
        @IBOutlet weak var addCostAmount: UITextField!
        @IBOutlet var titleLabel: UILabel!
        @IBOutlet var descriptionLabel: UILabel!
        @IBOutlet var tableView: UITableView!
        @IBOutlet var totalPriceLabel: UILabel!
        
        var nameData = [String]()
        var priceData = [String]()
        var getsDeleted = Bool()
        var totalprice = " "
        var titleOfJob = "A job Title"
        var index = 0
        let lorem = "A description here..."

        override func viewDidLoad() {
            super.viewDidLoad()
            
            let nib = UINib(nibName: "EditInvoiceCell", bundle: nil)
            tableView.register(nib, forCellReuseIdentifier: "EditInvoiceCell")
            tableView.delegate = self
            tableView.dataSource = self
            
            descriptionLabel.text = lorem
            titleLabel.text = titleOfJob
            totalPriceLabel.text = totalprice
            title = "Invoice"
            // Do any additional setup after loading the view.
        }
        func btnCloseTapped(cell: EditInvoiceCell) {
            //Get the indexpath of cell where button was tapped
            print("worked?")
        }

        @IBAction func addCost(_ sender: Any) {
            nameData.append(addCostDescription.text!)
            priceData.append(addCostAmount.text!)
            tableView.reloadData()
        }
    
        func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
            return nameData.count
        }
        
        func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
            let cell = tableView.dequeueReusableCell(withIdentifier: "EditInvoiceCell", for: indexPath) as! EditInvoiceCell
            cell.contractorLabel?.text = nameData[indexPath.row]
            cell.priceLabel?.text = priceData[indexPath.row]
            //7. delegate view controller instance to the cell
            cell.delegate = self
            return cell
        }
    // This function is called before the segue
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {

   
        let secondViewController = segue.destination as! ContractorInvoiceViewController

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
