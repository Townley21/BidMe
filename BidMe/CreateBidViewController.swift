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
    @IBOutlet var submitButton: UIButton!
    
    
    @IBOutlet weak var titleError: UILabel!
    @IBOutlet weak var descriptionError: UILabel!
    @IBOutlet weak var addressError: UILabel!
    @IBOutlet weak var radiusError: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        title = "Create Listing"
        resetForm()
        configureTextFields()
        configureTapGesture()
        
    }
    
    func resetForm() {
        submitButton.isEnabled = false
        
        titleError.isHidden = false
        descriptionError.isHidden = false
        addressError.isHidden = false
        radiusError.isHidden = false
        
        titleError.text = "Required"
        descriptionError.text = "Required"
        addressError.text = "Required"
        radiusError.text = "Required"
    }
    
    func checkForValidForm() {
        
        if titleError.isHidden && descriptionError.isHidden && addressError.isHidden && radiusError.isHidden {
            submitButton.isEnabled = true
        }
        else {
            submitButton.isEnabled = false
        }
        
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
            descriptionError.isHidden = false
        }
      
    }
    
    func textViewDidChange(_ textView: UITextView) {
        if textView.text == "" {
            descriptionError.isHidden = false
        }
        else {
            descriptionError.isHidden = true
        }
    }
  
    
    func textViewDidEndEditing(_ textView: UITextView) {
        if textView.text == "" {
            textView.text = "Description"
            textView.textColor = .systemBlue
            descriptionError.isHidden = false
        }
        else {
            descriptionError.isHidden = true
        }
        checkForValidForm()
    }
    
    
    
    @IBAction func titleChanged(_ sender: Any) {
        
        if titleField.text == "" {
            titleError.isHidden = false
        }
        else {
            titleError.isHidden = true
        }
        checkForValidForm()
    }
    
    
    @IBAction func addressChanged(_ sender: Any) {
        
        if addressField.text == "" {
            addressError.isHidden = false
        }
        else {
            addressError.isHidden = true
        }
        checkForValidForm()
    }
    
    
    @IBAction func radiusChanged(_ sender: Any) {

        if radiusField.text == "" {
            radiusError.isHidden = false
        }
        else {
            radiusError.isHidden = true
        }
        checkForValidForm()
    }
    
    
    @IBAction func submitPressed(_ sender: Any) {
        view.endEditing(true)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "Confirmation" {
            let destinationController = segue.destination as! CreateBidConfirmationController
            destinationController.confirmationText = "Post Preview (Scrollable): " + "\n\n"
                                                    + "Title: " + titleField.text! + "\n\n"
                                                    + "Description: " + descriptionField.text! + "\n\n"
                                                    + "Address: " + addressField.text! + "\n\n"
                                                    + "Radius (mi.): " + radiusField.text! + "\n\n"
        }
    }
    
}
