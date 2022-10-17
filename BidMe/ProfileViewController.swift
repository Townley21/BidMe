//
//  ViewController.swift
//  BidMe
//
//  Created by Axel Mora on 9/13/22.
//

import UIKit

class ProfileViewController: UIViewController {
    
    @IBOutlet var username: UILabel!
    @IBOutlet var fullName: UILabel!
    @IBOutlet var email: UILabel!
    @IBOutlet var adress: UILabel!
    @IBOutlet var image: UIImageView!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        username?.text = "JohnnyBoy"
        fullName?.text = "John Doe"
        email?.text = "john.doe@gmail.com"
        adress?.text = "123 That Street"
        image.layer.cornerRadius = image.frame.size.width / 2
        image.clipsToBounds = true
        
        
    }


}

