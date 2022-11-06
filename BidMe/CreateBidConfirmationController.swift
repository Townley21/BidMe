//
//  CreateBidConfirmationController.swift
//  BidMe
//
//  Created by Axel Mora on 10/14/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class CreateBidConfirmationController: UIViewController {

    
    
    @IBOutlet var confirmationButton: UIButton!
    @IBOutlet weak var confirmationField: UITextView!
    
    var confirmationText = String()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        confirmationField.text = confirmationText
    }
    
    @IBAction func confirmPressed(_ sender: Any) {
            showAlert()
    }
    
    func showAlert() {
        let alert = UIAlertController(title: "Confirmation", message: "This will create a new post with the given information. Do you wish to post this?", preferredStyle: .alert)
        
        alert.addAction(UIAlertAction(title: "Cancel Post", style: .destructive, handler: {
                action in print("Tapped Cancel Button.")
        })  )
        
        //handle processing of adding bid to db
        alert.addAction(UIAlertAction(title: "Yes, Post This!", style: .default, handler: {
                _ in print("Approved")
        })  )

        
        
        present(alert, animated: true)
        
    }

}
