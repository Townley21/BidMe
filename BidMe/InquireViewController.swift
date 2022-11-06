//
//  InquireViewController.swift
//  BidMe
//
//  Created by Axel Mora on 11/3/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class InquireViewController: UIViewController {

    
    
    @IBOutlet weak var confirmationField: UITextView!
    
    var confirmationText = String()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        confirmationField.text = confirmationText
    }
    
}
