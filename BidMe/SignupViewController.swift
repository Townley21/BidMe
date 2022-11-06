//
//  SignupViewController.swift
//  BidMe
//
//  Created by Tim Oshea on 10/30/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class SignupViewController: UIViewController, UITextViewDelegate {
    
    @IBOutlet weak var emailTF: UITextField!
    @IBOutlet weak var passwordTF: UITextField!
    @IBOutlet weak var confirmTF: UITextField!
    
    @IBOutlet weak var emailError: UILabel!
    @IBOutlet weak var passwordError: UILabel!
    @IBOutlet weak var confirmError: UILabel!
    
    @IBOutlet weak var loginButton: UIButton!
    
    //Functions
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        resetForm()
    }
    
    func resetForm() {
        loginButton.isEnabled = false
        emailError.isHidden = false
        passwordError.isHidden = false
        confirmError.isHidden = false
        
        
        emailError.text = "Required"
        passwordError.text = "Required"
        confirmError.text = "Required"
        
        emailTF.text = ""
        passwordTF.text = ""
        confirmTF.text = ""
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
    
    @IBAction func confirmChanged(_ sender: Any) {
        if let confirm = confirmTF.text {
            if let errorMessage = invalidConfirm(confirm) {
                confirmError.text = errorMessage
                confirmError.isHidden = false
            } else {
                confirmError.isHidden = true
            }
        }
        checkForValidForm()
    }
    
    func invalidConfirm(_ value: String) -> String? {
        if value != passwordTF.text {
            return "Passwords do not match"
        }
        return nil
    }
    
    func checkForValidForm() {
        if emailError.isHidden && passwordError.isHidden && confirmError.isHidden {
            loginButton.isEnabled = true
        } else {
            loginButton.isEnabled = false
        }
    }
}

