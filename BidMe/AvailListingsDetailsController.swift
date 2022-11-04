//
//  AvailListingsDetailsController.swift
//  BidMe
//
//  Created by Axel Mora on 11/1/22.
//  Copyright © 2022 BidMeTeam. All rights reserved.
//

import UIKit

class AvailListingDetailsViewController: UIViewController, UITableViewDelegate, UITextFieldDelegate {
    @IBOutlet var jobDescriptionLabel: UILabel!
    @IBOutlet var collectionView: UICollectionView!
    @IBOutlet var bidAmountField: UITextField!
    @IBOutlet var inquireButton: UIButton!
    @IBOutlet var placeBidButton: UIButton!
    
    @IBOutlet weak var bidAmountError: UILabel!
    
    var jobTitle = " "
    let lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = jobTitle
        print(jobTitle)
        
        jobDescriptionLabel.text = lorem
        
        
        let layout = UICollectionViewFlowLayout()
        layout.itemSize = CGSize(width: 201, height: 114)
        collectionView.collectionViewLayout = layout
        
        collectionView.register(ListingPhotoCollectionViewCell.nib(), forCellWithReuseIdentifier: ListingPhotoCollectionViewCell.identifier)
        
        collectionView.delegate = self
        collectionView.dataSource = self
        
        resetForm()
        configureTextFields()
        configureTapGesture()
    }
    
    
    
    
    func resetForm() {
        placeBidButton.isEnabled = false
        
        bidAmountError.isHidden = false
        
        bidAmountError.text = "Required"
    }
    
    func checkForValidForm() {
        
        if bidAmountError.isHidden {
            placeBidButton.isEnabled = true
        }
        
        else {
            placeBidButton.isEnabled = false
        }
        
    }
    
    private func configureTextFields() {
        bidAmountField.delegate = self
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
    
    @IBAction func bidAmountChanged(_ sender: Any) {
        
        if bidAmountField.text == "" {
            bidAmountError.isHidden = false
        }
        else {
            bidAmountError.isHidden = true
        }
        checkForValidForm()
    }
    
    
    @IBAction func placeBidButtonPressed(_ sender: Any) {
        view.endEditing(true)
        showAlert()
    }
    
        
    func showAlert() {
        let alert = UIAlertController(title: "Confirmation", message: "This will post a bid for the following amount: $" + bidAmountField.text! +  "\nDo you wish to send this bid?", preferredStyle: .alert)
        
        alert.addAction(UIAlertAction(title: "Cancel Bid", style: .destructive, handler: {
                action in print("Tapped Cancel Button.")
        })  )
        
        alert.addAction(UIAlertAction(title: "Yes, Post This Bid!", style: .default, handler: {
            action in print("Tapped Yes Button.")
        })  )
                
        present(alert, animated: true)
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "inquireSeg" {
            let destinationController = segue.destination as! InquireViewController
            destinationController.confirmationText = "Name: Henry Goat \n\n"
                                                    + "Phone: (123) 456-7891 \n\n"
                                                    + "Address: 123 Fake Street \n\n"
                                                    + "E-Mail: Henry.goat@gmail.com \n\n"
        }
    }

}



extension AvailListingDetailsViewController: UICollectionViewDelegate{
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        collectionView.deselectItem(at: indexPath, animated: true)
        
        print("You tapped me")
    }
}
extension AvailListingDetailsViewController: UICollectionViewDataSource{
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 9
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: ListingPhotoCollectionViewCell.identifier, for: indexPath) as! ListingPhotoCollectionViewCell
        
        cell.configure(with: UIImage(named: "cubeMan")!)
        
        return cell
    }
}

extension AvailListingDetailsViewController: UICollectionViewDelegateFlowLayout{
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: 120, height: 120)
    }
}
