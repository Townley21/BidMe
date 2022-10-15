//
//  CreateBidViewController.swift
//  BidMe
//
//  Created by Brandon Townley on 10/2/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class CreateBidViewController: UIViewController, UITextFieldDelegate, UITextViewDelegate {

    @IBOutlet var titleField: UITextField!
    @IBOutlet var descriptionField: UITextView!
    @IBOutlet var addressField: UITextField!
    @IBOutlet var radiusField: UITextField!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
       
        configureTextFields()
        configureTapGesture()
        
    }

    private func configureTextFields() {
        titleField.delegate = self
        descriptionField.delegate = self
        descriptionField.text = "Description"
        descriptionField.textColor = .systemBlue
        addressField.delegate = self
        radiusField.delegate = self
    }
    
    private func configureTapGesture() {
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(CreateBidViewController.handleTap))
        view.addGestureRecognizer(tapGesture)
    }
    
    @objc func handleTap() {
        print("Handle tap was called")
        view.endEditing(true)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        
        return true
    }
    
    func textViewShouldReturn(_ textView: UITextView) -> Bool {
        textView.resignFirstResponder()
        
        return true
    }
    
    
    func textViewDidBeginEditing(_ textView: UITextView) {
        if textView.textColor == .systemBlue {
            textView.text = ""
            textView.textColor = .black
        }
    }
    
    func textViewDidEndEditing(_ textView: UITextView) {
        if textView.text == "" {
            textView.text = "Description"
            textView.textColor = .systemBlue
        }
    }
    
    
    @IBAction func submitPressed(_ sender: Any) {
        view.endEditing(true)
    }
    
}
