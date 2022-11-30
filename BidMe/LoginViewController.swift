//
//  LoginViewController.swift
//  BidMe
//
//  Created by Tim Oshea on 10/24/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController, UITextViewDelegate {
    //Variables
    
    var bRec:Bool = true
    var userEmail = "BidMe@gmail.com"
    var userPassword = "BidMe"

    @IBOutlet weak var emailTF: UITextField!
    @IBOutlet weak var passwordTF: UITextField!
    @IBOutlet weak var emailError: UILabel!
    @IBOutlet weak var passwordError: UILabel!
    
    
    @IBOutlet weak var loginButton: UIButton!
    
    //Functions
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        var user: User = User()
        var listings: [Listing] = [Listing()]
        var listings0: [Listing] = [Listing()]
        user = UserController.getUser(from: "BidMe@gmail.com")
        listings0 = ListingController.getAllListingsByNULLID()
        listings = ListingController.getAllListingsByUserID(from: "1")
        print(listings0)
        resetForm()
    }
    
    func resetForm() {
        loginButton.isEnabled = false
        emailError.isHidden = false
        
        emailError.text = "Required"
        passwordError.text = "Required"
        emailTF.text = ""
        passwordTF.text = ""
    }
    
    @IBAction func loginAction(_ sender: Any) {
        
        resetForm()
    }
    
    @IBAction func emailChanged(_ sender: Any) {
        if let email = emailTF.text {
            if let errorMessage = invalidEmail(email) {
                emailError.text = errorMessage
                emailError.isHidden = false
            } else {
                emailError.isHidden = true
            }
        }
        checkForValidForm()
    }
    
    func invalidEmail(_ value: String) -> String? {
        let reqularExpression = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"
                let predicate = NSPredicate(format: "SELF MATCHES %@", reqularExpression)
                if !predicate.evaluate(with: value) {
                    return "Invalid Email Address"
                }
                
                return nil
    }
    
    @IBAction func passwordChanged(_ sender: Any) {
        if let password = passwordTF.text
                {
                    if let errorMessage = invalidPassword(password)
                    {
                        passwordError.text = errorMessage
                        passwordError.isHidden = false
                    }
                    else
                    {
                        passwordError.isHidden = true
                    }
                }
                
                checkForValidForm()
    }
    
    func invalidPassword(_ value: String) -> String?
        {
            if value.count < 8
            {
                return "Password must be at least 8 characters"
            }
            if containsDigit(value)
            {
                return "Password must contain at least 1 digit"
            }
            if containsLowerCase(value)
            {
                return "Password must contain at least 1 lowercase character"
            }
            if containsUpperCase(value)
            {
                return "Password must contain at least 1 uppercase character"
            }
            return nil
        }
    
    func containsDigit(_ value: String) -> Bool
        {
            let reqularExpression = ".*[0-9]+.*"
            let predicate = NSPredicate(format: "SELF MATCHES %@", reqularExpression)
            return !predicate.evaluate(with: value)
        }
        
        func containsLowerCase(_ value: String) -> Bool
        {
            let reqularExpression = ".*[a-z]+.*"
            let predicate = NSPredicate(format: "SELF MATCHES %@", reqularExpression)
            return !predicate.evaluate(with: value)
        }
        
        func containsUpperCase(_ value: String) -> Bool
        {
            let reqularExpression = ".*[A-Z]+.*"
            let predicate = NSPredicate(format: "SELF MATCHES %@", reqularExpression)
            return !predicate.evaluate(with: value)
        }
    
    func checkForValidForm() {
        if emailError.isHidden && passwordError.isHidden {
            loginButton.isEnabled = true
        } else {
            loginButton.isEnabled = false
        }
    }
    
   
}

